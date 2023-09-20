package com.employee.employeeManagement.outDtos;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    public final Long getId() {
        return id;
    }

    /**
     * Set the unique ID of the employee.
     *
     * @param idParam The employee's ID.
     */
    public final void setId(final Long idParam) {
        this.id = idParam;
    }

    /**
     * Get the name of the employee.
     *
     * @return The employee's name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Set the name of the employee.
     *
     * @param nameParam The employee's name.
     */
    public final void setName(final String nameParam) {
        this.name = nameParam;
    }


    /**
     * Get the email address of the employee.
     *
     * @return The employee's email address.
     */
    public final String getEmail() {
        return email;
    }

    /**
     * Set the email address of the employee.
     *
     * @param emailParam The employee's email address.
     */
    public final void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    /**
     * Get the user ID of the employee.
     *
     * @return The employee's user ID.
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Set the user ID of the employee.
     *
     * @param userIdParam The employee's user ID.
     */
    public final void setUserId(final String userIdParam) {
        this.userId = userIdParam;
    }

    /**
     * Get the date of birth of the employee.
     *
     * @return The employee's date of birth.
     */
    public final String getDob() {
        return dob;
    }

    /**
     * Set the date of birth of the employee.
     *
     * @param dobParam The employee's date of birth.
     */
    public final void setDob(final String dobParam) {
        this.dob = dobParam;
    }

    /**
     * Get the date of joining of the employee.
     *
     * @return The employee's date of joining.
     */
    public final String getDoj() {
        return doj;
    }

    /**
     * Set the date of joining of the employee.
     *
     * @param dojParam The employee's date of joining.
     */
    public final void setDoj(final String dojParam) {
        this.doj = dojParam;
    }

    /**
     * Get the location of the employee.
     *
     * @return The employee's location.
     */
    public final Location getLocation() {
        return location;
    }

    /**
     * Set the location of the employee.
     *
     * @param locationParam The employee's location.
     */
    public final void setLocation(final Location locationParam) {
        this.location = locationParam;
    }

    /**
     * Get the designation of the employee.
     *
     * @return The employee's designation.
     */
    public final Designation getDesignation() {
        return designation;
    }

    /**
     * Set the designation of the employee.
     *
     * @param designationParam The employee's designation.
     */
    public final void setDesignation(final Designation designationParam) {
        this.designation = designationParam;
    }

    /**
     * Get the contact number of the employee.
     *
     * @return The employee's contact number.
     */
    public final Long getContactNo() {
        return contactNo;
    }

    /**
     * Set the contact number of the employee.
     *
     * @param contactNoParam The employee's contact number.
     */
    public final void setContactNo(final Long contactNoParam) {
        this.contactNo = contactNoParam;
    }

    /**
     * Get the ID of the project the employee is associated with.
     *
     * @return The ID of the associated project.
     */
    public final Long getProjectId() {
        return projectId;
    }

    /**
     * Set the ID of the project the employee is associated with.
     *
     * @param projectIdParam The ID of the associated project.
     */
    public final void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * Get the role of the employee.
     *
     * @return The employee's role.
     */
    public final Role getRole() {
        return role;
    }

    /**
     * Set the role of the employee.
     *
     * @param roleParam The employee's role.
     */
    public final void setRole(final Role roleParam) {
        this.role = roleParam;
    }

    /**
     * Get the name of the manager of the employee.
     *
     * @return The name of the manager.
     */
    public final String getManagerName() {
        return managerName;
    }

    /**
     * Set the name of the manager of the employee.
     *
     * @param managerNameParam The name of the manager.
     */
    public final void setManagerName(final String managerNameParam) {
        this.managerName = managerNameParam;
    }

    /**
     * Get the list of skills possessed by the employee.
     *
     * @return The list of skills.
     */
    public final List<String> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    /**
     * Set the list of skills possessed by the employee.
     *
     * @param skillsParam The list of skills.
     */
    public final void setSkills(final List<String> skillsParam) {
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
    public final Long getManagerId() {
        return managerId;
    }

    /**
     * Set the ID of the employee's manager.
     *
     * @param managerIdParam The ID of the manager.
     */
    public final void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * Get the name of the project the employee is associated with.
     *
     * @return The name of the associated project.
     */
    public final String getProjectName() {
        return projectName;
    }

    /**
     * Set the name of the project the employee is associated with.
     *
     * @param projectNameParam The name of the associated project.
     */
    public final void setProjectName(final String projectNameParam) {
        this.projectName = projectNameParam;
    }

}
