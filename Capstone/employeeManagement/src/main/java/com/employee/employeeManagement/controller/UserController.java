package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.EmployeeOutDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.dto.UserNameDto;
import com.employee.employeeManagement.exception.WrongCredentialsExceptions;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ApiResponse;
import com.employee.employeeManagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private Validation validation;
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
        return userService.addUser(userDto);
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
            if(user.getRole() == Role.ADMIN)
                return new ApiResponse("Login successful", Role.ADMIN);
            else if (user.getRole() == Role.MANAGER)
                return new ApiResponse("Login successful", Role.MANAGER);
            else
                return new ApiResponse("Login successful", Role.EMPLOYEE);
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
        return new ApiResponse(
                "User added", user.getRole());
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
        return userService.allUserByRole(roleName);
    }
    @GetMapping(path = "/allUsers")
    public final List<EmployeeOutDto> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(path = "/getEmployee/{userId}")
    public final UserNameDto getEmployeeNameById (@PathVariable final String userId) {
        return userService.getEmployeeNameById(userId);
    }
    @GetMapping(path = "getEmployeeById/{id}")
    public final UserNameDto getEmployeeNameByLongId(@PathVariable final Long id){
        return userService.getEmployeeNameByLongId(id);
    }
    @GetMapping(path = "getUserById/{id}")
    public final EmployeeOutDto getEmployeeById(@PathVariable final Long id){
        return userService.getEmployeeById(id);
    }
    @GetMapping(path = "/email/{email}")
    public final EmployeeOutDto getEmployeeByEmail(@PathVariable final String email){
        return userService.getEmployeeByEmail(email);
    }
    @PutMapping(path = "/{id}/assignProject")
    public final ApiResponse updateEmployee(@PathVariable Long id, @RequestBody Map<String, Long> updatedDetails){
        return userService.updateEmployee(id, updatedDetails);
    }
}
