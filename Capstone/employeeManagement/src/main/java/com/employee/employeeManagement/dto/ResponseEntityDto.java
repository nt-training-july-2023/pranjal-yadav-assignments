package com.employee.employeeManagement.dto;

import lombok.Data;
/**
 * Data Transfer Object (DTO) representing a response
 * containing success status and a message.
 */
@Data
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
     * Constructs a new ResponseEntityDto with success status and message.
     *
     * @param isSuccessParam The success status of the response.
     * @param messageParam   The message associated with the response.
     */
    public ResponseEntityDto(final boolean isSuccessParam, String messageParam) {
        this.isSuccess = isSuccessParam;
        this.message = messageParam;
    }
}
