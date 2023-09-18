package com.employee.employeeManagement.exceptionTest;

import com.employee.employeeManagement.exception.WrongCredentialsExceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WrongCredentialsExceptionTest {
    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Invalid credentials";
        WrongCredentialsExceptions exception = new WrongCredentialsExceptions(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testConstructorWithoutMessage() {
        WrongCredentialsExceptions exception = new WrongCredentialsExceptions(null);
        assertEquals(null, exception.getMessage());
    }
}
