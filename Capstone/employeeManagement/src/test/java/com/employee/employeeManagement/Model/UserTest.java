package com.employee.employeeManagement.Model;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.Model.User;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        // Test setters
        user.setId(1L);
        user.setName("Rashmi Shukla");
        user.setEmail("rashmi@nucleusteq.com");
        user.setUserId("N1000");
        user.setDob("17-08-2001");
        user.setDoj("17-07-2023");
        user.setLocation(Location.INDORE);
        user.setDesignation(Designation.SENIOR_ENGINEER);
        user.setContactNo(1234567890L);
        user.setProjectId(1L);
        user.setRole(Role.EMPLOYEE);
        user.setPassword("N1000@17082001");
        user.setSkills(Collections.singletonList("Java"));
        user.setManagerId(4L);

        // Test getters
        assertEquals(1L, user.getId());
        assertEquals("Rashmi Shukla", user.getName());
        assertEquals("rashmi@nucleusteq.com", user.getEmail());
        assertEquals("N1000", user.getUserId());
        assertEquals("17-08-2001", user.getDob());
        assertEquals("17-07-2023", user.getDoj());
        assertEquals(Location.INDORE, user.getLocation());
        assertEquals(Designation.SENIOR_ENGINEER, user.getDesignation());
        assertEquals(1234567890L, user.getContactNo());
        assertEquals(1L, user.getProjectId());
        assertEquals(Role.EMPLOYEE, user.getRole());
        assertEquals("N1000@17082001", user.getPassword());
        assertEquals(Collections.singletonList("Java"), user.getSkills());
        assertEquals(4L, user.getManagerId());
    }
}


