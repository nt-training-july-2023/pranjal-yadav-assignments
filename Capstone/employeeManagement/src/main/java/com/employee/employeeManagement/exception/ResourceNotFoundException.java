package com.employee.employeeManagement.exception;


/**
 * Exception class to indicate that a requested resource was not found.
 */
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Constructs a new ResourceNotFoundException
     * with the specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
