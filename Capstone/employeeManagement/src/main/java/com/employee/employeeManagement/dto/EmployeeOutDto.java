package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Data Transfer Object (DTO) representing employee information.
 */
public class EmployeeOutDto {
    /**
     * The unique ID of the employee.
     */
    private Long id;

    /**
     * The name of the employee.
     */
    private String name;

    /**
     * The email address of the employee.
     */
    private String email;

    /**
     * The user ID of the employee.
     */
    private String userId;

    /**
     * The date of birth of the employee.
     */
    private String dob;

    /**
     * The date of joining of the employee.
     */
    private String doj;

    /**
     * The location of the employee.
     */
    private Location location;

    /**
     * The designation of the employee.
     */
    private Designation designation;

    /**
     * The contact number of the employee.
     */
    private Long contactNo;

    /**
     * The ID of the project the employee is associated with.
     */
    private Long projectId;

    /**
     * The role of the employee.
     */
    private Role role;

    /**
     * The name of the manager of the employee.
     */
    private String managerName;

    /**
     * The name of the project the employee is associated with.
     */
    private String projectName;

    /**
     * The list of skills possessed by the employee.
     */
    private List<String> skills;

    /**
     * The ID of the employee's manager.
     */
    private Long managerId;


    /**
     * Get the unique ID of the employee.
     *
     * @return The employee's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique ID of the employee.
     *
     * @param idParam The employee's ID.
     */
    public void setId(final Long idParam) {
        this.id = idParam;
    }

    /**
     * Get the name of the employee.
     *
     * @return The employee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the employee.
     *
     * @param nameParam The employee's name.
     */
    public void setName(final String nameParam) {
        this.name = nameParam;
    }


    /**
     * Get the email address of the employee.
     *
     * @return The employee's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the employee.
     *
     * @param emailParam The employee's email address.
     */
    public void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    /**
     * Get the user ID of the employee.
     *
     * @return The employee's user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set the user ID of the employee.
     *
     * @param userIdParam The employee's user ID.
     */
    public void setUserId(final String userIdParam) {
        this.userId = userIdParam;
    }

    /**
     * Get the date of birth of the employee.
     *
     * @return The employee's date of birth.
     */
    public String getDob() {
        return dob;
    }

    /**
     * Set the date of birth of the employee.
     *
     * @param dobParam The employee's date of birth.
     */
    public void setDob(final String dobParam) {
        this.dob = dobParam;
    }

    /**
     * Get the date of joining of the employee.
     *
     * @return The employee's date of joining.
     */
    public String getDoj() {
        return doj;
    }

    /**
     * Set the date of joining of the employee.
     *
     * @param dojParam The employee's date of joining.
     */
    public void setDoj(final String dojParam) {
        this.doj = dojParam;
    }

    /**
     * Get the location of the employee.
     *
     * @return The employee's location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location of the employee.
     *
     * @param locationParam The employee's location.
     */
    public void setLocation(final Location locationParam) {
        this.location = locationParam;
    }

    /**
     * Get the designation of the employee.
     *
     * @return The employee's designation.
     */
    public Designation getDesignation() {
        return designation;
    }

    /**
     * Set the designation of the employee.
     *
     * @param designationParam The employee's designation.
     */
    public void setDesignation(final Designation designationParam) {
        this.designation = designationParam;
    }

    /**
     * Get the contact number of the employee.
     *
     * @return The employee's contact number.
     */
    public Long getContactNo() {
        return contactNo;
    }

    /**
     * Set the contact number of the employee.
     *
     * @param contactNoParam The employee's contact number.
     */
    public void setContactNo(final Long contactNoParam) {
        this.contactNo = contactNoParam;
    }

    /**
     * Get the ID of the project the employee is associated with.
     *
     * @return The ID of the associated project.
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * Set the ID of the project the employee is associated with.
     *
     * @param projectIdParam The ID of the associated project.
     */
    public void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * Get the role of the employee.
     *
     * @return The employee's role.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Set the role of the employee.
     *
     * @param roleParam The employee's role.
     */
    public void setRole(final Role roleParam) {
        this.role = roleParam;
    }

    /**
     * Get the name of the manager of the employee.
     *
     * @return The name of the manager.
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Set the name of the manager of the employee.
     *
     * @param managerNameParam The name of the manager.
     */
    public void setManagerName(final String managerNameParam) {
        this.managerName = managerNameParam;
    }

    /**
     * Get the list of skills possessed by the employee.
     *
     * @return The list of skills.
     */
    public List<String> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    /**
     * Set the list of skills possessed by the employee.
     *
     * @param skillsParam The list of skills.
     */
    public void setSkills(final List<String> skillsParam) {
        if (skillsParam != null) {
            this.skills = new ArrayList<>(skillsParam);
        } else {
            this.skills = null;
        }
    }

    /**
     * Get the ID of the employee's manager.
     *
     * @return The ID of the manager.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * Set the ID of the employee's manager.
     *
     * @param managerIdParam The ID of the manager.
     */
    public void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * Get the name of the project the employee is associated with.
     *
     * @return The name of the associated project.
     */
    public  String getProjectName() {
        return projectName;
    }

    /**
     * Set the name of the project the employee is associated with.
     *
     * @param projectNameParam The name of the associated project.
     */
    public void setProjectName(final String projectNameParam) {
        this.projectName = projectNameParam;
    }

    /**
     * toString method for EmployeeOutDto.
     * @return String.
     */
    @Override
    public final String toString() {
        return "EmployeeOutDto{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", email='" + email + '\''
                + ", userId='" + userId + '\''
                + ", dob='" + dob + '\''
                + ", doj='" + doj + '\''
                + ", location=" + location
                + ", designation=" + designation
                + ", contactNo=" + contactNo
                + ", projectId=" + projectId
                + ", role=" + role
                + ", managerName='" + managerName + '\''
                + ", projectName='" + projectName + '\''
                + ", skills=" + skills
                + ", managerId=" + managerId
                + '}';
    }

    /**
     * equals mathod for EmployeeOutDto.
     * @param o
     * @return boolean value.
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmployeeOutDto that)) {
            return false;
        }
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getName(), that.getName())
                && Objects.equals(getEmail(), that.getEmail())
                && Objects.equals(getUserId(), that.getUserId())
                && Objects.equals(getDob(), that.getDob())
                && Objects.equals(getDoj(), that.getDoj())
                && getLocation() == that.getLocation()
                && getDesignation() == that.getDesignation()
                && Objects.equals(getContactNo(), that.getContactNo())
                && Objects.equals(getProjectId(), that.getProjectId())
                && getRole() == that.getRole()
                && Objects.equals(getManagerName(), that.getManagerName())
                && Objects.equals(getProjectName(), that.getProjectName())
                && Objects.equals(getSkills(), that.getSkills())
                && Objects.equals(getManagerId(), that.getManagerId());
    }

    /**
     * Hashcode for EmployeeOutDto.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getUserId(),
                getDob(), getDoj(), getLocation(), getDesignation(),
                getContactNo(), getProjectId(), getRole(), getManagerName(),
                getProjectName(), getSkills(), getManagerId());
    }
}
