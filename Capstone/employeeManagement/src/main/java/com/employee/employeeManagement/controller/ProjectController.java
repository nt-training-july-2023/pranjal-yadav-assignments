package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.ProjectOutDto;
import com.employee.employeeManagement.dto.ManagerDto;
import com.employee.employeeManagement.dto.ProjectInDto;
import com.employee.employeeManagement.response.ProjectResponseDto;
import com.employee.employeeManagement.service.ProjectService;
import com.employee.employeeManagement.validation.ProjectValidation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Controller class for managing project.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/project")
public class ProjectController {
    /**
     * Service for managing project operations.
     */
    @Autowired
    private ProjectService projectService;
    /**
     * Project validation for checking the user.
     */
    @Autowired
    private ProjectValidation projectValidation;
    /**
     * Logger for project controller.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserController.class);
    /**
     * Endpoint for adding a new project.
     *
     * @param projectDto The project details to be added.
     * @return ResponseDto indicating the status of the operation.
     */
    @PostMapping("/addProject")
    public final ProjectResponseDto addProject(
            @RequestBody @Valid final ProjectInDto projectDto) {
        LOGGER.info("Adding project");
        projectValidation.checkName(projectDto.getProjectName());
        LOGGER.info("Project Dto: " + projectDto.toString());
        ProjectResponseDto projectResponseDto =
                projectService.addProject(projectDto);
       return projectResponseDto;
    }
    /**
     * Endpoint for retrieving all projects.
     *
     * @return List of Project representing all projects.
     */
    @GetMapping("/getAllProjects")
    public final List<ProjectOutDto> getAllProject() {
        LOGGER.info("Getting all projects");
        List<ProjectOutDto> list = projectService.getAllProjects();
        return list;
    }
    /**
     * Endpoint for retrieving all managers as ManagerDto objects.
     *
     * @return List of ManagerDto objects representing all managers.
     */
    @GetMapping("/getManagers")
    public final List<ManagerDto> getManager() {
        LOGGER.info("Getting list of managers");
        List<ManagerDto> allManagers = projectService.getManagers();
        return allManagers;
    }

    /**
     * Endpoint for retrieving project from project id.
     * @param managerId .
     * @return Project object from given project id.
     */
    @GetMapping("/project/{managerId}")
    public final List<ProjectOutDto> getProjectByManagerId(
            @PathVariable final Long managerId) {
        LOGGER.info("Project by manager id" + managerId);
        List<ProjectOutDto> list =
                projectService.getProjectByManagerId(managerId);
        return list;
    }
}
