package com.employee.employeeManagement.Model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

@Table
@Entity
public class RequestResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ResourceId;
    @Column
    private String comment;
    @Column
    private Long managerId;
    @Column
    private Long employeeId;
    @Column
    private Long projectId;

    public Long getResourceId() {
        return ResourceId;
    }

    public void setResourceId(Long resourceId) {
        ResourceId = resourceId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
