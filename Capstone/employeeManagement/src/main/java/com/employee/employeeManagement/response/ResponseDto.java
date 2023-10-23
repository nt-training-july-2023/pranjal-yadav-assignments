package com.employee.employeeManagement.response;


/**
 * Response class for API responses.
 */
public class ResponseDto {
    /**
     * The message included in the API response.
     */
    private String message;
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
     * Constructor.
     * @param messageParam .
     */

    public ResponseDto(final String messageParam) {
        this.message = messageParam;
    }

}
