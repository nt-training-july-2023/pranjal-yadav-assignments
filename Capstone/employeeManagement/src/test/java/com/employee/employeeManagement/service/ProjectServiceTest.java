package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.dto.ProjectDto;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.ManagerDto;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ProjectApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {

    @InjectMocks
    private ProjectService projectService;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetManagers() {
        // Create a list of mock managers
        List<User> mockManagers = new ArrayList<>();
        User manager1 = new User();
        manager1.setName("Manager 1");
        manager1.setUserId("manager1");
        manager1.setId(1L);
        mockManagers.add(manager1);

        // Mock the userRepository.findByRole method
        when(userRepository.findByRole(Role.MANAGER)).thenReturn(mockManagers);

        List<ManagerDto> managerList = projectService.getManagers();

        // Assert that the list is not empty
        assertFalse(managerList.isEmpty());

        // Assert that the first manager in the list has the expected properties
        ManagerDto firstManager = managerList.get(0);
        assertEquals("Manager 1", firstManager.getName());
        assertEquals("manager1", firstManager.getUserId());
        assertEquals(1L, firstManager.getId());

        // Verify that findByRole was called once
        verify(userRepository, times(1)).findByRole(Role.MANAGER);
    }

    @Test
    public void testGetProjectByManagerId() {
        long managerId = 1L;
        List<Project> mockProjects = new ArrayList<>();
        Project project1 = new Project();
        project1.setProjectId(101L);
        project1.setProjectName("Project A");
        project1.setManagerId(managerId);
        project1.setDescription("Description A");
        List<String> expectedSkills = new ArrayList<>();
        expectedSkills.add("Java");
        expectedSkills.add("Spring");
        project1.setSkills(expectedSkills);
        mockProjects.add(project1);

        // Mock the projectRepository.findAllByManagerId method
        when(projectRepository.findAllByManagerId(managerId)).thenReturn(mockProjects);

        List<Project> projectList = projectService.getProjectByManagerId(managerId);

        // Assert that the list is not empty
        assertFalse(projectList.isEmpty());

        // Assert that the first project in the list has the expected properties
        Project firstProject = projectList.get(0);
        assertEquals(101L, firstProject.getProjectId());
        assertEquals("Project A", firstProject.getProjectName());
        assertEquals(managerId, firstProject.getManagerId());
        assertEquals("Description A", firstProject.getDescription());

        // Assert that the skills property matches the expectedSkills list
        assertEquals(expectedSkills, firstProject.getSkills());

        // Verify that findAllByManagerId was called once
        verify(projectRepository, times(1)).findAllByManagerId(managerId);
    }

    @Test
    public void testGetProjectByManagerIdNotFound() {
        long managerId = 1L;

        // Mock the projectRepository.findAllByManagerId method to return an empty list
        when(projectRepository.findAllByManagerId(managerId)).thenReturn(new ArrayList<>());

        // Assert that calling getProjectByManagerId with an unknown managerId throws a ResourceAlreadyExistsException
        assertThrows(ResourceAlreadyExistsException.class, () -> projectService.getProjectByManagerId(managerId));

        // Verify that findAllByManagerId was called once
        verify(projectRepository, times(1)).findAllByManagerId(managerId);
    }

    @Test
    public void testDtoToProject() {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(101L);
        projectDto.setProjectName("Project A");
        projectDto.setManagerId(1L);
        projectDto.setDescription("Description A");
        List<String> expectedSkills = new ArrayList<>();
        expectedSkills.add("Java");
        expectedSkills.add("Spring");
        projectDto.setSkills(expectedSkills);

        Project project = projectService.dtoToProject(projectDto);

        // Assert that the project object has the expected properties
        assertEquals(101L, project.getProjectId());
        assertEquals("Project A", project.getProjectName());
        assertEquals(1L, project.getManagerId());
        assertEquals("Description A", project.getDescription());

        // Assert that the skills property matches the expectedSkills list
        assertEquals(expectedSkills, project.getSkills());
    }

}
