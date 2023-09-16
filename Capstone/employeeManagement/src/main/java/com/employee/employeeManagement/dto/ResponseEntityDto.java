package com.employee.employeeManagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


/**
 * Data Transfer Object (DTO) representing a response
 * containing success status and a message.
 */
@NoArgsConstructor
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

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
