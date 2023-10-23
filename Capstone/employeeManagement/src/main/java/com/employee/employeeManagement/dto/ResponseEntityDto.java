package com.employee.employeeManagement.dto;



/**
 * Data Transfer Object (DTO) representing a response
 * containing success status and a message.
 */
 public class ResponseEntityDto {
    /**
     * Indicates whether the operation was successful.
     */
    private boolean isSuccess;
    /**
     * The message associated with the response.
     */
    private String message;

    /**
     * Getter method which will return boolean
     * value isSuccess.
     * @return isSuccess.
     */
    public final boolean getIsSuccess() {
        return isSuccess;
    }

    /**
     * Get the message.
     *
     * @return The message.
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Set the success status.
     *
     * @param successParam The success status to set.
     */
    public final void setSuccess(final
            boolean successParam) {
        isSuccess = successParam;
    }

    /**
     * Set the message.
     *
     * @param messageParam The message to set.
     */
    public final void setMessage(final String messageParam) {
        this.message = messageParam;
    }


    /**
     * Constructs a new ResponseEntityDto with success status and message.
     *
     * @param isSuccessParam The success status of the response.
     * @param messageParam   The message associated with the response.
     */
    public ResponseEntityDto(final boolean isSuccessParam,
                             final String messageParam) {
        this.isSuccess = isSuccessParam;
        this.message = messageParam;
    }

    /**
     * No argument constructor.
     */
    public ResponseEntityDto() {

    }

}
