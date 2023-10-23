package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void testToString() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("ankita.sharma@nucleusteq.com");
        loginDto.setPassword("ankita@123");

        String expected = "LoginDto{email='ankita.sharma@nucleusteq.com', password='ankita@123'}";

        assertEquals(expected, loginDto.toString());
    }
    @Test
    public void testHashCodeAndEquals() {
        LoginDto loginDto1 = new LoginDto();
        loginDto1.setEmail("ankita.sharma@nucleusteq.com");
        loginDto1.setPassword("admin123");

        LoginDto loginDto2 = new LoginDto();
        loginDto2.setEmail("ankita.sharma@nucleusteq.com");
        loginDto2.setPassword("admin123");
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("react");
        UserInDto user = new UserInDto();
        user.setName("Pranjal");
        user.setSkills(skills);
        user.setUserId("N7281");
        user.setContactNo(9876543210L);

        assertTrue(loginDto1.equals(loginDto1));
        assertFalse(loginDto1.equals(null));
        assertFalse(loginDto1.equals(""));
        assertEquals(loginDto1, loginDto1);
        assertNotEquals(loginDto1, user);


        assertTrue(loginDto1.equals(loginDto2));
        assertEquals(loginDto1.hashCode(), loginDto2.hashCode());
        assertEquals(loginDto1.hashCode(), loginDto2.hashCode());



        loginDto2.setEmail("pranjal@nucleusteq.com");
        assertNotEquals(loginDto1.hashCode(), loginDto2.hashCode());
        assertFalse(loginDto1.equals(loginDto2));




        loginDto2.setEmail("ankita.sharma@nucleusteq.com");
        loginDto2.setPassword("12345678");

        assertNotEquals(loginDto1.hashCode(), loginDto2.hashCode());
        assertFalse(loginDto1.equals(loginDto2));
    }
    @Test
    public void testEquals() {
        LoginDto loginDto1 = new LoginDto();
        User emp = new User();
        loginDto1.setEmail("ankita.sharma@nucleusteq.com");
        loginDto1.setPassword("admin123");

        LoginDto loginDto2 = new LoginDto();
        loginDto2.setEmail("ankita.sharma@nucleusteq.com");
        loginDto2.setPassword("admin123");

        assertTrue(loginDto1.equals(loginDto2));
        assertTrue(loginDto2.equals(loginDto1));
        assertTrue(loginDto1.equals(loginDto1));

        LoginDto loginDto3 = new LoginDto();
        loginDto3.setEmail("rashmi@nucleusteq.com");
        loginDto3.setPassword("rashmi@123");

        assertFalse(loginDto1.equals(loginDto3));
        assertFalse(loginDto3.equals(loginDto1));
        assertFalse(loginDto3.equals(null));
        assertFalse(loginDto1.getClass().equals(emp.getClass()));
    }

}
