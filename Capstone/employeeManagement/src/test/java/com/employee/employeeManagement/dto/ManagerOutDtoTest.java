package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.dto.ManagerOutDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ManagerOutDtoTest {
    private ManagerOutDto managerOutDto;
    List<String> skills = new ArrayList<>();
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
    @Test
    public void testToString() {
        ManagerOutDto dto = new ManagerOutDto();
        dto.setId(1L);
        dto.setName("Test Manager");
        dto.setEmail("manager@example.com");
        dto.setUserId("manager123");
        dto.setDob("2000-01-01");
        dto.setDoj("2022-01-01");
        dto.setLocation(Location.RAIPUR);
        dto.setDesignation(Designation.ENGINEER);
        dto.setContactNo(1234567890L);
        dto.setProjectId(5L);
        dto.setRole(Role.MANAGER);
        dto.setManagerName("Senior Manager");
        dto.setProjectName("Test Project");
        dto.setManagerId(2L);
        dto.setTeam(Collections.singletonList("Team Member"));
        skills.add("Java");
        skills.add("React");
        dto.setSkills(skills);

        String expectedToString = "ManagerOutDto{" +
                "id=1, " +
                "name='Test Manager', " +
                "email='manager@example.com', " +
                "userId='manager123', " +
                "dob='2000-01-01', " +
                "doj='2022-01-01', " +
                "location=RAIPUR, " +
                "designation=ENGINEER, " +
                "contactNo=1234567890, " +
                "projectId=5, " +
                "role=MANAGER, " +
                "managerName='Senior Manager', " +
                "projectName='Test Project', " +
                "skills=[Java, React], " +
                "managerId=2, " +
                "team=[Team Member]" +
                "}";

        assertEquals(expectedToString, dto.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        ManagerOutDto dto1 = new ManagerOutDto();
        dto1.setId(1L);
        dto1.setName("Test Manager");
        dto1.setEmail("manager@example.com");
        dto1.setUserId("manager123");
        dto1.setDob("2000-01-01");
        dto1.setDoj("2022-01-01");
        dto1.setLocation(Location.RAIPUR);
        dto1.setDesignation(Designation.ENGINEER);
        dto1.setContactNo(1234567890L);
        dto1.setProjectId(5L);
        dto1.setRole(Role.MANAGER);
        dto1.setManagerName("Senior Manager");
        dto1.setProjectName("Test Project");
        dto1.setManagerId(2L);
        dto1.setTeam(Collections.singletonList("Team Member"));
        skills.add("Java");
        skills.add("React");
        dto1.setSkills(skills);

        ManagerOutDto dto2 = new ManagerOutDto();
        dto2.setId(1L);
        dto2.setName("Test Manager");
        dto2.setEmail("manager@example.com");
        dto2.setUserId("manager123");
        dto2.setDob("2000-01-01");
        dto2.setDoj("2022-01-01");
        dto2.setLocation(Location.RAIPUR);
        dto2.setDesignation(Designation.ENGINEER);
        dto2.setContactNo(1234567890L);
        dto2.setProjectId(5L);
        dto2.setRole(Role.MANAGER);
        dto2.setManagerName("Senior Manager");
        dto2.setProjectName("Test Project");
        dto2.setManagerId(2L);
        dto2.setTeam(Collections.singletonList("Team Member"));
        dto2.setSkills(skills);

        ManagerOutDto differentDto = new ManagerOutDto();
        differentDto.setId(2L);
        differentDto.setName("Different Manager");
        differentDto.setEmail("different@example.com");
        differentDto.setUserId("different123");
        differentDto.setDob("2001-01-01");
        differentDto.setDoj("2023-01-01");
        differentDto.setLocation(Location.BANGALORE);
        differentDto.setDesignation(Designation.ARCHITECT);
        differentDto.setContactNo(9876543210L);
        differentDto.setProjectId(6L);
        differentDto.setRole(Role.EMPLOYEE);
        differentDto.setManagerName("Manager");
        differentDto.setProjectName("Different Project");
        differentDto.setManagerId(3L);
        differentDto.setTeam(Collections.singletonList("Different Team Member"));
        differentDto.setSkills(skills);

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("react");
        UserInDto user = new UserInDto();
        user.setName("Pranjal");
        user.setSkills(skills);
        user.setUserId("N7281");
        user.setContactNo(9876543210L);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertEquals(dto1, dto1);
        assertNotEquals(dto1, user);

        assertNotEquals(dto1, differentDto);
        assertNotEquals(dto1.hashCode(), differentDto.hashCode());
    }
}
