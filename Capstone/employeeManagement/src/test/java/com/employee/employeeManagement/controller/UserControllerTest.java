package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.outDtos.EmployeeOutDto;
import com.employee.employeeManagement.outDtos.UserNameDto;
import com.employee.employeeManagement.response.ApiResponse;
import com.employee.employeeManagement.service.UserService;
import com.employee.employeeManagement.validation.UserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserValidation userValidation;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testSaveAdmin() {
        UserDto userDto = new UserDto();
        userDto.setName("Ankita Sharma");
        userDto.setEmail("ankita.sharma@nucleusteq.com");
        userDto.setUserId("N1000");
        userDto.setDob("17-08-1995");
        userDto.setDoj("17-07-2023");
        userDto.setContactNo(9876543210L);
        userDto.setDesignation(Designation.RECRUITER);
        userDto.setRole(Role.ADMIN);
        userDto.setLocation(Location.BANGALORE);
        when(userService.addUser(userDto)).thenReturn(new ApiResponse("User added successfully"));

        ApiResponse response = userController.saveAdmin(userDto);

        assertEquals("User added successfully", response.getMessage());
    }

    @Test
    public void testSaveAdminWrong() {
        UserDto userDto = new UserDto();
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
    @Test
    public void testLoginUser(){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("ankita.sharma@nuceusteq.com");
        loginDto.setPassword("Ankita@123");
        doNothing().when(userValidation).checkLoginDto(loginDto);
        ApiResponse expectedResponse = new ApiResponse("Login successful");
        when(userService.login(loginDto)).thenReturn(expectedResponse);
    }
    @Test
    public void testSaveEmp(){
        UserDto userDto = new UserDto();
        userDto.setName("Rashmi Shukla");
        userDto.setEmail("rashmi@nucleusteq.com");
        userDto.setUserId("N1001");
        userDto.setDob("17-08-2001");
        userDto.setDoj("17-07-2023");
        userDto.setContactNo(9876543210L);
        userDto.setDesignation(Designation.ENGINEER);
        userDto.setRole(Role.EMPLOYEE);
        userDto.setLocation(Location.RAIPUR);
        when(userService.addUser(userDto)).thenReturn(new ApiResponse("User added successfully"));

        ApiResponse response = userController.saveAdmin(userDto);

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

