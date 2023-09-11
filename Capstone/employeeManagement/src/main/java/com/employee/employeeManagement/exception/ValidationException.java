package com.employee.employeeManagement.exception;

/**
 * Exception thrown to indicate a validation error in the system.
 */
public class ValidationException extends RuntimeException {
    /**
     * Constructs a new ValidationException with the specified detail message.
     *
     * @param message The detail message explaining the validation error.
     */
    public ValidationException(final String message) {
        super(message);
    }
}
