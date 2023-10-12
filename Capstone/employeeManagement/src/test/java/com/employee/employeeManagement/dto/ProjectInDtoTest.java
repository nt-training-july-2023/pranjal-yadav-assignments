package com.employee.employeeManagement.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectInDtoTest {
    private ProjectInDto projectDto;

    @BeforeEach
    public void setUp() {
        projectDto = new ProjectInDto();
    }
    List<String> skills = new ArrayList<>();

    @Test
    public void testGettersAndSetters() {
        projectDto.setProjectName("Petsmart");
        projectDto.setManagerId(2L);
        projectDto.setDescription("Description for Petsmart");
        projectDto.setStartDate("9-09-2023");
        List<String> skills = Arrays.asList("Java", "Spring", "SQL");
        projectDto.setSkills(skills);

        assertEquals("Petsmart", projectDto.getProjectName());
        assertEquals(2L, projectDto.getManagerId());
        assertEquals("Description for Petsmart", projectDto.getDescription());
        assertEquals("9-09-2023", projectDto.getStartDate());
        assertEquals(skills, projectDto.getSkills());
    }
    @Test
    public void testToString() {
        skills.add("Java");
        skills.add("Spring boot");
        ProjectInDto project = new ProjectInDto();
        project.setManagerId(2L);
        project.setProjectName("Petsmart");
        project.setSkills(skills);
        project.setDescription("Petsmart description");
        project.setStartDate("17-07-2023");
        String expected = "ProjectInDto{projectName='Petsmart', managerId=2, " +
                "description='Petsmart description', startDate='17-07-2023'," +
                " skills=[Java, Spring boot]}";
        assertEquals(expected, project.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
        skills.add("Hibernate");
        skills.add("MySql");
        ProjectInDto project1 = new ProjectInDto();
        ProjectInDto project2 = new ProjectInDto();
        project1.setProjectName("Nuodata");
        project1.setStartDate("17-07-2023");
        project1.setDescription("Description");
        project1.setManagerId(2l);
        project1.setSkills(skills);

        project2.setProjectName("Nuodata");
        project2.setStartDate("17-07-2023");
        project2.setDescription("Description");
        project2.setManagerId(2l);
        project2.setSkills(skills);

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("react");
        UserInDto user = new UserInDto();
        user.setName("Pranjal");
        user.setSkills(skills);
        user.setUserId("N7281");
        user.setContactNo(9876543210L);

        assertTrue(project1.equals(project2));
        assertEquals(project1, project1);
        assertNotEquals(project1, user);

        assertEquals(project1.hashCode(), project2.hashCode());

        project2.setProjectName("Fyndr");

        assertFalse(project1.equals(project2));
    }
}
