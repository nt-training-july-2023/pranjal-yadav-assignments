package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.ProjectOutDto;
import com.employee.employeeManagement.dto.ManagerDto;
import com.employee.employeeManagement.dto.ProjectDto;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.response.ProjectApiResponse;
import com.employee.employeeManagement.service.ProjectService;
import com.employee.employeeManagement.validation.ProjectValidation;
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
     * Repository for accessing project data.
     */
    @Autowired
    private ProjectRepository projectRepository;
    /**
     * Project validation for checking the user.
     */
    @Autowired
    private ProjectValidation projectValidation;
    /**
     * Endpoint for adding a new project.
     *
     * @param projectDto The project details to be added.
     * @return ApiResponse indicating the status of the operation.
     */
    @PostMapping("/addProject")
    public final ProjectApiResponse addProject(
            @RequestBody final ProjectDto projectDto) {
        projectValidation.checkName(projectDto.getProjectName());
       return projectService.addProject(projectDto);
    }
    /**
     * Endpoint for retrieving all projects.
     *
     * @return List of Project representing all projects.
     */
    @GetMapping("/getAllProjects")
    public final List<ProjectOutDto> getAllProject() {
        return projectService.getAllProjects();
    }
    /**
     * Endpoint for retrieving all managers as ManagerDto objects.
     *
     * @return List of ManagerDto objects representing all managers.
     */
    @GetMapping("/getManagers")
    public final List<ManagerDto> getManager() {
        List<ManagerDto> allManagers = projectService.getManagers();
        return allManagers;
    }

    /**
     * Endpoint for retrieving project from project id.
     * @param managerId .
     * @return Project object from given project id.
     */
    @GetMapping("/project/{managerId}")
    public final List<Project> getProjectByManagerId(
            @PathVariable final long managerId) {
        return projectService.getProjectByManagerId(managerId);
    }
}
