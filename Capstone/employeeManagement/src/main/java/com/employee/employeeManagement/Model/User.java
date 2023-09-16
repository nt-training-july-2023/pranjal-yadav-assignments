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

import java.util.List;
import java.util.Objects;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
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
    public User(final String nameParam, final String emailParam,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && getContactNo() == user.getContactNo()
                && Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getUserId(), user.getUserId()) &&
                Objects.equals(getDob(), user.getDob()) &&
                Objects.equals(getDoj(), user.getDoj()) && getLocation() ==
                user.getLocation() && getDesignation() == user.getDesignation()
                && Objects.equals(getProjectId(), user.getProjectId()) &&
                getRole() == user.getRole() && Objects.equals(getPassword(),
                user.getPassword()) &&
                Objects.equals(getSkills(), user.getSkills()) &&
                Objects.equals(getManagerId(), user.getManagerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getUserId(),
                getDob(), getDoj(), getLocation(), getDesignation(),
                getContactNo(), getProjectId(), getRole(), getPassword(),
                getSkills(), getManagerId());
    }
}

