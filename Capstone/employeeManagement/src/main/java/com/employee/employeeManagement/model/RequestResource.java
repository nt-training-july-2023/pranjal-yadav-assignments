package com.employee.employeeManagement.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

import java.util.Objects;

/**
 * Entity class representing a request resource.
 * This class is used to map request resource
 * data to a database table.
 */
@Table
@Entity
public class RequestResource {
    /**
     * The unique identifier for the resource.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    /**
     * The comment associated with the request.
     */
    @Column(nullable = false)
    private String comment;

    /**
     * The ID of the manager responsible for the request.
     */
    @Column(nullable = false)
    private Long managerId;

    /**
     * The ID of the employee associated with the request.
     */
    @Column(nullable = false)
    private Long employeeId;

    /**
     * The ID of the project related to the request.
     */
    @Column(nullable = false)
    private Long projectId;

    /**
     * Get the unique identifier for the resource.
     *
     * @return The resource's unique identifier.
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * Set the unique identifier for the resource.
     *
     * @param resourceIdParam The unique identifier to set.
     */
    public void setResourceId(final Long resourceIdParam) {
        resourceId = resourceIdParam;
    }

    /**
     * Get the comment associated with the request.
     *
     * @return The comment as a string.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment associated with the request.
     *
     * @param commentParam The comment to set.
     */
    public void setComment(final String commentParam) {
        this.comment = commentParam;
    }

    /**
     * Get the ID of the manager responsible for the request.
     *
     * @return The manager's ID.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * Set the ID of the manager responsible for the request.
     *
     * @param managerIdParam The manager's ID to set.
     */
    public void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * Get the ID of the employee associated with the request.
     *
     * @return The employee's ID.
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * Set the ID of the employee associated with the request.
     *
     * @param employeeIdParam The employee's ID to set.
     */
    public void setEmployeeId(final Long employeeIdParam) {
        this.employeeId = employeeIdParam;
    }

    /**
     * Get the ID of the project related to the request.
     *
     * @return The project's ID.
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * Set the ID of the project related to the request.
     *
     * @param projectIdParam The project's ID to set.
     */
    public void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * toString method for this class.
     * @return String value.
     */
    @Override
    public final String toString() {
        return "RequestResource{"
                + "resourceId=" + resourceId
                + ", comment='" + comment + '\''
                + ", managerId=" + managerId
                + ", employeeId=" + employeeId
                + ", projectId=" + projectId
                + '}';
    }

    /**
     * equals method for this class.
     * @param o Object o.
     * @return boolean value.
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequestResource that)) {
            return false;
        }
        return Objects.equals(getResourceId(), that.getResourceId())
                && Objects.equals(getComment(), that.getComment())
                && Objects.equals(getManagerId(), that.getManagerId())
                && Objects.equals(getEmployeeId(), that.getEmployeeId())
                && Objects.equals(getProjectId(), that.getProjectId());
    }

    /**
     * hashcode method for this class.
     * @return int value.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getResourceId(), getComment(), getManagerId(),
                getEmployeeId(), getProjectId());
    }
}
