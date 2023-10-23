package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.exception.ValidationException;
import com.employee.employeeManagement.model.User;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserInDto;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.constants.ErrorConstants;
import com.employee.employeeManagement.exception.InvalidCredentialsExceptions;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
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
            throw new InvalidCredentialsExceptions("Give valid name.");
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
            throw new ResourceNotFoundException(
                    ErrorConstants.GIVE_REGISTERED_EMAIL);
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
        if (!passwordEncoder.matches(
                        decodePassword(loginDto.getPassword()),
                        user.getPassword())) {
            throw new InvalidCredentialsExceptions(
                    ErrorConstants.PASSWORD_INCORRECT);
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
                        ErrorConstants.USER_EXISTS);

            }
        }


    /**
     * A method that uses a few of the above methods to validate
     * a registering user.
     * @param userDto parameter UserInDto.
     */
    public final void checkUser(final UserInDto userDto) {
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

    /**
     * Method to check if the given role exists or not.
     * @param roleName given role.
     */
    public final void checkRole(final String roleName) {
        if (!roleName.equals("EMPLOYEE") && !roleName.equals("MANAGER")
                && !roleName.equals("ADMIN")) {
            throw new ResourceNotFoundException(ErrorConstants.ROLE_NOT_EXISTS);
        } else {
            return;
        }
    }

    /**
     * Method to check if the employee id exists.
     * @param id Id of employee.
     */
    public final void checkId(final Long id) {
        User employee = userRepository.findById(id).orElse(null);
        if (employee == null || employee.getRole() == Role.ADMIN) {
            throw new ResourceNotFoundException(
                    ErrorConstants.EMPLOYEE_NOT_EXIST);
        }
    }

    /**
     * Method to check admin while registering.
     * @param userInDto
     */
    public final void checkAdminRegistration(final UserInDto userInDto) {
        checkUser(userInDto);
        if (userInDto.getEmail() != "ankita.sharma@nucleusteq.com") {
            throw new ValidationException("Only ankita.sharma@nucleusteq can "
                    + "register.");
        }
    }


}
