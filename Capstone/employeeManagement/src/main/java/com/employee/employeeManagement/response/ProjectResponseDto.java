package com.employee.employeeManagement.response;

/**
 * Represents a response from the project-related API operations.
 */
public class ProjectResponseDto {
    /**
     * The message to be sent.
     */
    private String message;

    /**
     * Constructs a new ProjectResponseDto instance with the given message.
     *
     * @param messageParam The message to be included in the response.
     */
    public ProjectResponseDto(final String messageParam) {
        this.message = messageParam;
    }

    /**
     * Get the message included in the response.
     *
     * @return The response message.
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Set the message to be included in the response.
     *
     * @param messageParam The response message to set.
     */
    public final void setMessage(final String messageParam) {
        this.message = messageParam;
    }
}

