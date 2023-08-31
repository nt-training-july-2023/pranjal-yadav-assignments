package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.AdminDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.ResponseEntityDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.service.AdminService;
import com.employee.employeeManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public final String saveAdmin(final @RequestBody UserDto userDto) {
        String name = userService.addUser(userDto);
        return name+" User added";
    }
    @PostMapping(path = "/login")
    public final ResponseEntity<ResponseEntityDto> loginUser(
            @Valid @RequestBody final LoginDto loginDto) {
        if (userService.login(loginDto) == null) {
            ResponseEntityDto responseEntityDto = new ResponseEntityDto(false,
                    "Wrong details");
            return new ResponseEntity<>(responseEntityDto,
                    HttpStatus.UNAUTHORIZED);
        }
        ResponseEntityDto responseEntityDto = new ResponseEntityDto(true,
                "Successfully logged in");
        return new ResponseEntity<>(responseEntityDto, HttpStatus.ACCEPTED);

    }
}
