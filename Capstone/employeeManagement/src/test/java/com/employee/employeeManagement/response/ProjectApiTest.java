package com.employee.employeeManagement.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectApiTest {
    @Test
    public void testGetMessage() {
        ProjectApiResponse response = new ProjectApiResponse("Test Message");
        assertEquals("Test Message", response.getMessage());
    }

    @Test
    public void testSetMessage() {
        ProjectApiResponse response = new ProjectApiResponse("Initial Message");
        response.setMessage("New Message");
        assertEquals("New Message", response.getMessage());
    }

    @Test
    public void testProjectApiResponseConstructorWithMessage() {
        ProjectApiResponse response = new ProjectApiResponse("Test Message");
        assertEquals("Test Message", response.getMessage());
    }
}

