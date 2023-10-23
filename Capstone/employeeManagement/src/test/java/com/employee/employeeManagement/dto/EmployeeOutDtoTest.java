package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeOutDtoTest {

    private EmployeeOutDto employee;

    @BeforeEach
    public void setUp() {
        employee = new EmployeeOutDto();
    }
    List<String> skills= new ArrayList<>();
    @Test
    public void testGettersAndSetters() {
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
    @Test
    void testToString() {
        EmployeeOutDto employee = new EmployeeOutDto();
        skills.add("Java");
        skills.add("React");
        employee.setSkills(skills);
        employee.setId(1L);
        employee.setName("Pranjal Yadav");
        employee.setEmail("pranjal@example.com");
        employee.setUserId("pranjal123");
        employee.setDob("2001-08-17");
        employee.setDoj("2023-07-17");
        employee.setLocation(Location.RAIPUR);
        employee.setDesignation(Designation.ENGINEER);
        employee.setContactNo(9087654321L);
        employee.setProjectId(2L);
        employee.setRole(Role.EMPLOYEE);
        employee.setManagerName("Ankita Sharma");
        employee.setProjectName("Petsmart");
        employee.setManagerId(3L);

        String expectedToString = "EmployeeOutDto{" +
                "id=1" +
                ", name='Pranjal Yadav'" +
                ", email='pranjal@example.com'" +
                ", userId='pranjal123'" +
                ", dob='2001-08-17'" +
                ", doj='2023-07-17'" +
                ", location=RAIPUR" +
                ", designation=ENGINEER" +
                ", contactNo=9087654321" +
                ", projectId=2" +
                ", role=EMPLOYEE" +
                ", managerName='Ankita Sharma'" +
                ", projectName='Petsmart'" +
                ", skills=[Java, React]" +
                ", managerId=3" +
                '}';
        assertEquals(expectedToString, employee.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
        skills.add("java");
        skills.add("react");
        EmployeeOutDto employee1 = new EmployeeOutDto();
        EmployeeOutDto employee2 = new EmployeeOutDto();
        employee1.setName("Pranjal");
        employee1.setEmail("pranjal@nucleusteq.com");
        employee1.setSkills(skills);
        employee1.setUserId("N7281");
        employee1.setContactNo(9876543210L);

        employee2.setName("Pranjal");
        employee2.setEmail("pranjal@nucleusteq.com");
        employee2.setSkills(skills);
        employee2.setUserId("N7281");
        employee2.setContactNo(9876543210L);
        UserInDto user = new UserInDto();
        user.setName("Pranjal");
        user.setSkills(skills);
        user.setUserId("N7281");
        user.setContactNo(9876543210L);


        assertEquals(employee1, employee2);
        assertEquals(employee2, employee1);
        assertNotEquals(employee1, user);
        assertNotEquals(employee1, user);
        assertEquals(employee1, employee1);
        assertEquals(employee1.hashCode(), employee2.hashCode());

        employee2.setUserId("N8888");

        // Test equals() method after modifying a property
        assertFalse(employee1.equals(employee2));
    }

}

