package com.employee.employeeManagement.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceNotFoundTest {
    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Resource not found";
        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testConstructorWithoutMessage() {
        ResourceNotFoundException exception = new ResourceNotFoundException(null);
        assertEquals(null, exception.getMessage());
    }
}
