package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.exception.WrongCredentialsExceptions;
import com.employee.employeeManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;


/**
 * Utility class for performing various data validation operations.
 */
@Component
public class UserValidation {
    /**
     * User repository autowired.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * PasswordEncoder autowired to encode password.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

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
     * This method returns true if the name is valid.
     * @param name String that represents name.
     */
    public final void checkName(final String name) {
        if (!name.isEmpty() && name.matches("^[A-Za-z ]+$")) {
            return;
        } else {
            throw new WrongCredentialsExceptions("Give valid name.");
        }
    }

    /**
     * This method returns true if email is valid.
     * @param email String that represents email.
     */
    public final void checkEmail(final String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            return;
        } else {
            throw new ResourceAlreadyExistsException(
                    "This email id already exists");
        }
    }

    /**
     * Method to check if the provided email id
     * exists in the database or not.
     * @param email Email of user who is logging
     *              in.
     */
    public final void checkLoginEmail(final String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return;
        } else {
            throw new WrongCredentialsExceptions("Give registered email id");
        }
    }

    /**
     * Method to check the password of user who logs in.
     * @param loginDto Login dto.
     */
    public final void checkPassword(final LoginDto loginDto) {
        Optional<User> optionalUser =
                userRepository.findByEmail(loginDto.getEmail());
        User user = optionalUser.get();
        System.out.println(decodePassword(loginDto.getPassword()));
        String decodedPassword = decodePassword(loginDto.getPassword());
        System.out.println("Decoded Password: " + decodedPassword);
        System.out.println("Stored Password: " + user.getPassword());
        if (!passwordEncoder.matches(
                        decodePassword(loginDto.getPassword()),
                        user.getPassword())) {
            throw new WrongCredentialsExceptions("Password is incorrect");
        }
    }
    /**
     * This method returns true if userId is valid.
     * @param userId String that represents userId.
     */
    public final void checkUserId(final String userId) {
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        if (!optionalUser.isPresent()) {
                return;
            } else {
                throw new ResourceAlreadyExistsException(
                        "This user id " + userId
                        + "already exists");
            }
        }


    /**
     * A method that uses a few of the above methods to validate
     * a registering user.
     * @param userDto parameter UserDto.
     */
    public final void checkUser(final UserDto userDto) {
        checkName(userDto.getName());
        checkEmail(userDto.getEmail());
        checkUserId(userDto.getUserId());
    }

    /**
     * Method combines all necessary to validate logindto.
     * @param loginDto Login dto.
     */
    public final void checkLoginDto(final LoginDto loginDto) {
        checkLoginEmail(loginDto.getEmail());
        checkPassword(loginDto);
    }

}
