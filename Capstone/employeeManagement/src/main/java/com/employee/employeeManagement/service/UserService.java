package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.Admin;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.AdminDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public final String addUser(final UserDto UserDto) {
        String encodedPassword = passwordEncoder.encode(UserDto.getPassword());
        UserDto.setPassword(encodedPassword);
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        User user = this.modelMapper.map(UserDto, User.class);
        userRepository.save(user);
        return user.getName();
    }
    public final String login(final LoginDto loginDto) {
        User user = userRepository.
                findByEmail(loginDto.getEmail()).orElseThrow(() -> new
                        ResourceNotFoundException(""));
        System.out.println(user);
        if (user != null && passwordEncoder.matches(loginDto.getPassword(),
                user.getPassword())) {

            return "Successful";
        }
        return null;

    }


}
