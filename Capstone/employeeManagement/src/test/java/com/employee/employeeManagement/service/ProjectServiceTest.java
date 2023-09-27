package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.ManagerDto;
import com.employee.employeeManagement.dto.ProjectInDto;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.dto.ProjectOutDto;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ProjectResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {
    @InjectMocks
    private ProjectService projectService;

    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void testAddProject() {
        ProjectInDto projectDto = new ProjectInDto();
        projectDto.setProjectName("Test Project");
        List<String> skills= new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        projectDto.setSkills(skills);

        Project project = new Project();
        when(projectRepository.save(any(Project.class))).thenReturn(project);

        ProjectResponseDto response = projectService.addProject(projectDto);

        verify(projectRepository).save(any(Project.class));

        assertNotNull(response);
        assertEquals("Project added successfully!", response.getMessage());
    }
    @Test
    void testGetAllProjects() {
        // Create sample data for testing
        Project project1 = new Project();
        project1.setProjectId(1L);
        project1.setProjectName("Project 1");
        List<String> skills1= new ArrayList<>();
        skills1.add("Java");
        skills1.add("React");
        project1.setSkills(skills1);

        Project project2 = new Project();
        project2.setProjectId(2L);
        project2.setProjectName("Project 2");
        List<String> skills2= new ArrayList<>();
        skills2.add("Java");
        skills2.add("React");
        project2.setSkills(skills2);

        List<Project> allProjects = Arrays.asList(project1, project2);

        User user1 = new User();
        user1.setProjectId(1L);
        user1.setName("User 1");
        user1.setManagerId(3L);

        User user2 = new User();
        user2.setProjectId(1L);
        user2.setName("User 2");
        user2.setManagerId(3L);

        when(projectRepository.findAll()).thenReturn(allProjects);
        when(userRepository.findAllByProjectId(1L)).thenReturn(Arrays.asList(user1, user2));
        when(userRepository.findAllByProjectId(2L)).thenReturn(new ArrayList<>());
        when(userRepository.findById(project1.getManagerId())).thenReturn(Optional.of(user2));

        // Call the getAllProjects method
        List<ProjectOutDto> resultList = projectService.getAllProjects();

        // Verify the size of the resultList
        assertEquals(2, resultList.size());

        // Verify the content of the resultList
        ProjectOutDto projectOutDto1 = resultList.get(0);
        assertEquals("Project 1", projectOutDto1.getProjectName());
        assertEquals(2, projectOutDto1.getTeam().size());
        assertTrue(projectOutDto1.getTeam().contains("User 1"));
        assertTrue(projectOutDto1.getTeam().contains("User 2"));

        ProjectOutDto projectOutDto2 = resultList.get(1);
        assertEquals("Project 2", projectOutDto2.getProjectName());
        assertTrue(projectOutDto2.getTeam().isEmpty());

        // Verify that the repository methods were called with the expected arguments
        verify(projectRepository).findAll();
        verify(userRepository, times(2)).findAllByProjectId(anyLong());
    }
    @Test
    void testGetManagers() {

        User manager1 = new User();
        manager1.setUserId("N1001");
        manager1.setName("Manager 1");
        manager1.setId(101L);

        User manager2 = new User();
        manager2.setUserId("N1001");
        manager2.setName("Manager 2");
        manager2.setId(102L);

        List<User> allManagers = Arrays.asList(manager1, manager2);

        when(userRepository.findByRole(Role.MANAGER)).thenReturn(allManagers);

        List<ManagerDto> returnedManagers = projectService.getManagers();

        assertEquals(2, returnedManagers.size());

        ManagerDto managerDto1 = returnedManagers.get(0);
        assertEquals("Manager 1", managerDto1.getName());
        assertEquals("N1001", managerDto1.getUserId());
        assertEquals(101L, managerDto1.getId());

        ManagerDto managerDto2 = returnedManagers.get(1);
        assertEquals("Manager 2", managerDto2.getName());
        assertEquals("N1001", managerDto2.getUserId());
        assertEquals(102L, managerDto2.getId());

        verify(userRepository).findByRole(Role.MANAGER);
    }
    @Test
    void testDtoToProjectConversion() {
        ProjectInDto projectDto = new ProjectInDto();
        projectDto.setProjectName("Demo Project");
        projectDto.setStartDate("2023-09-30");
        projectDto.setManagerId(1L);
        projectDto.setDescription("Description of demo project");
        List<String> skills2= new ArrayList<>();
        skills2.add("Java");
        skills2.add("React");
        projectDto.setSkills(skills2);

        ProjectService projectService = new ProjectService();

        Project project = projectService.dtoToProject(projectDto);

        assertNotNull(project);
        assertEquals(projectDto.getProjectName(), project.getProjectName());
        assertEquals(projectDto.getStartDate(), project.getStartDate());
        assertEquals(projectDto.getManagerId(), project.getManagerId());
        assertEquals(projectDto.getDescription(), project.getDescription());
        assertEquals(projectDto.getSkills(), project.getSkills());
    }
    @Test
    void testProjectToOutDtoConversion() {
        Project project = new Project();
        project.setProjectId(1L);
        project.setProjectName("Test Project");
        List<String> skills2= new ArrayList<>();
        skills2.add("Java");
        skills2.add("React");
        project.setSkills(skills2);
        project.setStartDate("2023-09-30");
        project.setManagerId(1L);

        User user = new User();
        user.setId(1L);
        user.setName("Test Manager");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        ProjectOutDto projectOutDto = projectService.projectToOutDto(project);

        assertNotNull(projectOutDto);
        assertEquals(project.getProjectId(), projectOutDto.getProjectId());
        assertEquals(project.getProjectName(), projectOutDto.getProjectName());
        assertEquals(project.getSkills(), projectOutDto.getSkills());
        assertEquals(project.getStartDate(), projectOutDto.getStartDate());
        assertEquals(project.getManagerId(), projectOutDto.getManagerId());
        assertEquals(user.getName(), projectOutDto.getManagerName());
    }
}

