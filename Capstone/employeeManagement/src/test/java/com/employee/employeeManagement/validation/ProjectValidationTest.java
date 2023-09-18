package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProjectValidationTest {
    private ProjectValidation projectValidation;

    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        projectValidation = new ProjectValidation();
        projectValidation.projectRepository = projectRepository;
    }

    @Test
    public void testCheckName_ProjectWithNameExists() {
        String projectName = "ExistingProject";
        Project existingProject = new Project();
        existingProject.setProjectName(projectName);

        when(projectRepository.findByProjectName(projectName)).thenReturn(Optional.of(existingProject));

        assertThrows(ResourceAlreadyExistsException.class, () -> projectValidation.checkName(projectName));

        verify(projectRepository, times(1)).findByProjectName(projectName);
    }

    @Test
    public void testCheckName_ProjectWithNameDoesNotExist() {
        String projectName = "NewProject";

        when(projectRepository.findByProjectName(projectName)).thenReturn(Optional.empty());

        projectValidation.checkName(projectName);

        verify(projectRepository, times(1)).findByProjectName(projectName);
    }
}
