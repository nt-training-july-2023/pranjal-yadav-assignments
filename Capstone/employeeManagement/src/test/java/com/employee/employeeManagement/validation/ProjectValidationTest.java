package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.model.Project;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProjectValidationTest {
    @InjectMocks
    private ProjectValidation projectValidation;

    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCheckNameProjectExists() {
        String projectName = "ProjectA";

        when(projectRepository.findByProjectName(projectName)).thenReturn(Optional.of(new Project()));

        ResourceAlreadyExistsException exception = assertThrows(ResourceAlreadyExistsException.class, () -> {
            projectValidation.checkName(projectName);
        });

        verify(projectRepository, times(1)).findByProjectName(projectName);

        assertEquals("This project name already exists", exception.getMessage());
    }

    @Test
    public void testCheckNameProjectDoesNotExist() {
        String projectName = "ProjectB";

        when(projectRepository.findByProjectName(projectName)).thenReturn(Optional.empty());

        projectValidation.checkName(projectName);

        verify(projectRepository, times(1)).findByProjectName(projectName);
    }
}
