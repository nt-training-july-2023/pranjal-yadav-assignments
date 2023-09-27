//package com.employee.employeeManagement.controller;
//
//import com.employee.employeeManagement.dto.ManagerDto;
//import com.employee.employeeManagement.dto.ProjectInDto;
//import com.employee.employeeManagement.Model.Project;
//import com.employee.employeeManagement.repository.ProjectRepository;
//import com.employee.employeeManagement.response.ResponseDto;
//import com.employee.employeeManagement.service.ProjectService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class ProjectControllerTest {
//
//    @InjectMocks
//    private ProjectController projectController;
//
//    @Mock
//    private ProjectService projectService;
//
//    @Mock
//    private ProjectRepository projectRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testAddProject() {
//        ProjectInDto projectDto = new ProjectInDto();
//        projectDto.setProjectName("Test Project");
//        when(projectService.addProject(any(ProjectInDto.class))).thenReturn(projectDto);
//
//        ResponseDto response = projectController.addProject(projectDto);
//
//        assertEquals("Project added successfully", response.getMessage());
//    }
//
//    @Test
//    public void testAddProjectWithInvalidCredentials() {
//        ProjectInDto projectDto = new ProjectInDto();
//        when(projectService.addProject(any(ProjectInDto.class))).thenReturn(null);
//
//        ResponseDto response = projectController.addProject(projectDto);
//
//        assertEquals("Invalid credentials", response.getMessage());
//    }
//
//    @Test
//    public void testGetAllProject() {
//        List<Project> projectList = new ArrayList<>();
//        projectList.add(new Project());
//        projectList.add(new Project());
//        when(projectRepository.findAll()).thenReturn(projectList);
//
//        List<Project> result = projectController.getAllProject();
//
//        assertEquals(2, result.size());
//    }
//
//    @Test
//    public void testGetManagers() {
//        List<ManagerDto> managerList = new ArrayList<>();
//        managerList.add(new ManagerDto());
//        managerList.add(new ManagerDto());
//        when(projectService.getManagers()).thenReturn(managerList);
//
//        List<ManagerDto> result = projectController.getManager();
//
//        assertEquals(2, result.size());
//    }
//
////    @Test
////    public void testGetProjectByEmpId() {
////        long projectId = 1L;
////        Project project = new Project();
////        when(projectService.getProjectByManagerId(projectId)).thenReturn(Optional.of(project));
////
////        Optional<Project> result = projectController.getProjectByEmpId(projectId);
////
////        assertEquals(project, result.orElse(null));
////    }
//}
