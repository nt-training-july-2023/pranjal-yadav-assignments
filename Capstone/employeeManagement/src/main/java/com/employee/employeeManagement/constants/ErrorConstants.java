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
    /**
     * Constant for email regular expression.
     */

    public static final String EMAIL_REGEX = "Email should end with "
            + "nucleusteq.com.";
    /**
     * Constant for user id regular expression.
     */
    public static final String USER_ID_REGEX = "User id must be of the "
            + "format NXXXX";
    /**
     * Constant for contact number required.
     */
    public static final String CONTACT_REQUIRED = "Contact number is required.";
    /**
     * Constant for project name regular expression.
     */
    public static final String PROJECT_NAME_REGEX = "Project name is required.";
    /**
     * Constant for manager required.
     */
    public static final String MANAGER_REQUIRED = "Manager Id is required";
    /**
     * Constant for start date required.
     */
    public static final String START_DATE_REQUIRED = "Start date is required.";
    /**
     * Constant for description required.
     */
    public static final String DESCRIPTION_REQUIRED = "Project "
            + "Description is "
            + "required.";
    /**
     * Constant for skills required.
     */
    public static final String SKILLS_REQUIRED = "Skills are required.";
    /**
     * Constant for manager id required.
     */
    public static final String MANAGER_ID_REQUIRED = "Manager id is required";
    /**
     * Constant for employee id required.
     */
    public static final String EMPLOYEE_ID_REQUIRED = "Employee id is required";
    /**
     * Constant for project id required.
     */
    public static final String PROJECT_ID_REQUIRED = "Project id is required.";
    private ErrorConstants() {

    }
}
