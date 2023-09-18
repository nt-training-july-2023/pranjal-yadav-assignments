package com.employee.employeeManagement.response;

import com.employee.employeeManagement.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ApiResponseTest {
    @Test
    public void testGetMessage() {
        ApiResponse response = new ApiResponse("Test Message");
        assertEquals("Test Message", response.getMessage());
    }

    @Test
    public void testSetMessage() {
        ApiResponse response = new ApiResponse("Initial Message");
        response.setMessage("New Message");
        assertEquals("New Message", response.getMessage());
    }

    @Test
    public void testGetRole() {
        ApiResponse response = new ApiResponse("Test Message", Role.ADMIN);
        assertEquals(Role.ADMIN, response.getRole());
    }

    @Test
    public void testSetRole() {
        ApiResponse response = new ApiResponse("Test Message");
        response.setRole(Role.MANAGER);
        assertEquals(Role.MANAGER, response.getRole());
    }

    @Test
    public void testApiResponseConstructorWithMessage() {
        ApiResponse response = new ApiResponse("Test Message");
        assertEquals("Test Message", response.getMessage());
        assertNull(response.getRole()); // Role should be null in this constructor
    }

    @Test
    public void testApiResponseConstructorWithMessageAndRole() {
        ApiResponse response = new ApiResponse("Test Message", Role.EMPLOYEE);
        assertEquals("Test Message", response.getMessage());
        assertEquals(Role.EMPLOYEE, response.getRole());
    }
}
