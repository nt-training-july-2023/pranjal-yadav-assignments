package com.employee.employeeManagement.dto;


import com.employee.employeeManagement.constants.ErrorConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) representing a request resource.
 * This class is used for transferring data
 * related to employee management requests.
 */
public class RequestResourceDto {

    /**
     * The comment associated with the request.
     */
    @NotBlank
    private String comment;

    /**
     * The ID of the manager responsible for the request.
     */
    @NotNull(message = ErrorConstants.MANAGER_ID_REQUIRED)
    private Long managerId;

    /**
     * The ID of the employee associated with the request.
     */
    @NotNull(message = ErrorConstants.EMPLOYEE_ID_REQUIRED)
    private Long employeeId;

    /**
     * The ID of the project related to the request.
     */
    @NotNull(message = ErrorConstants.PROJECT_ID_REQUIRED)
    private Long projectId;

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
     * toString method of this class.
     * @return String value.
     */
    @Override
    public final String toString() {
        return "RequestResourceDto{"
                + "comment='" + comment + '\''
                + ", managerId=" + managerId
                + ", employeeId=" + employeeId
                + ", projectId=" + projectId
                + '}';
    }

    /**
     * Equals method for this class.
     * @param o object o.
     * @return boolean value.
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequestResourceDto that)) {
            return false;
        }
        return Objects.equals(getComment(), that.getComment())
                && Objects.equals(getManagerId(), that.getManagerId())
                && Objects.equals(getEmployeeId(), that.getEmployeeId())
                && Objects.equals(getProjectId(), that.getProjectId());
    }

    /**
     * hashcode method of this class.
     * @return int value.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getComment(),
                getManagerId(), getEmployeeId(), getProjectId());
    }
}
