package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.ManagerDto;
import com.employee.employeeManagement.dto.ManagerOutDto;
import com.employee.employeeManagement.dto.ProjectInDto;
import com.employee.employeeManagement.dto.ProjectOutDto;
import com.employee.employeeManagement.response.ProjectResponseDto;
import com.employee.employeeManagement.response.ResponseDto;
import com.employee.employeeManagement.service.ProjectService;
import com.employee.employeeManagement.validation.ProjectValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@WebMvcTest(ProjectController.class)
class ProjectControllerTest{
    @InjectMocks
    private ProjectController projectController;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProjectService projectService;
    @MockBean
    ProjectValidation validation;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    List<String> skills = new ArrayList<>();
    @Test
    void testAddProject() throws Exception {
        skills.add("SQL");
        skills.add("Java");
        ProjectInDto project = new ProjectInDto();
        project.setProjectName("Petsmart");
        project.setSkills(skills);
        project.setDescription("Description of project");
        project.setStartDate("20-09-2023");
        project.setManagerId(3L);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(project);
        ProjectResponseDto response = new ProjectResponseDto("Project added " +
                "successfully!");
        doNothing().when(validation).checkName(project.getProjectName());
        when(projectService.addProject(Mockito.any())).thenReturn(response);
        MvcResult mvcResult =
                mockMvc.perform(post("/project/addProject").contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testGetAllProjects() throws Exception {
        List<ProjectOutDto> list = new ArrayList<>();
        List<String> teams = new ArrayList<>();
        ProjectOutDto prjDto = new ProjectOutDto();
        prjDto.setProjectName("AAA");
        prjDto.setManagerId(1L);
        prjDto.setStartDate("2023-06-07");
        prjDto.setSkills(skills);
        prjDto.setDescription("Description");
        prjDto.setManagerName("Pranjal Yadav");
        prjDto.setProjectId(0L);
        prjDto.setTeam(teams);
        list.add(prjDto);


        when(projectService.getAllProjects()).thenReturn(list);

        MvcResult mvcResult = this.mockMvc.perform(get("/project" +
                        "/getAllProjects")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testGetManager() throws Exception {
        List<ManagerDto> list = new ArrayList<>();
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(2L);
        managerDto.setName("Rashmi Shukla");
        list.add(managerDto);
        when(projectService.getManagers()).thenReturn(list);
        MvcResult mvcResult =
                mockMvc.perform(get("/project/getManagers").contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testGetProjectByManagerId() throws Exception{
        List<ProjectOutDto> list = new ArrayList<>();
        List<String> teams = new ArrayList<>();
        ProjectOutDto prjDto = new ProjectOutDto();
        prjDto.setProjectName("Fynder");
        prjDto.setManagerId(1L);
        prjDto.setStartDate("2023-06-07");
        prjDto.setSkills(skills);
        prjDto.setDescription("Description");
        prjDto.setManagerName("Ankita Sharma");
        prjDto.setProjectId(null);
        prjDto.setTeam(teams);
        list.add(prjDto);


        when(projectService.getProjectByManagerId(prjDto.getManagerId())).thenReturn(list);
        MvcResult mvcResult = this.mockMvc.perform(get("/project/project/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }
}
