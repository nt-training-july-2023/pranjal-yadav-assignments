package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.model.Project;
import com.employee.employeeManagement.model.RequestResource;
import com.employee.employeeManagement.model.User;
import com.employee.employeeManagement.dto.RequestResourceDto;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.exception.ValidationException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.RequestResourceRepository;
import com.employee.employeeManagement.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class RequestResourceValidationTest {
    @InjectMocks
    private RequestResourceValidation requestResourceValidation;

    @Mock
    private RequestResourceRepository requestResourceRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCheckRequest_ResourceNotFound_User() {
        RequestResourceDto requestResourceDto = new RequestResourceDto();
        requestResourceDto.setEmployeeId(1L);
        requestResourceDto.setManagerId(2L);
        requestResourceDto.setProjectId(3L);

        when(userRepository.findById(1L)).thenThrow(new ResourceNotFoundException("This employee does not exist"));
        assertThrows(ResourceNotFoundException.class, () -> requestResourceValidation.checkRequest(requestResourceDto));
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testCheckResourceIdAccept_AlreadyAssigned() {
        long resourceId = 1L;

        RequestResource requestResource = new RequestResource();
        requestResource.setEmployeeId(1L);

        when(requestResourceRepository.findById(resourceId)).thenReturn(java.util.Optional.of(requestResource));

        User user = new User();
        user.setProjectId(2L);
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        assertThrows(ValidationException.class, () -> requestResourceValidation.checkResourceIdAccept(resourceId));

        verify(userRepository, times(1)).findById(1L);
    }
    @Test
    public void testCheckRequest_ValidRequest() {
        RequestResourceDto validRequestDto = new RequestResourceDto();
        validRequestDto.setEmployeeId(1L);
        validRequestDto.setManagerId(2L);
        validRequestDto.setProjectId(3L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(new User()));
        when(userRepository.findById(2L)).thenReturn(Optional.of(new User()));
        when(projectRepository.findByProjectId(3L)).thenReturn(Optional.of(new Project()));

        requestResourceValidation.checkRequest(validRequestDto);

        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).findById(2L);
        verify(projectRepository, times(1)).findByProjectId(3L);
    }
    @Test
    public void testCheckIsRequested_ValidEmployeeAndManager() {
        User validEmployee = new User();
        validEmployee.setId(1L);
        validEmployee.setRole(Role.EMPLOYEE);

        User validManager = new User();
        validManager.setId(2L);
        validManager.setRole(Role.MANAGER);

        when(userRepository.findById(1L)).thenReturn(Optional.of(validEmployee));
        when(userRepository.findById(2L)).thenReturn(Optional.of(validManager));

        requestResourceValidation.checkIsRequested(1L, 2L);

        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).findById(2L);
    }
    @Test
    public void testCheckDeleteResourceNotFound() {
        Long resourceId = 1L;
        Mockito.when(requestResourceRepository.findById(resourceId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            requestResourceValidation.checkDelete(resourceId);
        });
    }
}
