package com.employee.employeeManagement.exception;

/**
 * Exception thrown to indicate that provided credentials are incorrect.
 */
public class InvalidCredentialsExceptions extends RuntimeException {
    /**
     * Constructs a new InvalidCredentialsExceptions with the
     * specified detail message.
     *
     * @param message The detail message explaining
     *                the reason for the exception.
     */
    public InvalidCredentialsExceptions(final String message) {
        super(message);
    }
}
