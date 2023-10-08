package com.employee.employeeManagement.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {


    @Test
    public void testGetAndSetProjectId() {
        Project project = new Project();
        Long projectId = 1L;
        project.setProjectId(projectId);
        assertEquals(projectId, project.getProjectId());
    }

    @Test
    public void testGetAndSetProjectName() {
        Project project = new Project();
        String projectName = "Sample Project";
        project.setProjectName(projectName);
        assertEquals(projectName, project.getProjectName());
    }

    @Test
    public void testGetAndSetManagerId() {
        Project project = new Project();
        Long managerId = 1001L;
        project.setManagerId(managerId);
        assertEquals(managerId, project.getManagerId());
    }

    @Test
    public void testGetAndSetDescription() {
        Project project = new Project();
        String description = "This is a sample project description.";
        project.setDescription(description);
        assertEquals(description, project.getDescription());
    }

    @Test
    public void testGetAndSetStartDate() {
        Project project = new Project();
        String startDate = "2023-09-18";
        project.setStartDate(startDate);
        assertEquals(startDate, project.getStartDate());
    }

    @Test
    public void testGetAndSetSkills() {
        Project project = new Project();
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Spring");
        skills.add("Hibernate");

        project.setSkills(skills);

        assertEquals(skills, project.getSkills());
    }

    @Test
    public void testToString() {
        Project project = new Project();
        project.setProjectId(1L);
        project.setProjectName("Sample Project");
        project.setManagerId(1001L);

        String expectedString = "Project{projectId=1, projectName='Sample Project', managerId=1001, description='null', startDate='null', skills=null}";
        assertEquals(expectedString, project.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        Project project1 = new Project();
        project1.setProjectId(1L);
        project1.setProjectName("Sample Project");
        project1.setManagerId(2L);
        project1.setDescription("Sample Description");
        project1.setStartDate("2023-01-01");
        project1.setSkills(Arrays.asList("Java", "Spring"));

        Project project2 = new Project();
        project2.setProjectId(1L);
        project2.setProjectName("Sample Project");
        project2.setManagerId(2L);
        project2.setDescription("Sample Description");
        project2.setStartDate("2023-01-01");
        project2.setSkills(Arrays.asList("Java", "Spring"));

        Project differentProject = new Project();
        differentProject.setProjectId(2L);
        differentProject.setProjectName("Different Project");
        differentProject.setManagerId(3L);
        differentProject.setDescription("Different Description");
        differentProject.setStartDate("2023-02-01");
        differentProject.setSkills(Arrays.asList("Python", "Django"));

        assertEquals(project1, project2);
        assertEquals(project1.hashCode(), project2.hashCode());

        assertNotEquals(project1, differentProject);
        assertNotEquals(project1.hashCode(), differentProject.hashCode());
    }
}
