package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.Model.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.ManagerDto;
import com.employee.employeeManagement.dto.ProjectDto;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {

    @InjectMocks
    private ProjectService projectService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void testAddProject() {
//        // Arrange
//        ProjectDto projectDto = new ProjectDto();
//        projectDto.setProjectName("Test Project");
//
//        Project project = new Project();
//        project.setProjectName("Test Project");
//
//        when(modelMapper.map(projectDto, Project.class)).thenReturn(project);
//        when(projectRepository.save(project)).thenReturn(project);
//
//        // Act
//        ProjectDto result = projectService.addProject(projectDto);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals("Test Project", result.getProjectName());
//    }

    @Test
    public void testGetManagers() {
        Role role = Role.MANAGER;
        User manager1 = new User();
        manager1.setName("Manager 1");
        User manager2 = new User();
        manager2.setName("Manager 2");
        List<User> managers = new ArrayList<>();
        managers.add(manager1);
        managers.add(manager2);

        when(userRepository.findByRole(role)).thenReturn(managers);

        List<ManagerDto> result = projectService.getManagers();

        assertEquals(2, result.size());
        assertEquals("Manager 1", result.get(0).getName());
        assertEquals("Manager 2", result.get(1).getName());
    }

//    @Test
//    public void testGetProjectByProjectID() {
//        // Arrange
//        long projectId = 1L;
//        Project project = new Project();
//        project.setProjectId(projectId);
//
//        when(projectRepository.findByProjectId(projectId)).thenReturn(Optional.of(project));
//
//        // Act
//        Optional<Project> result = projectService.getProjectByProjID(projectId);
//
//        // Assert
//        assertTrue(result.isPresent());
//        assertEquals(projectId, result.get().getProjectId());
//    }

//    @Test
//    public void testGetProjectByProjectIDNotFound() {
//        // Arrange
//        long id = 1L;
//
//        when(projectRepository.findByProjectIdd)).thenReturn(Optional.empty());
//
//        // Act and Assert
//        assertThrows(ResourceAlreadyExistsException.class, () -> {
//            projectService.getProjectByManagerID(projectId);
//        });
//    }
}
