package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.dto.ProjectOutDto;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.ManagerDto;
import com.employee.employeeManagement.dto.ProjectInDto;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ProjectResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing project-related operations.
 */
@Service
public class ProjectService {
    /**
     * ProjectRepository autowired for adding and retrieving from database.
     */
    @Autowired
    private ProjectRepository projectRepository;
    /**
     * UserRepository autowired for adding to database.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * Adds a new project.
     *
     * @param projectDto The project details to be added.
     * @return Response indicating successfully adding user.
     */
    public final ProjectResponseDto addProject(final ProjectInDto projectDto) {
        Project project = dtoToProject(projectDto);
        projectRepository.save(project);
        return new ProjectResponseDto("Project added successfully!");
    }

    /**
     * Getting all projects.
     * @return List of all projects.
     */
    public final List<ProjectOutDto> getAllProjects() {
        List<Project> allProjects = projectRepository.findAll();
        List<ProjectOutDto> returnedList = new ArrayList<>();
        for (Project project : allProjects) {
            ProjectOutDto projectOutDto = projectToOutDto(project);
            List<User> team = userRepository.findAllByProjectId(
                    project.getProjectId());
            List<String> teamName = new ArrayList<>();
            for (User currUser: team) {
                teamName.add(currUser.getName());
            }
            projectOutDto.setTeam(teamName);
            returnedList.add(projectOutDto);
        }
        return returnedList;
    }

    /**
     * Retrieves all managers as ManagerDto objects.
     *
     * @return List of ManagerDto objects representing all managers.
     */
    public final List<ManagerDto> getManagers() {
        Role role = Role.valueOf("MANAGER");
        List<User> allManagers = userRepository.findByRole(role);
        List<ManagerDto> returnedManagers = new ArrayList<>();
        for (User manager: allManagers) {
            ManagerDto currManager = new ManagerDto();
            currManager.setName(manager.getName());
            currManager.setUserId(manager.getUserId());
            currManager.setId(manager.getId());
            returnedManagers.add(currManager);
        }
        return returnedManagers;
    }

    /**
     * Method returning project form given id.
     * @param managerId .
     * @return Optional value project or exception.
     */
    public final List<ProjectOutDto> getProjectByManagerId(
            final long managerId) {
        List<Project> projectList =
                projectRepository.findAllByManagerId(managerId);
        if (!projectList.isEmpty()) {
            List<ProjectOutDto> listProjectOut = new ArrayList<>();
            for (Project currProject : projectList) {
                ProjectOutDto projectOutDto = projectToOutDto(currProject);
                List<User> team =
                        userRepository.findAllByProjectId(
                                currProject.getProjectId());
                List<String> teamName = new ArrayList<>();
                for (User currUser: team) {
                    teamName.add(currUser.getName());
                }
                projectOutDto.setTeam(teamName);
                listProjectOut.add(projectOutDto);
            }
            return listProjectOut;
        } else {
            throw new ResourceAlreadyExistsException("Project does not exist");
        }
    }

    /**
     * Converts a ProjectInDto object to a Project object.
     *
     * @param projectDto The ProjectInDto object to be converted.
     * @return A Project object created from the provided ProjectInDto.
     */
    public final Project dtoToProject(final ProjectInDto projectDto) {
        Project project = new Project();
        project.setProjectName(projectDto.getProjectName());
        project.setStartDate(projectDto.getStartDate());
        project.setManagerId(projectDto.getManagerId());
        project.setDescription(projectDto.getDescription());
        project.setSkills(projectDto.getSkills());
        return project;
    }

    /**
     *  Converts a Project object to a ProjectInDto object.
     * @param project The Project object to be converted.
     * @return A ProjectInDto object created from the provided Project.
     */
    public final ProjectOutDto projectToOutDto(final Project project) {
        ProjectOutDto projectOutDto = new ProjectOutDto();
        projectOutDto.setDescription(project.getDescription());
        projectOutDto.setProjectId(project.getProjectId());
        projectOutDto.setProjectName(project.getProjectName());
        projectOutDto.setSkills(project.getSkills());
        projectOutDto.setStartDate(project.getStartDate());
        projectOutDto.setManagerId(project.getManagerId());
        User user = userRepository.findById(project.getManagerId()).get();
        projectOutDto.setManagerName(user.getName());

        return projectOutDto;

    }
}
