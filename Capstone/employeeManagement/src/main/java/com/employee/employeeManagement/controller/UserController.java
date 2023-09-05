package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.Model.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.ResponseEntityDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.exception.WrongCredentialsExceptions;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ApiResponse;
import com.employee.employeeManagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.AcceptPendingException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/save")
    public final ApiResponse saveAdmin(final @RequestBody UserDto userDto) {
        UserDto createdUser = userService.addUser(userDto);
        if(createdUser != null){
            ApiResponse response = new ApiResponse("Admin added succesfully");
            return response;
        }
        else {
            ApiResponse response = new ApiResponse("Invalid credentials");
            return response;
        }
    }
    @PostMapping(path = "/login")
    public final ApiResponse loginUser(
            @Valid @RequestBody final LoginDto loginDto) {
        if (userService.login(loginDto) == null) {
            throw new WrongCredentialsExceptions("Wrong credentials");
        }
        else {
            return new ApiResponse("Login successful");
        }

    }
    @PostMapping(path = "/save-emp")
    public final ResponseEntityDto saveEmp(@RequestBody UserDto userDto){
            String name = userService.saveEmp(userDto);
            ResponseEntityDto responseEntityDto = new ResponseEntityDto(
                    true, "USer added");
            return responseEntityDto;
    }
    @GetMapping(path = "/all/{roleName}")
//    public final List<UserDto> getAllEmp(){
//        return userService.getAllEmp();
//    }
    public List<User> getEmployeesByRole(@PathVariable String roleName) {
        // Find employees by role
        Role role = Role.valueOf("EMPLOYEE");
        List<User> employees = userRepository.findByRole(role);

        return employees;
    }
    @GetMapping(path = "/get-all-managers")
    public final List<UserDto> getAllManagers(){
        return userService.getAllManagers();
    }
}
