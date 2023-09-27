package com.employee.employeeManagement.outDtoTest;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.dto.ManagerOutDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerOutDtoTest {
    private ManagerOutDto managerOutDto;

    @BeforeEach
    public void setUp() {
        managerOutDto = new ManagerOutDto();
    }

    @Test
    public void testIdGetterSetter() {
        managerOutDto.setId(1L);
        assertEquals(1L, managerOutDto.getId());
    }

    @Test
    public void testNameGetterSetter() {
        managerOutDto.setName("Ankita Sharma");
        assertEquals("Ankita Sharma", managerOutDto.getName());
    }

    @Test
    public void testEmailGetterSetter() {
        managerOutDto.setEmail("ankita.sharma@nucleusteq.com");
        assertEquals("ankita.sharma@nucleusteq.com", managerOutDto.getEmail());
    }

    @Test
    public void testUserIdGetterSetter() {
        managerOutDto.setUserId("ankita@123");
        assertEquals("ankita@123", managerOutDto.getUserId());
    }

    @Test
    public void testDobGetterSetter() {
        managerOutDto.setDob("1990-01-01");
        assertEquals("1990-01-01", managerOutDto.getDob());
    }

    @Test
    public void testDojGetterSetter() {
        managerOutDto.setDoj("2020-01-01");
        assertEquals("2020-01-01", managerOutDto.getDoj());
    }

    @Test
    public void testLocationGetterSetter() {
        managerOutDto.setLocation(Location.INDORE);
        assertEquals(Location.INDORE, managerOutDto.getLocation());
    }

    @Test
    public void testDesignationGetterSetter() {
        managerOutDto.setDesignation(Designation.RECRUITER);
        assertEquals(Designation.RECRUITER, managerOutDto.getDesignation());
    }

    @Test
    public void testContactNoGetterSetter() {
        managerOutDto.setContactNo(1234567890L);
        assertEquals(1234567890L, managerOutDto.getContactNo());
    }

    @Test
    public void testProjectIdGetterSetter() {
        managerOutDto.setProjectId(100L);
        assertEquals(100L, managerOutDto.getProjectId());
    }

    @Test
    public void testRoleGetterSetter() {
        managerOutDto.setRole(Role.ADMIN);
        assertEquals(Role.ADMIN, managerOutDto.getRole());
    }

    @Test
    public void testManagerNameGetterSetter() {
        managerOutDto.setManagerName("Manager Name");
        assertEquals("Manager Name", managerOutDto.getManagerName());
    }

    @Test
    public void testProjectNameGetterSetter() {
        managerOutDto.setProjectName("Project Name");
        assertEquals("Project Name", managerOutDto.getProjectName());
    }

    @Test
    public void testSkillsGetterSetter() {
        List<String> skills = Arrays.asList("Java", "React");
        managerOutDto.setSkills(skills);
        assertEquals(skills, managerOutDto.getSkills());
    }

    @Test
    public void testManagerIdGetterSetter() {
        managerOutDto.setManagerId(10L);
        assertEquals(10L, managerOutDto.getManagerId());
    }

    @Test
    public void testTeamGetterSetter() {
        List<String> team = new ArrayList<>(Arrays.asList("Nachiketa",
                "Ishita"));
        managerOutDto.setTeam(team);
        assertEquals(team, managerOutDto.getTeam());
    }
}
