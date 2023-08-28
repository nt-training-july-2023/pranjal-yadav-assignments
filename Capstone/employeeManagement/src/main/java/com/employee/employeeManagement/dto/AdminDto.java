package com.employee.employeeManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing administrative user information.
 */
@Getter
@Setter
public class AdminDto {
    /**
     * The name of the admin.
     */
    @Pattern(regexp = "^[[A-Za-z\\s]*$]")
    private String admin_name;
    /**
     * The email of the admin.
     */
    @Email
    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "^[a-z][.][a-z]@nucleusteq.com$")
    private String admin_email;

    /**
     * The ID of the admin.
     */
    @NotBlank(message = "ID is madatory.")
    private long id;

    /**
     * The date of birth of the admin.
     */

    @NotBlank
    private String admin_DOB;

    /**
     * The date of joining of the admin.
     */
    @NotBlank
    private String admin_DOJ;

    /**
     * The location of the admin.
     */
    @NotBlank
    private String admin_location;
    /**
     * The designation of the admin.
     */

    @NotBlank
    private String admin_designation;


    /**
     * The contact number of the admin.
     */
    @Pattern(regexp = "^[0-9]")
    private long admin_contact_no;

    /**
     * The password of the admin.
     */
    @NotBlank
    private String password;

}
