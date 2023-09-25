package com.employee.employeeManagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ApiResponse;
import com.employee.employeeManagement.validation.UserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserValidation userValidation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUser() {
        UserDto userDto = new UserDto();
        userDto.setName("Rashmi Shukla");
        userDto.setEmail("rashmi.shukla@nucleusteq.com");
        userDto.setUserId("N1123");
        userDto.setContactNo(9087654321L);
        List<String> skills= new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        userDto.setSkills(skills);

        when(userRepository.save(any(User.class))).thenReturn(new User());
        ApiResponse response = userService.addUser(userDto);
        verify(userRepository, times(1)).save(any(User.class));
        assertEquals("User Added successfully", response.getMessage());
    }

    @Test
    public void testLogin() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("rashmi.shukla@nucleusteq.com");
        User user = new User();
        user.setRole(Role.EMPLOYEE);
        when(userRepository.findByEmail(loginDto.getEmail())).thenReturn(Optional.of(user));
        ApiResponse response = userService.login(loginDto);
        assertNotNull(response);
        assertEquals("Logged in successfully", response.getMessage());
        assertEquals(Role.EMPLOYEE, response.getRole());
    }
    @Test
    public void testSaveEmpWithManagerIdNull() {
        UserDto userDto = new UserDto();
        userDto.setName("Ishita Verma");
        userDto.setEmail("ishita@nucleusteq.com");
        userDto.setUserId("N2223");
        userDto.setContactNo(9870654312L);
        userDto.setManagerId(2L); // ManagerId is not null
        List<String> skills= new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        userDto.setSkills(skills);
        userDto.setRole(Role.EMPLOYEE);

        when(userRepository.save(any(User.class))).thenReturn(new User());

        ApiResponse response = userService.saveEmp(userDto);
        verify(userRepository, times(1)).save(any(User.class));

        assertEquals("User added", response.getMessage());
        assertEquals(Role.EMPLOYEE, response.getRole());
    }
    @Test
    public void testUpdateSkills() {
        // Define a sample user ID
        Long userId = 1L;

        // Define a list of sample skills
        List<String> newSkills = Arrays.asList("Java", "Spring", "React");

        // Create a sample user
        User user = new User();
        user.setId(userId);
        user.setName("Anjali Sharma");
        user.setEmail("anjali@ucleusteq.com");
        user.setSkills(Arrays.asList("Java", "SQL"));

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        ApiResponse response = userService.updateSkills(userId, newSkills);

        verify(userRepository, times(1)).findById(userId);

        assertEquals(newSkills, user.getSkills());

        // Verify the response message
        assertEquals("Skills are updated.", response.getMessage());
    }
    @Test
    public void testUpdateEmployee() {
        Long userId = 1L;

        Long updatedProjectId = 100L;
        Long updatedManagerId = 2L;

        User user = new User();
        user.setId(userId);
        user.setName("Hemant");
        user.setEmail("hemant@nucleusteq.com");
        user.setProjectId(50L);
        user.setManagerId(1L);

        Map<String, Long> updatedDetails = new HashMap<>();
        updatedDetails.put("projectId", updatedProjectId);
        updatedDetails.put("managerId", updatedManagerId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        ApiResponse response = userService.updateEmployee(userId, updatedDetails);

        verify(userRepository, times(1)).findById(userId);

        assertEquals(updatedProjectId, user.getProjectId());
        assertEquals(updatedManagerId, user.getManagerId());

        assertEquals("Updated Successfully", response.getMessage());
    }
    @Test
    public void testUpdateEmployeeNotFound() {
        Long userId = 1L;

        Map<String, Long> updatedDetails = new HashMap<>();
        updatedDetails.put("projectId", 100L);
        updatedDetails.put("managerId", 2L);

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            userService.updateEmployee(userId, updatedDetails);
        });
        verify(userRepository, times(1)).findById(userId);

        assertEquals("Resource not found.", exception.getMessage());
    }

}

