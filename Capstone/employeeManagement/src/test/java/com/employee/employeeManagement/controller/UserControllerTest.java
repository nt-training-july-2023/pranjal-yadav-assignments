package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.Model.User;
import static org.mockito.Mockito.*;

import com.employee.employeeManagement.dto.UserInDto;
import org.springframework.test.web.servlet.MockMvc;
import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.dto.EmployeeOutDto;
import com.employee.employeeManagement.outDtos.UserNameDto;
import com.employee.employeeManagement.response.ResponseDto;
import com.employee.employeeManagement.service.UserService;
import com.employee.employeeManagement.validation.UserValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserValidation userValidation;
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @Test
    public void testSaveAdmin() {
        UserInDto userDto = new UserInDto();
        userDto.setName("Ankita Sharma");
        userDto.setEmail("ankita.sharma@nucleusteq.com");
        userDto.setUserId("N1000");
        userDto.setDob("17-08-1995");
        userDto.setDoj("17-07-2023");
        userDto.setContactNo(9876543210L);
        userDto.setDesignation(Designation.RECRUITER);
        userDto.setRole(Role.ADMIN);
        userDto.setLocation(Location.BANGALORE);
        when(userService.addUser(userDto)).thenReturn(new ResponseDto("User added successfully"));

        ResponseDto response = userController.saveAdmin(userDto);

        assertEquals("User added successfully", response.getMessage());
    }
//    @Test
//    public void testSaveAdminValidInput() throws Exception {
//        // Create a sample UserInDto
//        UserInDto userDto = new UserInDto();
//        userDto.setName("Ankita Sharma");
//        userDto.setEmail("ankita@nucleusteq.com");
//        userDto.setUserId("ankita23");
//        userDto.setContactNo(9876543210L);
//        List<String> skills = new ArrayList<>();
//        skills.add("Java");
//        skills.add("React");
//        userDto.setSkills(skills);
//
//        // Mock the behavior of userValidation and userService
//        doNothing().when(userValidation).checkUser(userDto);
//        when(userService.addUser(userDto)).thenReturn(new ResponseDto("User added successfully"));
//
//        // Perform a POST request to /save with valid input
//        mockMvc.perform(post("/save")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(userDto)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.message").value("User added successfully"));
//
//        // Verify that userValidation.checkUser and userService.addUser were called
//        verify(userValidation, times(1)).checkUser(userDto);
//        verify(userService, times(1)).addUser(userDto);
//    }

    @Test
    public void testSaveAdminWrong() {
        UserInDto userDto = new UserInDto();
        userDto.setName("Ankita Sharma");
        userDto.setEmail("ankita.sharma@nucleusteq.com");
        userDto.setUserId("N1000");
        Mockito.doNothing().when(userValidation).checkUser(userDto);
        when(userService.addUser(userDto)).thenThrow(new ResourceAlreadyExistsException("User creation " +
                "failed"));
         ResourceAlreadyExistsException exception=
                 assertThrows(ResourceAlreadyExistsException.class, () -> {
            userController.saveAdmin(userDto);
        });
        assertEquals("User creation failed", exception.getMessage());
    }
//    @Test
//    public void testLoginUser(){
//        LoginDto loginDto = new LoginDto();
//        loginDto.setEmail("ankita.sharma@nuceusteq.com");
//        loginDto.setPassword("Ankita@123");
//        doNothing().when(userValidation).checkLoginDto(loginDto);
//        ResponseDto expectedResponse = new ResponseDto("Login successful");
//        when(userService.login(loginDto)).thenReturn(expectedResponse);
//    }
//@Test
//public void testLoginUser() throws Exception {
//    // Create a sample LoginDto
//    LoginDto loginDto = new LoginDto();
//    loginDto.setEmail("test@nucleusteq.com");
//    loginDto.setPassword("testPassword");
//
//    // Mock the behavior of userValidation
//    doNothing().when(userValidation).checkLoginDto(loginDto);
//
//    // Mock the behavior of userService
//    ResponseDto expectedResponse = new ResponseDto("Login successful");
//    when(userService.login(loginDto)).thenReturn(expectedResponse);
//
//    // Perform the HTTP request and verify the response
//    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//                    .post("/login")
//                    .content("{\"username\":\"testUser\",\"password\":\"testPassword\"}")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andReturn();
//
//    // Verify that the response matches the expected response
//    String content = result.getResponse().getContentAsString();
//    ResponseDto actualResponse = new ObjectMapper().readValue(content,
//            ResponseDto.class);
//    assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
//
//    // Verify that userValidation's checkLoginDto method was called once
//    verify(userValidation, times(1)).checkLoginDto(loginDto);
//
//    // Verify that userService's login method was called once
//    verify(userService, times(1)).login(loginDto);
//}
    @Test
    public void testSaveEmp(){
        UserInDto userDto = new UserInDto();
        userDto.setName("Rashmi Shukla");
        userDto.setEmail("rashmi@nucleusteq.com");
        userDto.setUserId("N1001");
        userDto.setDob("17-08-2001");
        userDto.setDoj("17-07-2023");
        userDto.setContactNo(9876543210L);
        userDto.setDesignation(Designation.ENGINEER);
        userDto.setRole(Role.EMPLOYEE);
        userDto.setLocation(Location.RAIPUR);
        when(userService.addUser(userDto)).thenReturn(new ResponseDto("User added successfully"));

        ResponseDto response = userController.saveAdmin(userDto);

        assertEquals("User added successfully", response.getMessage());
    }
    @Test
    public void testGetEmployeesByRole(){
        List<EmployeeOutDto> emp = new ArrayList<>();
        Role role = Role.valueOf("EMPLOYEE");
        when(userService.allUserByRole(role.name())).thenReturn(emp);
        List<EmployeeOutDto> response =
                userController.getEmployeesByRole(role.name());
        assertEquals(emp, response);
    }
    @Test
    public void testGetAllUsers(){
        User emp= new User();
        List<EmployeeOutDto> empOutList = new ArrayList<EmployeeOutDto>();
        EmployeeOutDto e1= new EmployeeOutDto();
        e1.setEmail("abc@nucleusteq.com");
        e1.setName("Vanshika Sharmna");
        e1.setUserId("N1111");
        empOutList.add(e1);
        when(userService.getAllUsers()).thenReturn(empOutList);
        List<EmployeeOutDto> resp=userController.getAllUsers();
        assertEquals(empOutList,resp);
        assertEquals(1, resp.size());
    }
    @Test
    public void testGetEmployeeByUSerId(){
        String userId = "N1234";
        UserNameDto expectedUserNameDto = new UserNameDto();
        expectedUserNameDto.setName("Anjali Sharma");
        when(userService.getEmployeeNameById(userId)).thenReturn(expectedUserNameDto);
        UserNameDto actualUserNameDto = userController.getEmployeeNameById(userId);
        assertEquals(expectedUserNameDto.getName(), actualUserNameDto.getName());
    }
}

