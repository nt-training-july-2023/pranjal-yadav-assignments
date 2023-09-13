package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceAlreadyExistsExceptionTest {

    @Test
    public void testResourceAlreadyExistsException() {
        String errorMessage = "Resource already exists";
        ResourceAlreadyExistsException exception = new ResourceAlreadyExistsException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }
}
