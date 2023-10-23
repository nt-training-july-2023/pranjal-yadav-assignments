package com.employee.employeeManagement.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationExceptionTest {
    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Validation error occurred";
        ValidationException exception = new ValidationException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testConstructorWithoutMessage() {
        ValidationException exception = new ValidationException(null);
        assertEquals(null, exception.getMessage());
    }
}
