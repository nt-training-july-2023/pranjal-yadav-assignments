package com.employee.employeeManagement.exception;
/**
 * Exception thrown to indicate that a resource
 * already exists in the system.
 */
public class ResourceAlreadyExistsException extends RuntimeException {
    /**
     * Constructs a new ResourceAlreadyExistsException with
     * the specified detail message.
     *
     * @param message The detail message
     *               explaining the reason for the exception.
     */
    public ResourceAlreadyExistsException(final String message) {
        super(message);
    }
}
