package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.Model.Designation;
import com.employee.employeeManagement.Model.Location;
import com.employee.employeeManagement.Model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Data Transfer Object (DTO) representing user information.
 */
@Getter
@AllArgsConstructor
@Setter
@Data
@NoArgsConstructor
public class UserDto {
    /**
     * The name of the user.
     */
    @Pattern(regexp = "^[[A-Za-z\\s]*$]")
    private String name;
    /**
     * The email of user.
     */
    @Email
    private String email;
    /**
     * The ID of the user.
     */
    @NotBlank
    @Pattern(regexp = "^[Nn]\\d{3}$")
    private String userId;
    /**
     * The date of birth of the user.
     */
    @NotBlank
    private String dob;
    /**
     * The date of joining of the user.
     */
    @NotBlank
    private String doj;

    /**
     * The location of the user.
     */
    @NotBlank
    private Location location;
    /**
     * The designation of the user.
     */
    @NotBlank
    private Designation designation;
    /**
     * The contact number of the user.
     */
    private Long contactNo;
    /**
     * The name of the project the user is associated with.
     */

    private String projectId;
    /**
     * The role of the user.
     */
    private Role role;
    /**
     * The password of the user.
     */
    private String password;
    /**
     * The list of skills possessed by the user.
     */
    private List<String> skills;
    /**
     * The name of the user's manager.
     */
    private String managerId;
}
