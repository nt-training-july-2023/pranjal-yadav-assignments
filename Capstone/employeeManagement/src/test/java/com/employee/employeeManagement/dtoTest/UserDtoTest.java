package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDtoTest {
    private UserDto userDto;

    @BeforeEach
    public void setUp() {
        userDto = new UserDto();
    }

    @Test
    public void testGettersAndSetters() {
        userDto.setName("Rashmi Shukla");
        userDto.setEmail("rashmi@nucleusteq.com");
        userDto.setUserId("N1234");
        userDto.setDob("17-08-2001");
        userDto.setDoj("17-07-2023");
        userDto.setLocation(Location.INDORE);
        userDto.setDesignation(Designation.ENGINEER);
        userDto.setContactNo(1234567890L);
        userDto.setProjectId(1L);
        userDto.setRole(Role.EMPLOYEE);
        userDto.setPassword("password");
        List<String> skills = Arrays.asList("Java", "Spring", "SQL");
        userDto.setSkills(skills);
        userDto.setManagerId(101L);

        assertEquals("Rashmi Shukla", userDto.getName());
        assertEquals("rashmi@nucleusteq.com", userDto.getEmail());
        assertEquals("N1234", userDto.getUserId());
        assertEquals("17-08-2001", userDto.getDob());
        assertEquals("17-07-2023", userDto.getDoj());
        assertEquals(Location.INDORE, userDto.getLocation());
        assertEquals(Designation.ENGINEER, userDto.getDesignation());
        assertEquals(1234567890L, userDto.getContactNo());
        assertEquals(1L, userDto.getProjectId());
        assertEquals(Role.EMPLOYEE, userDto.getRole());
        assertEquals("password", userDto.getPassword());
        assertEquals(skills, userDto.getSkills());
        assertEquals(101L, userDto.getManagerId());

    }
}
