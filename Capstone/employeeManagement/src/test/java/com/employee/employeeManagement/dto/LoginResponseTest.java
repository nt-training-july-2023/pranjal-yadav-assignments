package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Role;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoginResponseTest {
    @Test
    public void testGettersAndSetters() {
        LoginResponse response = new LoginResponse();

        response.setMessage("Login Successful");
        response.setId(1L);
        response.setRole(Role.EMPLOYEE);
        response.setName("Pranjal");

        assertEquals("Login Successful", response.getMessage());
        assertEquals(1L, response.getId());
        assertEquals(Role.EMPLOYEE, response.getRole());
        assertEquals("Pranjal", response.getName());
    }
    @Test
    public void testEqualsAndHashCode() {
        LoginResponse response1 = new LoginResponse("Success", 1L, Role.MANAGER,
                "Rashmi");
        LoginResponse response2 = new LoginResponse("Success", 1L, Role.MANAGER,
                "Rashmi");
        LoginResponse response3 = new LoginResponse("Failure", 2L, Role.ADMIN
                , "Ankita");
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("react");
        UserInDto user = new UserInDto();
        user.setName("Pranjal");
        user.setSkills(skills);
        user.setUserId("N7281");
        user.setContactNo(9876543210L);

        assertTrue(response1.equals(response2));
        assertFalse(response1.equals(response3));
        assertEquals(response1, response1);
        assertNotEquals(response1, user);

        assertEquals(response1.hashCode(), response2.hashCode());
        assertNotEquals(response1.hashCode(), response3.hashCode());
    }
    @Test
    public void testToString() {
        LoginResponse response = new LoginResponse("Success", 1L, Role.EMPLOYEE,
                "Vanshika");
        String expected = "LoginResponse{message='Success', id=1, " +
                "role=EMPLOYEE, " +
                "name='Vanshika'}";
        assertEquals(expected, response.toString());
    }
}
