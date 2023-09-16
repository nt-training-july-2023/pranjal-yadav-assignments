package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.exception.WrongCredentialsExceptions;
import com.employee.employeeManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * Utility class for performing various data validation operations.
 */
@Component
public class Validation {
    @Autowired
    UserRepository userRepository;
    /**
     * This method returns true if the name is valid.
     * @param name String that represents name.
     * @return boolean value.
     */
    public final boolean checkName(final String name) {
        return !name.isEmpty() && name.matches("^[A-Za-z ]+$");
    }

    /**
     * This method returns true if email is valid.
     * @param email String that represents email.
     * @return boolean value.
     */
    public final boolean checkEmail(final String email) {
        if (!email.isEmpty() && email.matches(".*@nucleusteq\\.com$")) {
            return true;
        }
        return false;
    }
    /**
     * This method returns true if userId is valid.
     * @param userId String that represents userId.
     * @return boolean value.
     */
    public final boolean checkUserId(final String userId) {
        if (!userId.isEmpty() && userId.matches("N\\d{4}$")) {
            return true;
        }
        return false;
    }

    /**
     * A method that uses a few of the above methods to validate
     * a registering user.
     * @param userDto parameter UserDto.
     * @return boolean value;
     */
    public final boolean checkUser(final UserDto userDto) {
        if (!checkName(userDto.getName())) {
            throw new WrongCredentialsExceptions("Give valid name.");
        }
        if (!checkEmail(userDto.getEmail())) {
            throw new WrongCredentialsExceptions("Give valid email");
        }
        if (!checkUserId(userDto.getUserId())) {
            throw new WrongCredentialsExceptions("Give valid userId");
        }
        return true;
    }

    /**
     * Method combines all necessary to validate logindto.
     * @param loginDto .
     * @return exception or a boolean value.
     */
    public final boolean checkLoginDto(final LoginDto loginDto) {
        if (!checkName(loginDto.getEmail())) {
            throw new WrongCredentialsExceptions("Give valid email id");
        }
        return true;
    }

}
