package com.employee.employeeManagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.Model.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.controller.ProjectController;
import com.employee.employeeManagement.dto.ManagerDto;
import com.employee.employeeManagement.dto.ProjectDto;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

public class ProjectServiceTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectService projectService;

    @InjectMocks
    private ProjectController projectController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testAddProjectWithValidData() {
//        ProjectDto projectDto = new ProjectDto();
//        projectDto.setProjectName("Project A");
//
//        Project project =modelMapper.map(projectDto, Project.class);
//
//        when(projectRepository.save(project)).thenReturn(project);
//
//        // Act
//        ProjectDto result = projectService.addProject(projectDto);
//
//        // Assert
//        assertEquals(projectDto, result); // Check if the returned projectDto matches the input
//    }

    @Test
    public void testGetManagers() {
        // Arrange
        Role role = Role.MANAGER;
        List<User> allManagers = new ArrayList<>();
        // ... populate the allManagers list with test data

        when(userRepository.findByRole(role)).thenReturn(allManagers); // Mock the userRepository behavior

        // Act
        List<ManagerDto> result = projectService.getManagers();

        // Assert
        assertEquals(allManagers.size(), result.size()); // Check if the returned list matches the expected size
    }

//    @Test
//    public void testAddProjectEndpoint() {
//        // Arrange
//        ProjectDto projectDto = new ProjectDto();
//        projectDto.setProjectName("Project A");
//        // ... set other projectDto properties as needed
//
//        Project project = new Project();
//        when(modelMapper.map(projectDto, Project.class)).thenReturn(project); // Mock the modelMapper behavior
//        when(projectRepository.save(project)).thenReturn(project); // Mock the projectRepository behavior
//
//        // Act
//        ApiResponse response = projectController.addProject(projectDto);
//
//        // Assert
//        assertEquals("Project added successfully", response.getMessage()); // Check the response message
//    }
//
//    // Additional tests for other endpoints in ProjectController can be added similarly
}

