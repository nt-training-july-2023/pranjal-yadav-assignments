package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.dto.LoginDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginDtoTest {
    private LoginDto loginDto;

    @BeforeEach
    public void setUp() {
        loginDto = new LoginDto();
    }

    @Test
    public void testGettersAndSetters() {
        loginDto.setEmail("admin@nucleusteq.com");
        loginDto.setPassword("Password@123");

        assertEquals("admin@nucleusteq.com", loginDto.getEmail());
        assertEquals("Password@123", loginDto.getPassword());
    }

}
