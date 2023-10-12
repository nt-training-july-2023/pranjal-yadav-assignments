package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.UserInDto;
import com.employee.employeeManagement.dto.EmployeeOutDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.LoginResponse;
import com.employee.employeeManagement.dto.UserNameDto;
import com.employee.employeeManagement.response.ResponseDto;
import com.employee.employeeManagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.Valid;
import com.employee.employeeManagement.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


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
     * @return ResponseDto indicating the status of the operation.
     */
    @PostMapping(path = "/save")
    public final ResponseDto saveAdmin(final @RequestBody UserInDto userDto) {
        LOGGER.info("Adding admin");
        userValidation.checkAdminRegistration(userDto);
        LOGGER.info("Valid user: " + userDto.toString());
        ResponseDto responseDto = userService.addUser(userDto);
        return responseDto;
    }
    /**
     * Endpoint for user login.
     *
     * @param loginDto The login credentials.
     * @return ResponseDto indicating the status of the login operation.
     * credentials are incorrect.
     */
    @PostMapping(path = "/login")
    public final LoginResponse loginUser(
            @Valid @RequestBody final LoginDto loginDto) {
        LOGGER.info("Logging user.");
        userValidation.checkLoginDto(loginDto);
        LOGGER.info("Valid login credentials: " + loginDto.toString());
        LoginResponse loginResponse = userService.login(loginDto);
        return loginResponse;

    }
    /**
     * Endpoint for saving an employee user.
     *
     * @param userDto The user details to be added.
     * @return ResponseEntityDto indicating the status of the operation.
     */
    @PostMapping(path = "/saveEmp")
    public final ResponseDto saveEmp(
            @RequestBody @Valid  final UserInDto userDto) {
        LOGGER.info("Adding employee.");
        userValidation.checkUser(userDto);
        LOGGER.info("Valid user : " + userDto.toString());
        ResponseDto responseDto = userService.saveEmp(userDto);
        return responseDto;
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
        userValidation.checkRole(roleName);
        LOGGER.info("All users by role " + roleName);
        List<EmployeeOutDto> list = userService.allUserByRole(roleName);
        return list;
    }
    /**
     * Retrieves a list of all users.
     *
     * @return A list of EmployeeOutDto objects representing all users.
     */
    @GetMapping(path = "/allUsers")
    public final List<EmployeeOutDto> getAllUsers() {
        LOGGER.info("All users");
        List<EmployeeOutDto> list = userService.getAllUsers();
        return list;
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
        LOGGER.info("Getting user name by id " + id);
        userValidation.checkId(id);
        UserNameDto userNameDto = userService.getEmployeeNameByLongId(id);
        return userNameDto;
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee.
     * @return An EmployeeOutDto object representing the employee.
     */
    @GetMapping(path = "getUserById/{id}")
    public final EmployeeOutDto getEmployeeById(@PathVariable final Long id) {
        LOGGER.info("Getting employee by id " + id);
        userValidation.checkId(id);
        EmployeeOutDto employeeOutDto = userService.getEmployeeById(id);
        return employeeOutDto;
    }


    /**
     * Updates an employee's details about assigned project.
     *
     * @param id The ID of the employee to be updated.
     * @param updatedDetails A Map containing updated employee details.
     * @return An ResponseDto indicating the result of the update operation.
     */
    @PutMapping(path = "/assignProject/{id}")
    public final ResponseDto updateEmployee(@PathVariable final Long id,
                                            @RequestBody final Map<String,
                                            Long> updatedDetails) {
        LOGGER.info("Assigning project to " + id);
        userValidation.checkId(id);
        ResponseDto responseDto =
                userService.updateEmployee(id, updatedDetails);
        return responseDto;
    }

    /**
     * Endpoint for updating skills of an employee.
     * @param id id of employee.
     * @param skills Updated skills.
     * @return Response.
     */
    @PutMapping(path = "/skill/{id}")
    public final ResponseDto updateSkills(@PathVariable final Long id,
                                          @RequestBody final Map<String,
                                                  List<String>> skills) {
        LOGGER.info("Updating skills for " + id);
        userValidation.checkId(id);
        ResponseDto responseDto =
                userService.updateSkills(id, skills.get("skills"));
        return responseDto;
    }


    /**
     *Endpoint for getting all employees with given skills.
     * @param skills required skills in employees.
     * @param isCheck If true then all unassigned.
     *                If false then all assigned.
     * @return List of employees.
     */
    @GetMapping(path = "employees/skills")
    public final List<EmployeeOutDto> employeeWithSkill(
            @RequestParam final List<String> skills,
            @RequestParam final boolean isCheck) {
        LOGGER.info("Getting all employees with given skills");
        List<EmployeeOutDto> list = userService.searchBySkills(skills, isCheck);
        return list;
    }

    /**
     * Endpoint to un-assign employee from a
     * project.
     * @param id id of employee.
     * @return Response.
     */
    @PutMapping(path = "/unassign/{id}")
    public final ResponseDto unAssignProject(@PathVariable final Long id) {
        LOGGER.info("Unassign project " + id);
        userValidation.checkId(id);
        ResponseDto responseDto = userService.unAssignProject(id);
        return responseDto;
    }

}
