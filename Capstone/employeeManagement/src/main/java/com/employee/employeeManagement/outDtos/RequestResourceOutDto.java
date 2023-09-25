package com.employee.employeeManagement.outDtos;


/**
 * Data Transfer Object (DTO) representing
 * a response for request resource details.
 */
public class RequestResourceOutDto {

    /**
     * The unique identifier for the resource.
     */
    private Long resourceId;

    /**
     * The comment associated with the request.
     */
    private String comment;

    /**
     * The ID of the manager responsible for the request.
     */
    private Long managerId;

    /**
     * The ID of the employee associated with the request.
     */
    private Long employeeId;

    /**
     * The ID of the project related to the request.
     */
    private Long projectId;

    /**
     * The name of the project related to the request.
     */
    private String projectName;

    /**
     * The name of the employee associated with the request.
     */
    private String employeeName;

    /**
     * The name of the manager responsible for the request.
     */
    private String managerName;

    /**
     * The user ID of the employee associated with the request.
     */
    private String employeeUserId;

    /**
     * The user ID of the manager responsible for the request.
     */
    private String managerUserId;

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
        this.resourceId = resourceIdParam;
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
     * Get the name of the project related to the request.
     *
     * @return The project's name.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Set the name of the project related to the request.
     *
     * @param projectNameParam The project's name to set.
     */
    public void setProjectName(final String projectNameParam) {
        this.projectName = projectNameParam;
    }

    /**
     * Get the name of the employee associated with the request.
     *
     * @return The employee's name.
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Set the name of the employee associated with the request.
     *
     * @param employeeNameParam The employee's name to set.
     */
    public void setEmployeeName(final String employeeNameParam) {
        this.employeeName = employeeNameParam;
    }

    /**
     * Get the name of the manager responsible for the request.
     *
     * @return The manager's name.
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Set the name of the manager responsible for the request.
     *
     * @param managerNameParam The manager's name to set.
     */
    public void setManagerName(final String managerNameParam) {
        this.managerName = managerNameParam;
    }

    /**
     * Get the user ID of the employee associated with the request.
     *
     * @return The employee's user ID.
     */
    public String getEmployeeUserId() {
        return employeeUserId;
    }

    /**
     * Set the user ID of the employee associated with the request.
     *
     * @param employeeUserIdParam The employee's user ID to set.
     */
    public void setEmployeeUserId(final String employeeUserIdParam) {
        this.employeeUserId = employeeUserIdParam;
    }

    /**
     * Get the user ID of the manager responsible for the request.
     *
     * @return The manager's user ID.
     */
    public String getManagerUserId() {
        return managerUserId;
    }

    /**
     * Set the user ID of the manager responsible for the request.
     *
     * @param managerUserIdParam The manager's user ID to set.
     */
    public void setManagerUserId(final String managerUserIdParam) {
        this.managerUserId = managerUserIdParam;
    }
}
