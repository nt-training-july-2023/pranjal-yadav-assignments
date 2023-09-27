package com.employee.employeeManagement.response;

import com.employee.employeeManagement.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ApiResponseTest {
    @Test
    public void testGetMessage() {
        ResponseDto response = new ResponseDto("Test Message");
        assertEquals("Test Message", response.getMessage());
    }

    @Test
    public void testSetMessage() {
        ResponseDto response = new ResponseDto("Initial Message");
        response.setMessage("New Message");
        assertEquals("New Message", response.getMessage());
    }

    @Test
    public void testGetRole() {
        ResponseDto response = new ResponseDto("Test Message", Role.ADMIN);
        assertEquals(Role.ADMIN, response.getRole());
    }

    @Test
    public void testSetRole() {
        ResponseDto response = new ResponseDto("Test Message");
        response.setRole(Role.MANAGER);
        assertEquals(Role.MANAGER, response.getRole());
    }

    @Test
    public void testApiResponseConstructorWithMessage() {
        ResponseDto response = new ResponseDto("Test Message");
        assertEquals("Test Message", response.getMessage());
        assertNull(response.getRole()); // Role should be null in this constructor
    }

    @Test
    public void testApiResponseConstructorWithMessageAndRole() {
        ResponseDto response = new ResponseDto("Test Message", Role.EMPLOYEE);
        assertEquals("Test Message", response.getMessage());
        assertEquals(Role.EMPLOYEE, response.getRole());
    }
}
