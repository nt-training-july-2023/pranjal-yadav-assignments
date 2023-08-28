package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.AdminDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.ResponseEntityDto;
import com.employee.employeeManagement.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class responsible for handling administrative actions and
 * authentication endpoints.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")

public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * Endpoint to save admin details.
     *
     * @param adminDto The data transfer object containing admin information.
     * @return A message indicating successfully adding the user.
     */
    @PostMapping(path = "/save")
    public final String saveAdmin(@RequestBody AdminDto adminDto) {
        String name = adminService.addAdmin(adminDto);
        return "User added";
    }

    /**
     * Endpoint to authenticate an admin user.
     *
     * @param loginDto The data transfer object containing login credentials.
     * @return A ResponseEntity containing a ResponseEntityDto with authentication
     * status.
     *         If authentication is successful, returns a positive response
     *         with a success status and message.
     *         If authentication fails, returns a negative response
     *         with an error status and message.
     */


    @PostMapping(path = "/login")
    public final ResponseEntity<ResponseEntityDto> loginEmployee(@Valid @RequestBody LoginDto loginDto) {
        if (adminService.login(loginDto) == null) {
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
