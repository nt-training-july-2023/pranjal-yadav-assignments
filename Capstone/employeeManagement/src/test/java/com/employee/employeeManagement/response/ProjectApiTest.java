package com.employee.employeeManagement.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectApiTest {
    @Test
    public void testGetMessage() {
        ProjectResponseDto response = new ProjectResponseDto("Test Message");
        assertEquals("Test Message", response.getMessage());
    }

    @Test
    public void testSetMessage() {
        ProjectResponseDto response = new ProjectResponseDto("Initial Message");
        response.setMessage("New Message");
        assertEquals("New Message", response.getMessage());
    }

    @Test
    public void testProjectApiResponseConstructorWithMessage() {
        ProjectResponseDto response = new ProjectResponseDto("Test Message");
        assertEquals("Test Message", response.getMessage());
    }
}

