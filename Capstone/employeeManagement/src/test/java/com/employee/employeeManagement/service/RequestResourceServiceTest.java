package com.employee.employeeManagement.service;

import com.employee.employeeManagement.dto.RequestResourceDto;
import com.employee.employeeManagement.dto.RequestResourceOutDto;
import com.employee.employeeManagement.model.Project;
import com.employee.employeeManagement.model.RequestResource;
import com.employee.employeeManagement.model.User;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.RequestResourceRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RequestResourceServiceTest {
    @InjectMocks
    private RequestResourceService requestResourceService;
    @Mock
    private RequestResourceRepository requestResourceRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testRequestResource() {
        MockitoAnnotations.initMocks(this);

        RequestResourceDto requestResourceDto = new RequestResourceDto();
        requestResourceDto.setProjectId(2L);
        requestResourceDto.setEmployeeId(3L);
        requestResourceDto.setManagerId(4L);
        requestResourceDto.setComment("Comment");

        RequestResource requestResource = new RequestResource();
        requestResource.setProjectId(2L);
        requestResource.setEmployeeId(3L);
        requestResource.setManagerId(4L);
        requestResource.setComment("Comment");
        when(requestResourceRepository.save(any(RequestResource.class))).thenReturn(requestResource);

        User employee = new User();
        employee.setName("Pranjal");
        employee.setUserId("N1111");
        employee.setManagerId(4L);
        employee.setEmail("pranjal@nucleusteq.com");
        employee.setContactNo(9876043221L);
        when(userRepository.findById(any())).thenReturn(Optional.of(employee));

        User manager = new User();
        manager.setName("Rashmi Shukla");
        manager.setUserId("N2121");
        manager.setEmail("rashmi@nucleusteq.com");
        manager.setContactNo(8839069226L);
        when(userRepository.findById(any())).thenReturn(Optional.of(manager));

        Project project = new Project();
        project.setProjectName("PetSmart");
        project.setManagerId(4l);
        project.setDescription("Description");
        project.setStartDate("5-10-2023");

        when(projectRepository.findById(any())).thenReturn(Optional.of(project));

        ResponseDto responseDto =
                requestResourceService.requestResource(requestResourceDto);

        verify(requestResourceRepository, times(1)).save(any(RequestResource.class));


        assertEquals("Resource added.", responseDto.getMessage());
    }
    @Test
    public void testGetAllRequests() {
        List<RequestResource> requestResourceList = new ArrayList<>();

        when(requestResourceRepository.findAll()).thenReturn(requestResourceList);


        List<RequestResourceOutDto> resultList = requestResourceService.getAllRequests();

        verify(requestResourceRepository, times(1)).findAll();
        assertTrue(resultList.isEmpty());

    }
    @Test
    public void testDeleteRequest() {
        Long resourceId = 1L;

        doNothing().when(requestResourceRepository).deleteById(resourceId);
        ResponseDto responseDto = requestResourceService.deleteRequest(resourceId);
        verify(requestResourceRepository, times(1)).deleteById(resourceId);
        assertEquals("Deleted successfully!", responseDto.getMessage());
    }
    @Test
    public void testAcceptRequest() {
        Long requestId = 1L;

        RequestResource requestResource = new RequestResource();
        requestResource.setEmployeeId(2L);
        requestResource.setManagerId(3L);
        requestResource.setProjectId(4L);
        when(requestResourceRepository.findById(requestId)).thenReturn(Optional.of(requestResource));

        User employee = new User();
        employee.setId(2L);
        when(userRepository.findById(requestResource.getEmployeeId())).thenReturn(Optional.of(employee));


        List<RequestResource> employeeRequests = new ArrayList<>();
        when(requestResourceRepository.findByEmployeeId(employee.getId())).thenReturn(employeeRequests);

        ResponseDto responseDto = requestResourceService.acceptRequest(requestId);

        verify(requestResourceRepository, times(1)).findById(requestId);
        verify(userRepository, times(1)).findById(requestResource.getEmployeeId());

    }

    @Test
    public void testIsRequestedWhenRequestExists() {
        Long empId = 1L;
        Long managerId = 2L;

        RequestResource requestResource = new RequestResource();
        when(requestResourceRepository.findByEmployeeIdAndManagerId(empId, managerId)).thenReturn(Optional.of(requestResource));

        boolean result = requestResourceService.isRequested(empId, managerId);

        verify(requestResourceRepository, times(1)).findByEmployeeIdAndManagerId(empId, managerId);

        assertTrue(result);
    }
    @Test
    public void testIsRequestedWhenRequestDoesNotExist() {
        Long empId = 1L;
        Long managerId = 2L;

        when(requestResourceRepository.findByEmployeeIdAndManagerId(empId, managerId)).thenReturn(Optional.empty());

        boolean result = requestResourceService.isRequested(empId, managerId);

        verify(requestResourceRepository, times(1)).findByEmployeeIdAndManagerId(empId, managerId);

        assertFalse(result);
    }

    @Test
    public void testDtoToRequestResource() {
        RequestResourceDto requestResourceDto = new RequestResourceDto();
        requestResourceDto.setComment("Test Comment");
        requestResourceDto.setManagerId(1L);
        requestResourceDto.setEmployeeId(2L);
        requestResourceDto.setProjectId(3L);

        RequestResource requestResource = requestResourceService.dtoToRequestResource(requestResourceDto);

        assertEquals(requestResourceDto.getComment(), requestResource.getComment());
        assertEquals(requestResourceDto.getManagerId(), requestResource.getManagerId());
        assertEquals(requestResourceDto.getEmployeeId(), requestResource.getEmployeeId());
        assertEquals(requestResourceDto.getProjectId(), requestResource.getProjectId());
    }
    @Test
    public void testRequestToOutDto() {
        RequestResource requestResource = new RequestResource();
        requestResource.setResourceId(1L);
        requestResource.setComment("Test Comment");
        requestResource.setEmployeeId(2L);
        requestResource.setManagerId(3L);
        requestResource.setProjectId(4L);

        User user = new User();
        user.setName("Pranjal Yadav");
        user.setUserId("N1122");
        user.setEmail("pranjal@nucleusteq.com");
        when(userRepository.findById(2L)).thenReturn(Optional.of(user));

        User manager = new User();
        manager.setName("Rashmi Shukla");
        manager.setUserId("N2121");
        manager.setEmail("rashmi@nucleusteq.com");
        when(userRepository.findById(3L)).thenReturn(Optional.of(manager));

        Project project = new Project();
        project.setProjectName("NuoData");
        when(projectRepository.findById(4L)).thenReturn(Optional.of(project));

        RequestResourceOutDto requestResourceOutDto = requestResourceService.requestToOutDto(requestResource);

        assertEquals(1L, requestResourceOutDto.getResourceId());
        assertEquals("Test Comment", requestResourceOutDto.getComment());
        assertEquals(2L, requestResourceOutDto.getEmployeeId());
        assertEquals(3L, requestResourceOutDto.getManagerId());
        assertEquals(4L, requestResourceOutDto.getProjectId());
        assertEquals("Pranjal Yadav", requestResourceOutDto.getEmployeeName());
        assertEquals("N1122", requestResourceOutDto.getEmployeeUserId());
        assertEquals("Rashmi Shukla", requestResourceOutDto.getManagerName());
        assertEquals("N2121", requestResourceOutDto.getManagerUserId());
        assertEquals("NuoData", requestResourceOutDto.getProjectName());
    }
}








