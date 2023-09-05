package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.Model.Designation;
import com.employee.employeeManagement.Model.Location;
import com.employee.employeeManagement.Model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class UserDto {
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
    @NotBlank
    private String dob;
    @NotBlank
    private String doj;
    @NotBlank
    private Location location;
    @NotBlank
    private Designation designation;
    private Long ContactNo;
    private String projectName;
    private Role role;
    private String password;
}
