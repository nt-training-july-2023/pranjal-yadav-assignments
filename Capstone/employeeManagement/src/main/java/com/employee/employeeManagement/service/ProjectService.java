package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.Model.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.ManagerDto;
import com.employee.employeeManagement.dto.ProjectDto;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing project-related operations.
 */
@Service
public class ProjectService {
    /**
     * ModelMapper autowired to map dto to entity and vice versa.
     */
    @Autowired
    private ModelMapper modelMapper;
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
     * @return The added project details.
     */
    public final ProjectDto addProject(final ProjectDto projectDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        Project project = this.modelMapper.map(projectDto, Project.class);
        projectRepository.save(project);
        return projectDto;
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
            returnedManagers.add(currManager);
        }
        return returnedManagers;
    }

    /**
     * Method returning project form given id.
     * @param projectID .
     * @return Optional value project or exception.
     */
    public final Optional<Project> getProjectByProjectID(final long projectID) {
        Optional<Project> project =
                projectRepository.findByProjectId(projectID);
        if (project.isPresent()) {
            return project;
        } else {
            throw new ResourceAlreadyExistsException("Project does not exist");
        }
//        Optional<Project> projectDetails = projectRepository
//                .findByProjectID(projectID);
//        Project project = projectDetails.orElseThrow(
//                () -> new ResourceNotFoundException(
//                "Project Id does not exist"));
//        return projectDetails;
    }

}
