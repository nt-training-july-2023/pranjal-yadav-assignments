package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.model.Project;
import com.employee.employeeManagement.constants.ErrorConstants;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * This class provides validation checks related to projects.
 */
@Component
public class ProjectValidation {
    /**
     * Project repository Autowired.
     */
    @Autowired
    private ProjectRepository projectRepository;
    /**
     * Checks if a project with the given name already exists.
     *
     * @param name The name of the project to check.
     * @throws ResourceAlreadyExistsException If a
     * project with the same name already exists.
     */
    public final void checkName(final String name) {
        Optional<Project> optionalProject =
                projectRepository.findByProjectName(name);
        if (!optionalProject.isPresent()) {
            return;
        } else {
            throw new ResourceAlreadyExistsException(
                    ErrorConstants.PROJECT_NAME);
        }
    }
}
