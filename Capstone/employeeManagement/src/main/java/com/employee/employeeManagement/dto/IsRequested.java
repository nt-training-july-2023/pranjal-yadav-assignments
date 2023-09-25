package com.employee.employeeManagement.dto;

public class IsRequested {
    /**
     * id of requested employee.
     */
    private Long employeeId;
    /**
     * Email of requesting manager.
     */
    private String managerEmail;
    /**
     * The unique identifier of the employee.
     *
     * @return The employee's unique identifier.
     */

    public Long getEmployeeId() {
        return employeeId;
    }
    /**
     * Sets the unique identifier of the employee.
     *
     * @param employeeIdParam The employee's unique identifier.
     */
    public void setEmployeeId(final Long employeeIdParam) {
        this.employeeId = employeeIdParam;
    }
    /**
     * Gets the email address of the manager.
     *
     * @return The email address of the manager.
     */
    public String getManagerEmail() {
        return managerEmail;
    }

    /**
     * Sets the email address of the manager.
     *
     * @param managerEmailParam The email address of the manager.
     */
    public void setManagerEmail(final String managerEmailParam) {
        this.managerEmail = managerEmailParam;
    }
}
