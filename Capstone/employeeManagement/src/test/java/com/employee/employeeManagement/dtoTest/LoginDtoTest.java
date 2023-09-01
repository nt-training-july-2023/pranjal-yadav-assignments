package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.dto.LoginDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginDtoTest {
    @Test
    public void testConstructorAndGetters(){
        LoginDto loginDto = new LoginDto("ankita@nucleusteq.com", "12345");
        assertEquals("ankita@nucleusteq.com",loginDto.getEmail());
        assertEquals("12345", loginDto.getPassword());
    }
    @Test
    public void testSetters(){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("Ankita@nucleusteq.com");
        loginDto.setPassword("12345");

        assertEquals("Ankita@nucleusteq.com", loginDto.getEmail());
        assertEquals("12345", loginDto.getPassword());
    }
}
