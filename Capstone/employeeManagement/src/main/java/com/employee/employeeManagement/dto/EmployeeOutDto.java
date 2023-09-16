package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;

import java.util.List;

public class EmployeeOutDto {
    private Long id;
    private String name;
    /**
     * The email of user.
     */
    private String email;
    /**
     * The ID of the user.
     */
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
    private Long contactNo;
    /**
     * The id of the project the user is associated with.
     */

    private Long projectId;
    /**
     * The role of the user.
     */
    private Role role;
    private String managerName;
    private String projectName;

    /**
     * The list of skills possessed by the user.
     */
    private List<String> skills;
    /**
     * The id of the user's manager.
     */
    private Long managerId;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
