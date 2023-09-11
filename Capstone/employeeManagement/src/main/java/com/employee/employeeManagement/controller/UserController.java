package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.Model.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.exception.WrongCredentialsExceptions;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ApiResponse;
import com.employee.employeeManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

/**
 * Controller class for managing user operations.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    /**
     * Service for managing user operations.
     */
    @Autowired
    private UserService userService;
    /**
     * Repository for accessing user data.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * Endpoint for saving an admin user.
     *
     * @param userDto The user details to be added.
     * @return ApiResponse indicating the status of the operation.
     */
    @PostMapping(path = "/save")
    public final ApiResponse saveAdmin(final @RequestBody UserDto userDto) {
        UserDto createdUser = userService.addUser(userDto);
        if (createdUser != null) {
            ApiResponse response = new ApiResponse(
                    "Admin added succesfully", createdUser.getRole());
            return response;
        } else {
            ApiResponse response = new ApiResponse(
                    "Invalid credentials", createdUser.getRole());
            return response;
        }
    }
    /**
     * Endpoint for user login.
     *
     * @param loginDto The login credentials.
     * @return ApiResponse indicating the status of the login operation.
     * @throws WrongCredentialsExceptions If the provided
     * credentials are incorrect.
     */
    @PostMapping(path = "/login")
    public final ApiResponse loginUser(
            @Valid @RequestBody final LoginDto loginDto) {
        if (userService.login(loginDto) == null) {
            throw new WrongCredentialsExceptions("Wrong credentials");
        } else {
            User user = userService.login(loginDto);
            return new ApiResponse("Login successful", user.getRole());
        }

    }
    /**
     * Endpoint for saving an employee user.
     *
     * @param userDto The user details to be added.
     * @return ResponseEntityDto indicating the status of the operation.
     */
    @PostMapping(path = "/save-emp")
    public final ApiResponse saveEmp(@RequestBody final UserDto userDto) {
            User user = userService.saveEmp(userDto);
            ApiResponse apiResponse = new ApiResponse(
                    "User added", user.getRole());
            return apiResponse;
    }
    /**
     * Endpoint for retrieving all employees by their role.
     *
     * @param roleName The role name to filter employees.
     * @return List of User objects representing employees
     * with the specified role.
     */
    @GetMapping(path = "/all/{roleName}")
    public final List<User> getEmployeesByRole(
            @PathVariable final String roleName) {
        // Find employees by role
        Role role = Role.valueOf(roleName);
        List<User> employees = userRepository.findByRole(role);
        return employees;
    }
}
