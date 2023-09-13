package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.Model.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.exception.WrongCredentialsExceptions;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ApiResponse;
import com.employee.employeeManagement.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveAdmin() {
        UserDto userDto = new UserDto();
        userDto.setName("admin");
        userDto.setPassword("admin123");
        userDto.setRole(Role.ADMIN);

        when(userService.addUser(any(UserDto.class))).thenReturn(userDto);

        ApiResponse response = userController.saveAdmin(userDto);

        assertEquals("Admin added successfully", response.getMessage());
        assertEquals(Role.ADMIN, response.getRole());
    }

//    @Test
//    public void testSaveAdminWithInvalidCredentials() {
//        UserDto userDto = new UserDto();
//        userDto.setName("admin");
//        userDto.setPassword("invalid");
////        userDto.setRole(Role.ADMIN);
//
//        when(userService.addUser(any(UserDto.class))).thenReturn(null);
//
//        ApiResponse response = userController.saveAdmin(userDto);
//
//        assertEquals("Invalid credentials", response.getMessage());
////        assertEquals(Role.ADMIN, response.getRole());
//    }

    @Test
    public void testLoginUser() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("ankita,sharma@nucleusteq.com");
        loginDto.setPassword("user123");

        User user = new User();
        user.setName("user");
        user.setPassword("user123");
//        user.setRole(Role.EMPLOYEE);

        when(userService.login(loginDto)).thenReturn(user);

        ApiResponse response = userController.loginUser(loginDto);

        assertEquals("Login successful", response.getMessage());
//        assertEquals(Role.EMPLOYEE, response.getRole());
    }

    @Test
    public void testLoginUserWithWrongCredentials() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("user@nucleusteq.com");
        loginDto.setPassword("invalid");

        when(userService.login(loginDto)).thenReturn(null);

        assertThrows(WrongCredentialsExceptions.class, () -> {
            userController.loginUser(loginDto);
        });
    }

    @Test
    public void testSaveEmp() {
        UserDto userDto = new UserDto();
        userDto.setName("employee");
        userDto.setPassword("employee123");
        userDto.setRole(Role.EMPLOYEE);

        User savedUser = new User();
        savedUser.setName("employee");
        savedUser.setPassword("employee123");
        savedUser.setRole(Role.EMPLOYEE);

        when(userService.saveEmp(any(UserDto.class))).thenReturn(savedUser);

        ApiResponse response = userController.saveEmp(userDto);
        assertEquals("User added", response.getMessage());
        assertEquals(Role.EMPLOYEE, response.getRole());
    }

    @Test
    public void testGetEmployeesByRole() {
        String roleName = "EMPLOYEE";
        Role role = Role.EMPLOYEE;
        User user1 = new User();
        user1.setRole(role);
        User user2 = new User();
        user2.setRole(role);
        List<User> employees = new ArrayList<>();
        employees.add(user1);
        employees.add(user2);

        when(userRepository.findByRole(role)).thenReturn(employees);

        List<User> result = userController.getEmployeesByRole(roleName);

        assertEquals(2, result.size());
    }
}
