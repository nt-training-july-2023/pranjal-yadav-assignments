package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.exception.ValidationException;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.validation.Validation;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Service class that handles operations related to users.
 */
@Service
public class UserService {
    /**
     * UserRepository autowired for adding to database.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * ModelMapper autowired to map dto to entity and vice versa.
     */
    @Autowired
    private ModelMapper modelMapper;
    /**
     * PasswordEncoder autowired to encode password.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    public static String decodePassword(String pwd) {
        byte[] decodedBytes = Base64.getDecoder().decode(pwd);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
    public final UserDto addUser(final UserDto userDto) {
//        String encodedPassword = passwordEncoder.encode(UserDto.getPassword());
//        UserDto.setPassword(encodedPassword);

        //checking null data
        Validation valid = new Validation();
        if (valid.validEmptyData(userDto.getUserId())) {
            throw new ValidationException(
                    "Employee id should not be empty");
        }

        //checking email
         if (!valid.checkEmail(userDto.getEmail())) {
             throw new ValidationException(
                     "Email Id should ends with @nucleusteq.com");
         }if (!userRepository.findByEmail(userDto.getEmail()).isEmpty()) {
             throw new ResourceAlreadyExistsException(userDto.getEmail() + " Already Exists");
         }
             modelMapper.getConfiguration()
                     .setMatchingStrategy(MatchingStrategies.STRICT);
             User user = this.modelMapper.map(userDto, User.class);
             userRepository.save(user);
             return userDto;

    }
    public final LoginDto login(final LoginDto loginDto) {
        Validation valid = new Validation();
        if (valid.validEmptyData(loginDto.getEmail())) {
            throw new ValidationException("Email Id should not be empty");
        }
        if (valid.validEmptyData(loginDto.getPassword())) {
            throw new ValidationException("Password should not be empty");
        }
        User user = userRepository.
                findByEmail(loginDto.getEmail()).orElseThrow(() -> new
                        ResourceNotFoundException("Email id does'not exist"));
        System.out.println(user);
        System.out.println(decodePassword(loginDto.getPassword()));

        if (user != null && passwordEncoder.matches(decodePassword(loginDto.getPassword()),
                user.getPassword())) {
            return loginDto;
        }
        return null;

    }

    public final String saveEmp(final UserDto userDto){
//        Validation valid = new Validation();
//        if(valid.checkEmail(userDto.getEmail())==false ||
//        valid.checkName(userDto.getName())==false ||
//        valid.checkId(userDto.getUserId())==false ||
//        valid.checkPhone(userDto.getContactNo())==false ){
//            throw new IllegalArgumentException("Give valid credentials");
//        }
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        User user = this.modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return user.getName();
    }

//    public final List<UserDto> getAllEmp(){
//
//        List<User> employees = userRepository.findAllEmployees();
//        List<UserDto> employeesDto = new ArrayList<>();
//        for(User user : employees){
//            modelMapper.getConfiguration()
//                    .setMatchingStrategy(MatchingStrategies.STRICT);
//            employeesDto.add(this.modelMapper.map(user, UserDto.class));
//        }
//        return employeesDto;
//    }

    public final List<UserDto> getAllManagers(){

        List<User> employees = userRepository.findAllManagers();
        List<UserDto> employeesDto = new ArrayList<>();
        for(User user : employees){
            modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.STRICT);
            employeesDto.add(this.modelMapper.map(user, UserDto.class));
        }
        return employeesDto;
    }
}
