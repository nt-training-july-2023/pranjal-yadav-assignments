package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.validation.Validation;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
    /**
     * Validation autowired to validate parameters.
     */
    @Autowired
    private Validation validation;
    /**
     * Decodes a Base64-encoded password string.
     *
     * @param pwd The Base64-encoded password.
     * @return The decoded password string.
     */
    public static String decodePassword(final String pwd) {
        byte[] decodedBytes = Base64.getDecoder().decode(pwd);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
    /**
     * Adds a new user.
     *
     * @param userDto The user details to be added.
     * @return The added user details.
     */
    public final UserDto addUser(final UserDto userDto) {
        if (validation.checkUser(userDto)) {
            modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.STRICT);
            User user = this.modelMapper.map(userDto, User.class);
            if (userRepository.findByEmail(user.getEmail()) != null) {
                throw new ResourceAlreadyExistsException(
                        "This email id already exists");
            }
            userRepository.save(user);
            return userDto;
        } else {
            return null;
        }

    }
    /**
     * Performs user login and returns the login DTO if successful.
     *
     * @param loginDto The login details.
     * @return The login DTO if successful, otherwise null.
     */
    public final User login(final LoginDto loginDto) {

        User user = userRepository.
                findByEmail(loginDto.getEmail()).orElseThrow(() -> new
                        ResourceNotFoundException("Email id does not exist"));
        System.out.println(user);
        System.out.println(decodePassword(loginDto.getPassword()));

        if (user != null && passwordEncoder.matches(
                decodePassword(loginDto.getPassword()),
                user.getPassword())) {
            return user;
        }
        return null;

    }
    /**
     * Saves an employee and returns the employee's name.
     *
     * @param userDto The employee details to be saved.
     * @return The name of the saved employee.
     */
    public final User saveEmp(final UserDto userDto) {
        if (userDto.getManagerId() == null && !userDto.getEmail().equals(
                "ankita.sharma@nucleusteq.com")) {
            userDto.setManagerId("N001");
        }
        if (!userRepository.findByEmail(userDto.getEmail()).isEmpty()) {
            throw new ResourceAlreadyExistsException("Email id already exists");
        }
        if (!userRepository.findByUserId(userDto.getUserId()).isEmpty()) {
            throw new ResourceAlreadyExistsException("User id already exists");
        }
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        User user = this.modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return user;
    }
}
