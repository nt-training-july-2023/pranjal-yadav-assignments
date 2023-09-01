package com.employee.employeeManagement.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing login
 * credentials for admin authentication.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    /**
     * The email of the admin for authentication.
     */
    @Email
    private String email;

    /**
     * The password of the admin for authentication.
     */
    private String password;

}
