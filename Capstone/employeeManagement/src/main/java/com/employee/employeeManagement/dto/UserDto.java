package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Data Transfer Object (DTO) representing user information.
 */
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
    @Pattern(regexp = "^[Nn]\\d{4}$")
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

    private Long projectId;
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
    private Long managerId;

    /**
     * All arguments constructor.
     * @param nameParam .
     * @param emailParam .
     * @param userIdParam .
     * @param dobParam .
     * @param dojParam .
     * @param locationParam .
     * @param designationParam .
     * @param contactNoParam .
     * @param projectIdParam .
     * @param roleParam .
     * @param passwordParam .
     * @param skillsParam .
     * @param managerIdParam .
     */
    public UserDto(final String nameParam, final String emailParam,
                   final String userIdParam, final String dobParam,
                   final String dojParam, final Location locationParam,
                   final Designation designationParam,
                   final Long contactNoParam,
                   final Long projectIdParam, final Role roleParam,
                   final String passwordParam,
                   final List<String> skillsParam,
                   final Long managerIdParam) {
        this.name = nameParam;
        this.email = emailParam;
        this.userId = userIdParam;
        this.dob = dobParam;
        this.doj = dojParam;
        this.location = locationParam;
        this.designation = designationParam;
        this.contactNo = contactNoParam;
        this.projectId = projectIdParam;
        this.role = roleParam;
        this.password = passwordParam;
        this.skills = skillsParam;
        this.managerId = managerIdParam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
