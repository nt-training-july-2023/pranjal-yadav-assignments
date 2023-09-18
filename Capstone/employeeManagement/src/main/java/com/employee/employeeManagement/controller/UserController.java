package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.EmployeeOutDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.dto.UserNameDto;
import com.employee.employeeManagement.response.ApiResponse;
import com.employee.employeeManagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.Valid;
import com.employee.employeeManagement.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Map;

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
    private UserValidation userValidation;
    /**
     * The logger for this class.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserController.class);
    /**
    /**
     * Endpoint for saving an admin user.
     *
     * @param userDto The user details to be added.
     * @return ApiResponse indicating the status of the operation.
     */
    @PostMapping(path = "/save")
    public final ApiResponse saveAdmin(final @RequestBody UserDto userDto) {
        userValidation.checkUser(userDto);
        return userService.addUser(userDto);
    }
    /**
     * Endpoint for user login.
     *
     * @param loginDto The login credentials.
     * @return ApiResponse indicating the status of the login operation.
     * credentials are incorrect.
     */
    @PostMapping(path = "/login")
    public final ApiResponse loginUser(
            @Valid @RequestBody final LoginDto loginDto) {
        LOGGER.info("Logging user.");
        userValidation.checkLoginDto(loginDto);
        return userService.login(loginDto);

    }
    /**
     * Endpoint for saving an employee user.
     *
     * @param userDto The user details to be added.
     * @return ResponseEntityDto indicating the status of the operation.
     */
    @PostMapping(path = "/save-emp")
    public final ApiResponse saveEmp(@RequestBody final UserDto userDto) {
        LOGGER.info("Adding employee.");
        userValidation.checkUser(userDto);
        return userService.saveEmp(userDto);
    }
    /**
     * Endpoint for retrieving all employees by their role.
     *
     * @param roleName The role name to filter employees.
     * @return List of User objects representing employees
     * with the specified role.
     */
    @GetMapping(path = "/all/{roleName}")
    public final List<EmployeeOutDto> getEmployeesByRole(
            @PathVariable final String roleName) {
        LOGGER.info("All users by role.");
        return userService.allUserByRole(roleName);
    }
    /**
     * Retrieves a list of all users.
     *
     * @return A list of EmployeeOutDto objects representing all users.
     */
    @GetMapping(path = "/allUsers")
    public final List<EmployeeOutDto> getAllUsers() {
        LOGGER.info("All users");
        return userService.getAllUsers();
    }

    /**
     * Retrieves the name of an employee by their user ID.
     *
     * @param userId The user ID of the employee.
     * @return A UserNameDto object representing the employee's name.
     */
    @GetMapping(path = "/getEmployee/{userId}")
    public final UserNameDto getEmployeeNameById(
            @PathVariable final String userId) {
        LOGGER.info("Getting user name by user id");
        return userService.getEmployeeNameById(userId);
    }

    /**
     * Retrieves the name of an employee by their ID.
     *
     * @param id The ID of the employee.
     * @return A UserNameDto object representing the employee's name.
     */
    @GetMapping(path = "getEmployeeById/{id}")
    public final UserNameDto getEmployeeNameByLongId(
            @PathVariable final Long id) {
        LOGGER.info("Getting user name by id");
        return userService.getEmployeeNameByLongId(id);
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee.
     * @return An EmployeeOutDto object representing the employee.
     */
    @GetMapping(path = "getUserById/{id}")
    public final EmployeeOutDto getEmployeeById(@PathVariable final Long id) {
        LOGGER.info("Getting employee by id");
        return userService.getEmployeeById(id);
    }

    /**
     * Retrieves an employee by their email address.
     *
     * @param email The email address of the employee.
     * @return An EmployeeOutDto object representing the employee.
     */
    @GetMapping(path = "/email/{email}")
    public final EmployeeOutDto getEmployeeByEmail(@PathVariable
                                                       final String email) {
        LOGGER.info("Getting employee by email");
        return userService.getEmployeeByEmail(email);
    }

    /**
     * Updates an employee's details about assigned project.
     *
     * @param id The ID of the employee to be updated.
     * @param updatedDetails A Map containing updated employee details.
     * @return An ApiResponse indicating the result of the update operation.
     */
    @PutMapping(path = "/{id}/assignProject")
    public final ApiResponse updateEmployee(@PathVariable final Long id,
                                            @RequestBody final Map<String,
                                            Long> updatedDetails) {
        LOGGER.info("Assigning project.");
        return userService.updateEmployee(id, updatedDetails);
    }

}
