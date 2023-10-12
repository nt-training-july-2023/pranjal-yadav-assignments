package com.employee.employeeManagement.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ResponseDtoTest {
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
    public void testApiResponseConstructorWithMessage() {
        ResponseDto response = new ResponseDto("Test Message");
        assertEquals("Test Message", response.getMessage());
    }

    @Test
    public void testApiResponseConstructorWithMessageAndRole() {
        ResponseDto response = new ResponseDto("Test Message");
        assertEquals("Test Message", response.getMessage());
    }
}
