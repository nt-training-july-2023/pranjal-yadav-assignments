package com.employee.employeeManagement.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
/**
 * Data Transfer Object (DTO) representing login
 * credentials for admin authentication.
 */
@Data
public class LoginDto {
    /**
     * The email of the admin for authentication.
     */
    @Email
    private String admin_email;

    /**
     * The password of the admin for authentication.
     */
    private String password;

}
