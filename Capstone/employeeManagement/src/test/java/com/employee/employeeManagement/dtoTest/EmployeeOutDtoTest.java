package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.outDtos.EmployeeOutDto;
import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeOutDtoTest {

    private EmployeeOutDto employee;

    @BeforeEach
    public void setUp() {
        employee = new EmployeeOutDto();
    }

    @Test
    public void testGettersAndSetters() {
        // Set values using setters
        employee.setId(1L);
        employee.setName("Rashmi Shukla");
        employee.setEmail("rashmi@nucleusteq.com");
        employee.setUserId("N1000");
        employee.setDob("17-08-2001");
        employee.setDoj("17-07-2023");
        employee.setLocation(Location.RAIPUR);
        employee.setDesignation(Designation.ENGINEER);
        employee.setContactNo(1234567890L);
        employee.setProjectId(3L);
        employee.setRole(Role.EMPLOYEE);
        employee.setManagerName("Ankita Sharma");
        employee.setProjectName("Petsmart");
        employee.setSkills(Arrays.asList("Java", "SQL"));
        employee.setManagerId(2L);

        assertEquals(1L, employee.getId());
        assertEquals("Rashmi Shukla", employee.getName());
        assertEquals("rashmi@nucleusteq.com", employee.getEmail());
        assertEquals("N1000", employee.getUserId());
        assertEquals("17-08-2001", employee.getDob());
        assertEquals("17-07-2023", employee.getDoj());
        assertEquals(Location.RAIPUR, employee.getLocation());
        assertEquals(Designation.ENGINEER, employee.getDesignation());
        assertEquals(1234567890L, employee.getContactNo());
        assertEquals(3L, employee.getProjectId());
        assertEquals(Role.EMPLOYEE, employee.getRole());
        assertEquals("Ankita Sharma", employee.getManagerName());
        assertEquals("Petsmart", employee.getProjectName());
        assertEquals(Arrays.asList("Java", "SQL"), employee.getSkills());
        assertEquals(2L, employee.getManagerId());
    }
}

