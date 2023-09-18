package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.dto.ProjectDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProjectDtoTest {
    private ProjectDto projectDto;

    @BeforeEach
    public void setUp() {
        projectDto = new ProjectDto();
    }

    @Test
    public void testGettersAndSetters() {
        projectDto.setProjectId(1L);
        projectDto.setProjectName("Petsmart");
        projectDto.setManagerId(2L);
        projectDto.setDescription("Description for Petsmart");
        projectDto.setStartDate("9-09-2023");
        List<String> skills = Arrays.asList("Java", "Spring", "SQL");
        projectDto.setSkills(skills);

        assertEquals(1L, projectDto.getProjectId());
        assertEquals("Petsmart", projectDto.getProjectName());
        assertEquals(2L, projectDto.getManagerId());
        assertEquals("Description for Petsmart", projectDto.getDescription());
        assertEquals("9-09-2023", projectDto.getStartDate());
        assertEquals(skills, projectDto.getSkills());
    }
}
