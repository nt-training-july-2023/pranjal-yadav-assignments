package com.employee.employeeManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

/**
 * Data Transfer Object (DTO) representing administrative user information.
 */
@Getter
@AllArgsConstructor
@Setter
@Data
@NoArgsConstructor
public class AdminDto {
    /**
     * The name of the admin.
     */
    @Pattern(regexp = "^[[A-Za-z\\s]*$]")
    private String adminName;
    /**
     * The email of the admin.
     */
    @Email
    @Pattern(regexp = "^[a-z][.][a-z]@nucleusteq.com$")
    private String adminEmail;

    /**
     * The ID of the admin.
     */
    @NotBlank
    private String adminId;

    /**
     * The date of birth of the admin.
     */

    @NotBlank
    private String adminDob;

    /**
     * The date of joining of the admin.
     */
    @NotBlank
    private String adminDoj;

    /**
     * The location of the admin.
     */
    @NotBlank
    private String adminLocation;
    /**
     * The designation of the admin.
     */

    @NotBlank
    private String adminDesignation;


    /**
     * The contact number of the admin.
     */
    @Pattern(regexp = "^[0-9]")
    private long adminContactNo;

    /**
     * The password of the admin.
     */
    @NotBlank
    private String password;

}
