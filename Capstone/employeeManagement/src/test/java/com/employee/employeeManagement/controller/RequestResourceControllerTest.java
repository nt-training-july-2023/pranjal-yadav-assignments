package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.RequestResourceDto;
import com.employee.employeeManagement.dto.RequestResourceOutDto;
import com.employee.employeeManagement.response.ResponseDto;
import com.employee.employeeManagement.service.RequestResourceService;
import com.employee.employeeManagement.validation.RequestResourceValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(RequestResourceController.class)
public class RequestResourceControllerTest {
    @Autowired
    MockMvc mockMvc;
    @InjectMocks
    RequestResourceController requestResourceController;
    @MockBean
    RequestResourceService requestResourceService;
    @MockBean
    RequestResourceValidation requestResourceValidation;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testAddRequest() throws Exception{
        RequestResourceDto requestResourceDto = new RequestResourceDto();
        requestResourceDto.setComment("This employee will be a good fit");
        requestResourceDto.setEmployeeId(3L);
        requestResourceDto.setManagerId(7L);
        requestResourceDto.setProjectId(2L);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(requestResourceDto);
        ResponseDto responseDto = new ResponseDto("Resource added.");
        doNothing().when(requestResourceValidation).checkRequest(requestResourceDto);
        when(requestResourceService.requestResource(Mockito.any())).thenReturn(responseDto);
        MvcResult mvcResult =
                mockMvc.perform(post("/user/request/resource").contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testGetAllRequests() throws Exception {
        List<RequestResourceOutDto> reqOutList = new ArrayList<>();
        RequestResourceOutDto reqDto = new RequestResourceOutDto();
        reqDto.setResourceId(1L);
        reqDto.setEmployeeName("Vanshika Sharma");
        reqDto.setManagerName("Pranjal Yadav");
        reqDto.setProjectName("NuoData");
        reqDto.setComment("Vanshika will be a good fit");
        reqDto.setManagerId(6L);
        reqOutList.add(reqDto);
        when(requestResourceService.getAllRequests()).thenReturn(reqOutList);

        MvcResult mvcResult = this.mockMvc.perform(get("/user/all/request")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testDeleteRequest() throws Exception{
        RequestResourceDto request = new RequestResourceDto();
        request.setEmployeeId(1l);
        request.setManagerId(1L);
        request.setProjectId(1l);
        request.setComment("Comments");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(request);
        ResponseDto response = new ResponseDto("Deleted successfully!");
        when(requestResourceService.deleteRequest(Mockito.any())).thenReturn(response);

        MvcResult mvcResult = this.mockMvc.perform(delete("/user/request" +
                        "/delete/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testAcceptRequest() throws  Exception{
        RequestResourceDto request = new RequestResourceDto();

        request.setEmployeeId(1l);
        request.setManagerId(1L);
        request.setProjectId(1l);
        request.setComment("Comments");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(request);
        ResponseDto response = new ResponseDto("Accepted");
        when(requestResourceService.acceptRequest(Mockito.any())).thenReturn(response);

        MvcResult mvcResult = mockMvc.perform(post("/user/accept/8")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testIsRequested() throws Exception{

        RequestResourceDto request = new RequestResourceDto();

        request.setEmployeeId(1l);
        request.setManagerId(1L);
        request.setProjectId(1l);
        request.setComment("Comments");

        boolean result=true;
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(request);
        when(requestResourceService.isRequested(request.getEmployeeId(),request.getManagerId())).thenReturn(result);


        MvcResult mvcResult = this.mockMvc.perform(get("/user/employee" +
                        "/isRequested")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("empId", "1")
                        .param("managerId", "2"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }
}
