package com.employee.employeeManagement.response;

import com.employee.employeeManagement.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response class for API responses.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    /**
     * The message included in the API response.
     */
    private String message;
    /**
     * This is the tole of the current user.
     */
    private Role role;

    /**
     * Cnstructor for taking only message.
     * @param messageParam .
     */
    public ApiResponse(final String messageParam) {
        this.message = messageParam;
    }
}
