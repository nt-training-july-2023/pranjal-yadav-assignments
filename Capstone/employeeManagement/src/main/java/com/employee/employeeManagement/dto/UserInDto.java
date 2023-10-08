package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Data Transfer Object (DTO) representing user information.
 */

public class UserInDto {
    /**
     * The name of the user.
     */
    @NotBlank
    private String name;
    /**
     * The email of user.
     */
    @Email
    @Pattern(regexp = ".*@nucleusteq\\.com$",
            message = "Email should end with nucleusteq.com.")
    @NotBlank
    private String email;
    /**
     * The ID of the user.
     */
    @NotBlank
    @Pattern(regexp = "^[Nn]\\d{4}$", message = "User id must be of the "
            + "format NXXXX")
    private String userId;
    /**
     * The date of birth of the user.
     */
    private String dob;
    /**
     * The date of joining of the user.
     */
    private String doj;

    /**
     * The location of the user.
     */

    private Location location;
    /**
     * The designation of the user.
     */

    private Designation designation;
    /**
     * The contact number of the user.
     */
    @NotNull(message = "Contact number is required.")
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
    @NotEmpty(message = "Project skills required must not be empty")
    private List<String> skills;
    /**
     * The name of the user's manager.
     */
    private Long managerId;


    /**
     * Get the name of the user.
     *
     * @return The name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Set the name of the user.
     *
     * @param nameParam The name to set.
     */
    public final void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * Get the email of the user.
     *
     * @return The email.
     */
    public final String getEmail() {
        return email;
    }

    /**
     * Set the email of the user.
     *
     * @param emailParam The email to set.
     */
    public final void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    /**
     * Get the user ID.
     *
     * @return The user ID.
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Set the user ID.
     *
     * @param userIdParam The user ID to set.
     */
    public final void setUserId(final String userIdParam) {
        this.userId = userIdParam;
    }

    /**
     * Get the date of birth of the user.
     *
     * @return The date of birth.
     */
    public final String getDob() {
        return dob;
    }

    /**
     * Set the date of birth of the user.
     *
     * @param dobParam The date of birth to set.
     */
    public final void setDob(final String dobParam) {
        this.dob = dobParam;
    }

    /**
     * Get the date of joining of the user.
     *
     * @return The date of joining.
     */
    public final String getDoj() {
        return doj;
    }

    /**
     * Set the date of joining of the user.
     *
     * @param dojParam The date of joining to set.
     */
    public final void setDoj(final String dojParam) {
        this.doj = dojParam;
    }

    /**
     * Get the location of the user.
     *
     * @return The location.
     */
    public final Location getLocation() {
        return location;
    }

    /**
     * Set the location of the user.
     *
     * @param locationParam The location to set.
     */
    public final void setLocation(final Location locationParam) {
        this.location = locationParam;
    }

    /**
     * Get the designation of the user.
     *
     * @return The designation.
     */
    public final Designation getDesignation() {
        return designation;
    }

    /**
     * Set the designation of the user.
     *
     * @param designationParam The designation to set.
     */
    public final void setDesignation(final Designation designationParam) {
        this.designation = designationParam;
    }

    /**
     * Get the contact number of the user.
     *
     * @return The contact number.
     */
    public final Long getContactNo() {
        return contactNo;
    }

    /**
     * Set the contact number of the user.
     *
     * @param contactNoParam The contact number to set.
     */
    public final void setContactNo(final Long contactNoParam) {
        this.contactNo = contactNoParam;
    }

    /**
     * Get the project ID associated with the user.
     *
     * @return The project ID.
     */
    public final Long getProjectId() {
        return projectId;
    }

    /**
     * Set the project ID associated with the user.
     *
     * @param projectIdParam The project ID to set.
     */
    public final void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * Get the role of the user.
     *
     * @return The role.
     */
    public final Role getRole() {
        return role;
    }

    /**
     * Set the role of the user.
     *
     * @param roleParam The role to set.
     */
    public final void setRole(final Role roleParam) {
        this.role = roleParam;
    }

    /**
     * Get the user's password.
     *
     * @return The password.
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Set the user's password.
     *
     * @param passwordParam The password to set.
     */
    public final void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    /**
     * Get the list of skills possessed by the user.
     *
     * @return The list of skills.
     */
    public final List<String> getSkills() {
        return  Collections.unmodifiableList(skills);
    }

    /**
     * Set the list of skills possessed by the user.
     *
     * @param skillsParam The list of skills to set.
     */
    public final void setSkills(final List<String> skillsParam) {
        if (skillsParam != null) {
            this.skills = new ArrayList<>(skillsParam);
        } else {
            this.skills = null;
        }
    }

    /**
     * Get the ID of the user's manager.
     *
     * @return The manager ID.
     */
    public final Long getManagerId() {
        return managerId;
    }

    /**
     * Set the ID of the user's manager.
     *
     * @param managerIdParam The manager ID to set.
     */
    public final void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * toString method for this class.
     * @return String value.
     */
    @Override
    public final String toString() {
        return "UserInDto{"
                + "name='" + name + '\''
                + ", email='" + email + '\''
                + ", userId='" + userId + '\''
                + ", dob='" + dob + '\''
                + ", doj='" + doj + '\''
                + ", location=" + location
                + ", designation=" + designation
                + ", contactNo=" + contactNo
                + ", projectId=" + projectId
                + ", role=" + role
                + ", password='" + password + '\''
                + ", skills=" + skills
                + ", managerId=" + managerId
                + '}';
    }

    /**
     * equals method for this class.
     * @param o Objec o.
     * @return boolean value.
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserInDto userInDto)) {
            return false;
        }
        return Objects.equals(getName(), userInDto.getName())
                && Objects.equals(getEmail(), userInDto.getEmail())
                && Objects.equals(getUserId(), userInDto.getUserId())
                && Objects.equals(getDob(), userInDto.getDob())
                && Objects.equals(getDoj(), userInDto.getDoj())
                && getLocation() == userInDto.getLocation()
                && getDesignation() == userInDto.getDesignation()
                && Objects.equals(getContactNo(), userInDto.getContactNo())
                && Objects.equals(getProjectId(), userInDto.getProjectId())
                && getRole() == userInDto.getRole()
                && Objects.equals(getPassword(), userInDto.getPassword())
                && Objects.equals(getSkills(), userInDto.getSkills())
                && Objects.equals(getManagerId(), userInDto.getManagerId());
    }

    /**
     * hashcode for this class.
     * @return int value.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getName(), getEmail(), getUserId(), getDob(),
                getDoj(), getLocation(), getDesignation(), getContactNo(),
                getProjectId(), getRole(), getPassword(), getSkills(),
                getManagerId());
    }
}
