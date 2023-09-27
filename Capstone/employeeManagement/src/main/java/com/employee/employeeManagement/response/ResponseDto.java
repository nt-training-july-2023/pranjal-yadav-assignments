package com.employee.employeeManagement.response;

import com.employee.employeeManagement.enums.Role;

/**
 * Response class for API responses.
 */
public class ResponseDto {
    /**
     * The message included in the API response.
     */
    private String message;
    /**
     * This is the tole of the current user.
     */
    private Role role;

    /**
     * Get the message associated with the response.
     *
     * @return The response message.
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Set the message for the response.
     *
     * @param messageParam The response message to set.
     */
    public final void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    /**
     * Get the role associated with the response.
     *
     * @return The role.
     */
    public final Role getRole() {
        return role;
    }

    /**
     * Set the role for the response.
     *
     * @param roleParam The role to set.
     */
    public final void setRole(final Role roleParam) {
        this.role = roleParam;
    }


    /**
     * Constructor for taking only message.
     * @param messageParam .
     */

    public ResponseDto(final String messageParam) {
        this.message = messageParam;
    }

    /**
     * All arguments constructor.
     * @param messageParam Mesaage to be sent.
     * @param roleParam Role of the current user.
     */
    public ResponseDto(final String messageParam, final Role roleParam) {
        this.message = messageParam;
        this.role = roleParam;
    }
}
