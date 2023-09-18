package com.employee.employeeManagement.Model;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.NoArgsConstructor;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a user.
 */
@Entity
@NoArgsConstructor
@Table(name = "User")
public class User {
    /**
     * Id of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The name of the user.
     */
    @Column
    private String name;

    /**
     * The email address of the user (must be unique).
     */
    @Column(unique = true)
    private String email;

    /**
     * The user ID of the user (must be unique).
     */
    @Column(unique = true)
    private String userId;

    /**
     * The date of birth (DOB) of the user.
     */
    @Column
    private String dob;

    /**
     * The date of joining (DOJ) of the user.
     */
    @Column
    private String doj;

    /**
     * The location where the user is based.
     */
    @Enumerated(EnumType.STRING)
    private Location location;

    /**
     * The designation or job title of the user.
     */
    @Enumerated(EnumType.STRING)
    private Designation designation;

    /**
     * The contact number of the user.
     */
    private long contactNo;

    /**
     * The name of the project associated with the user.
     */
    @Column
    private Long projectId;

    /**
     * The role of the user within the organization.
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * The password associated with the user.
     */
    @Column
    private String password;

    /**
     * The skills or expertise possessed by the user.
     */
    @Column
    private List<String> skills;

    /**
     * The name of the manager of user.
     */
    @Column
    private Long managerId;

    /**
     * Get the ID of the employee.
     *
     * @return The employee ID.
     */
    public final long getId() {
        return id;
    }

    /**
     * Set the ID of the employee.
     *
     * @param idParam The employee ID to set.
     */
    public final void setId(final long idParam) {
        this.id = idParam;
    }

    /**
     * Get the name of the employee.
     *
     * @return The employee name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Set the name of the employee.
     *
     * @param nameParam The employee name to set.
     */
    public final void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * Get the email of the employee.
     *
     * @return The employee email.
     */
    public final String getEmail() {
        return email;
    }

    /**
     * Set the email of the employee.
     *
     * @param emailParam The employee email to set.
     */
    public final void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    /**
     * Get the user ID of the employee.
     *
     * @return The employee user ID.
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Set the user ID of the employee.
     *
     * @param userIdParam The employee user ID to set.
     */
    public final void setUserId(final String userIdParam) {
        this.userId = userIdParam;
    }

    /**
     * Get the date of birth of the employee.
     *
     * @return The date of birth.
     */
    public final String getDob() {
        return dob;
    }

    /**
     * Set the date of birth of the employee.
     *
     * @param dobParam The date of birth to set.
     */
    public final void setDob(final String dobParam) {
        this.dob = dobParam;
    }

    /**
     * Get the date of joining of the employee.
     *
     * @return The date of joining.
     */
    public final String getDoj() {
        return doj;
    }

    /**
     * Set the date of joining of the employee.
     *
     * @param dojParam The date of joining to set.
     */
    public final void setDoj(final String dojParam) {
        this.doj = dojParam;
    }

    /**
     * Get the location of the employee.
     *
     * @return The employee location.
     */
    public final Location getLocation() {
        return location;
    }

    /**
     * Set the location of the employee.
     *
     * @param locationParam The employee location to set.
     */
    public final void setLocation(final Location locationParam) {
        this.location = locationParam;
    }

    /**
     * Get the designation of the employee.
     *
     * @return The employee designation.
     */
    public final Designation getDesignation() {
        return designation;
    }

    /**
     * Set the designation of the employee.
     *
     * @param designationParam The employee designation to set.
     */
    public final void setDesignation(final Designation designationParam) {
        this.designation = designationParam;
    }

    /**
     * Get the contact number of the employee.
     *
     * @return The employee contact number.
     */
    public final long getContactNo() {
        return contactNo;
    }

    /**
     * Set the contact number of the employee.
     *
     * @param contactNoParam The employee contact number to set.
     */
    public final void setContactNo(final long contactNoParam) {
        this.contactNo = contactNoParam;
    }

    /**
     * Get the project ID associated with the employee.
     *
     * @return The project ID.
     */
    public final Long getProjectId() {
        return projectId;
    }

    /**
     * Set the project ID associated with the employee.
     *
     * @param projectIdParam The project ID to set.
     */
    public final void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * Get the role of the employee.
     *
     * @return The employee role.
     */
    public final Role getRole() {
        return role;
    }

    /**
     * Set the role of the employee.
     *
     * @param roleParam The employee role to set.
     */
    public final void setRole(final Role roleParam) {
        this.role = roleParam;
    }

    /**
     * Get the password of the employee.
     *
     * @return The employee password.
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Set the password of the employee.
     *
     * @param passwordParam The employee password to set.
     */
    public final void setPassword(final String passwordParam) {
        this.password = passwordParam;
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
     * Get the ID of the employee's manager.
     *
     * @return The manager's ID.
     */
    public final Long getManagerId() {
        return managerId;
    }

    /**
     * Set the ID of the employee's manager.
     *
     * @param managerIdParam The manager's ID to set.
     */
    public final void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }




//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User user)) return false;
//        return getId() == user.getId()
//        && getContactNo() == user
//        .getContactNo()
//                && Objects.equals(getName(), user.getName()) &&
//                Objects.equals(getEmail(), user.getEmail()) &&
//                Objects.equals(getUserId(), user.getUserId()) &&
//                Objects.equals(getDob(), user.getDob()) &&
//                Objects.equals(getDoj(),
//                user.getDoj()) && getLocation() ==
//                user.getLocation()
//                && getDesignation() == user.getDesignation()
//                && Objects.equals(getProjectId(),
//                user.getProjectId()) &&
//                getRole() == user.getRole() && Objects.equals(getPassword(),
//                user.getPassword()) &&
//                Objects.equals(getSkills(), user.getSkills()) &&
//                Objects.equals(getManagerId(), user.getManagerId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getName(), getEmail(), getUserId(),
//                getDob(), getDoj(), getLocation(), getDesignation(),
//                getContactNo(), getProjectId(), getRole(), getPassword(),
//                getSkills(), getManagerId());
//    }
}

