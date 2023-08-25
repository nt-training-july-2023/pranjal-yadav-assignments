package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.AdminDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.repository.AdminRepository;
import com.employee.employeeManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")

public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(path="/save")
    public String saveAdmin(@RequestBody AdminDto adminDto){
        String name= adminService.addAdmin(adminDto);
        return "User added";
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> loginEmployee(@RequestBody LoginDto loginDto){
        if(adminService.login(loginDto) == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong details");
        }
        return ResponseEntity.ok("Successfully logged in");
    }

}
