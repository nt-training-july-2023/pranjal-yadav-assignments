package com.employee.employeeManagement.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WrongCredentialsExceptionTest {
    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Invalid credentials";
        InvalidCredentialsExceptions exception = new InvalidCredentialsExceptions(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testConstructorWithoutMessage() {
        InvalidCredentialsExceptions exception = new InvalidCredentialsExceptions(null);
        assertEquals(null, exception.getMessage());
    }
}
