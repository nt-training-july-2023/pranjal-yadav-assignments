package com.employee.employeeManagement.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProjectOutDtoTest {
    @Test
    public void testToString() {
        ProjectOutDto project = new ProjectOutDto();
        project.setProjectId(1L);
        project.setProjectName("Sample Project");
        project.setManagerId(2L);
        project.setDescription("Sample Description");
        project.setStartDate("2023-01-01");
        project.setSkills(Arrays.asList("Java", "Spring"));
        project.setManagerName("John Doe");
        project.setTeam(Arrays.asList("Alice", "Bob"));

        String expectedToString = "ProjectOutDto{" +
                "projectId=1, " +
                "projectName='Sample Project', " +
                "managerId=2, " +
                "description='Sample Description', " +
                "startDate='2023-01-01', " +
                "skills=[Java, Spring], " +
                "managerName='John Doe', " +
                "team=[Alice, Bob]" +
                "}";

        assertEquals(expectedToString, project.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        ProjectOutDto project1 = new ProjectOutDto();
        project1.setProjectId(1L);
        project1.setProjectName("Sample Project");
        project1.setManagerId(2L);
        project1.setDescription("Sample Description");
        project1.setStartDate("2023-01-01");
        project1.setSkills(Arrays.asList("Java", "Spring"));
        project1.setManagerName("John Doe");
        project1.setTeam(Arrays.asList("Alice", "Bob"));

        ProjectOutDto project2 = new ProjectOutDto();
        project2.setProjectId(1L);
        project2.setProjectName("Sample Project");
        project2.setManagerId(2L);
        project2.setDescription("Sample Description");
        project2.setStartDate("2023-01-01");
        project2.setSkills(Arrays.asList("Java", "Spring"));
        project2.setManagerName("John Doe");
        project2.setTeam(Arrays.asList("Alice", "Bob"));

        ProjectOutDto differentProject = new ProjectOutDto();
        differentProject.setProjectId(2L); // Different project ID
        differentProject.setProjectName("Different Project");
        differentProject.setManagerId(3L);
        differentProject.setDescription("Different Description");
        differentProject.setStartDate("2023-02-01");
        differentProject.setSkills(Arrays.asList("Python", "Django"));
        differentProject.setManagerName("Jane Doe");
        differentProject.setTeam(Arrays.asList("Charlie", "David"));

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("react");
        UserInDto user = new UserInDto();
        user.setName("Pranjal");
        user.setSkills(skills);
        user.setUserId("N7281");
        user.setContactNo(9876543210L);

        assertEquals(project1, project2);
        assertEquals(project1.hashCode(), project2.hashCode());
        assertEquals(project1, project1);
        assertNotEquals(project1, user);

        assertNotEquals(project1, differentProject);
        assertNotEquals(project1.hashCode(), differentProject.hashCode());
    }
}
