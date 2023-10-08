package com.employee.employeeManagement.constants;

public final class ErrorConstants {
    /**
     * Constant for emoil error.
     */
    public static final String
            GIVE_REGISTERED_EMAIL = "Give registered email"
            + " id";
    /**
     * Constant for incorrect password.
     */
    public static final String PASSWORD_INCORRECT = "Password is incorrect";
    /**
     * Constant for user id already exists while registering.
     */
    public static final String USER_EXISTS = "This user id already exists";
    /**
     * Constant for project name.
     */

    public static final String PROJECT_NAME = "This project name already "
            + "exists";
    /**
     * Constant for employee does not exist.
     */
    public static final String EMPLOYEE_NOT_EXIST = "This employee does not "
            + "exist";
    /**
     * Constant for manager not exist.
     */
    public static final String MANAGER_NOT_EXIST = "This manager does not "
            + "exist";
    /**
     * Constant for project not exist.
     */
    public static final String PROJECT_NOT_EXIST = "This project does not "
            + "exist";
    /**
     * Constant for request not exist.
     */
    public static final String RESOURCE_NOT_EXIST = "This request does not "
            + "exists";
    /**
     * Constant for employee already assigned a project.
     */
    public static final String EMPLOYEE_ALREADY_ASSIGNED = "This employee has "
            + "already been assigned a project";
    /**
     * Constant for role not exist.
     */
    public static final String ROLE_NOT_EXISTS = "This role does not exists";
    private ErrorConstants() {

    }
}
