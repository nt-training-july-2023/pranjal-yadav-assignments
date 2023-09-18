package com.employee.employeeManagement.Model;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        // Create a list of skills
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Spring");
        skills.add("Hibernate");

        project.setSkills(skills);

        // Check if the skills list is the same
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
}
