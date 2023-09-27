package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.*;
import com.employee.employeeManagement.outDtos.UserNameDto;
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
import org.springframework.web.bind.annotation.DeleteMapping;


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
        userValidation.checkUser(userDto);
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
    @PostMapping(path = "/save-emp")
    public final ResponseDto saveEmp(@RequestBody @Valid  final UserInDto userDto) {
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
        LOGGER.info("All users by role " + roleName);
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
    //DELETE
    @GetMapping(path = "/getEmployee/{userId}")
    public final UserNameDto getEmployeeNameById(
            @PathVariable final String userId) {
        LOGGER.info("Getting user name by user id " + userId);
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
        LOGGER.info("Getting user name by id " + id);
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
        LOGGER.info("Getting employee by id " + id);
        return userService.getEmployeeById(id);
    }


    /**
     * Updates an employee's details about assigned project.
     *
     * @param id The ID of the employee to be updated.
     * @param updatedDetails A Map containing updated employee details.
     * @return An ResponseDto indicating the result of the update operation.
     */
    @PutMapping(path = "/{id}/assignProject")
    public final ResponseDto updateEmployee(@PathVariable final Long id,
                                            @RequestBody final Map<String,
                                            Long> updatedDetails) {
        LOGGER.info("Assigning project to " + id);
        return userService.updateEmployee(id, updatedDetails);
    }

    /**
     * Endpoint for updating skills of an employee.
     * @param id Id of employee.
     * @param skills Updated skills.
     * @return Response.
     */
    @PutMapping(path = "/{id}/skill")
    public final ResponseDto updateSkills(@PathVariable final Long id,
                                          @RequestBody final Map<String,
                                                  List<String>> skills) {
        LOGGER.info("Updating skills for " + id);
        return userService.updateSkills(id, skills.get("skills"));
    }

    /**
     * Endpoint for adding a request for resource.
     * @param requestResourceDto Request.
     * @return Response.
     */
    @PostMapping(path = "/request/resource")
    public final ResponseDto requestResource(
            @RequestBody final RequestResourceDto requestResourceDto) {
        LOGGER.info("Adding request resource.");
        ResponseDto responseDto = userService.requestResource(requestResourceDto);
        LOGGER.info("Request resource dto: " + requestResourceDto.toString());
        return responseDto;
    }

    /**
     * Endpoint for retrieving all requested resources.
     * @return List of requested resources.
     */
    @GetMapping(path = "/all/request")
    public final List<RequestResourceOutDto> getAllRequests() {
        LOGGER.info("Getting all requests");
        List<RequestResourceOutDto> list = userService.getAllRequests();
        return list;
    }

    /**
     * Endpoint for deleting a requested resource.
     * @param resourceId Id of that resource.
     * @return Response.
     */
    @DeleteMapping(path = "/request/delete/{resourceId}")
    public final ResponseDto deleteRequest(
            @PathVariable final Long resourceId) {
        LOGGER.info("Deleting request.");
        ResponseDto responseDto = userService.deleteRequest(resourceId);
        LOGGER.info("Resource id: "+ resourceId);
        return responseDto;
    }

    /**
     * Endpoint for accepting request.
     * @param resourceId of requested resource.
     * @return Response.
     */
    @PostMapping("/accept/{resourceId}")
    public final ResponseDto acceptRequest(
            @PathVariable final Long resourceId) {
        LOGGER.info("Accepting resource");
        ResponseDto responseDto = userService.acceptRequest(resourceId);
        LOGGER.info("Resource id: " + resourceId);
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
     * @param id Id of employee.
     * @return Response.
     */
    @PutMapping(path = "/unassign/{id}")
    public final ResponseDto unAssignProject(@PathVariable final Long id) {
        LOGGER.info("Unassign project " + id);
        ResponseDto responseDto = userService.unAssignProject(id);
        return responseDto;
    }

    /**
     * Check if that particular employee is already
     * requested by that manager.
     * @param reqDto requested resource dto.
     * @return boolean value.
     */
    @PostMapping("/employee/isRequested")
    public boolean isRequested(@RequestBody final IsRequested reqDto) {
        LOGGER.info("Is requested");
        boolean returnedValue = userService.isRequested(reqDto);
        return returnedValue;
    }
}
