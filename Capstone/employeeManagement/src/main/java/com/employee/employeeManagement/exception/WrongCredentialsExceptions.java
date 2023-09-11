package com.employee.employeeManagement.exception;

/**
 * Exception thrown to indicate that provided credentials are incorrect.
 */
public class WrongCredentialsExceptions extends RuntimeException {
    /**
     * Constructs a new WrongCredentialsExceptions with the
     * specified detail message.
     *
     * @param message The detail message explaining
     *                the reason for the exception.
     */
    public WrongCredentialsExceptions(final String message) {
        super(message);
    }
}
