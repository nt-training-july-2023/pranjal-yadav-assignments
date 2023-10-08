package com.employee.employeeManagement.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceAlreadyExistsTest {
    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Resource already exists.";
        ResourceAlreadyExistsException exception = new ResourceAlreadyExistsException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
