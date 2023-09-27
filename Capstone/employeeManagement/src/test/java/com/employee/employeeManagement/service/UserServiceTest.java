package com.employee.employeeManagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.Model.RequestResource;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.*;
import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ResponseDto;
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
        UserInDto userDto = new UserInDto();
        userDto.setName("Rashmi Shukla");
        userDto.setEmail("rashmi.shukla@nucleusteq.com");
        userDto.setUserId("N1123");
        userDto.setContactNo(9087654321L);
        List<String> skills= new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        userDto.setSkills(skills);

        when(userRepository.save(any(User.class))).thenReturn(new User());
        ResponseDto response = userService.addUser(userDto);
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
        LoginResponse response = userService.login(loginDto);
        assertNotNull(response);
        assertEquals("Logged in successfully", response.getMessage());
        assertEquals(Role.EMPLOYEE, response.getRole());
    }
    @Test
    public void testSaveEmpWithManagerIdNull() {
        UserInDto userDto = new UserInDto();
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

        ResponseDto response = userService.saveEmp(userDto);
        verify(userRepository, times(1)).save(any(User.class));

        assertEquals("User added", response.getMessage());
        assertEquals(Role.EMPLOYEE, response.getRole());
    }
    @Test
    public void testUpdateSkills() {
        Long userId = 1L;

        List<String> newSkills = Arrays.asList("Java", "Spring", "React");

        User user = new User();
        user.setId(userId);
        user.setName("Anjali Sharma");
        user.setEmail("anjali@ucleusteq.com");
        user.setSkills(Arrays.asList("Java", "SQL"));

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        ResponseDto response = userService.updateSkills(userId, newSkills);

        verify(userRepository, times(1)).findById(userId);

        assertEquals(newSkills, user.getSkills());

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

        ResponseDto response = userService.updateEmployee(userId, updatedDetails);

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
    @Test
    void testGetEmployeeByIdWhenExists() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("Test User");
        user.setManagerId(2L); // Assuming a manager with ID 2 exists
        List<String> skills= new ArrayList<>();
        user.setDesignation(Designation.ENGINEER);
        user.setLocation(Location.BANGALORE);
        user.setEmail("rashmi@nucleusteq.com");
        user.setContactNo(9087654321L);
        user.setRole(Role.EMPLOYEE);
        skills.add("Java");
        skills.add("React");
        user.setSkills(skills);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User manager = new User();
        manager.setId(2L);
        manager.setName("Manager User");
        List<String> skills1= new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        manager.setSkills(skills1);
        when(userRepository.findById(2L)).thenReturn(Optional.of(manager));

        EmployeeOutDto employeeOutDto = userService.getEmployeeById(userId);

        assertNotNull(employeeOutDto);
        assertEquals(user.getId(), employeeOutDto.getId());
        assertEquals(user.getName(), employeeOutDto.getName());
        assertEquals(manager.getName(), employeeOutDto.getManagerName());
        assertEquals(user.getEmail(), employeeOutDto.getEmail());
        assertEquals(user.getUserId(), employeeOutDto.getUserId());
        assertEquals(user.getDesignation(), employeeOutDto.getDesignation());
        assertEquals(user.getContactNo(), employeeOutDto.getContactNo());
        assertEquals(user.getDob(), employeeOutDto.getDob());
        assertEquals(user.getDoj(), employeeOutDto.getDoj());
        assertEquals(user.getLocation(), employeeOutDto.getLocation());
        assertEquals(user.getProjectId(), employeeOutDto.getProjectId());
        assertEquals(user.getManagerId(), employeeOutDto.getManagerId());
        assertEquals(user.getSkills(), employeeOutDto.getSkills());
        assertEquals(user.getRole(), employeeOutDto.getRole());
    }
    @Test
    void testGetEmployeeByIdWhenDoesNotExist() {
        Long userId = 2L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            userService.getEmployeeById(userId);
        });
    }
    @Test
    void testRequestToOutDto() {
        RequestResource requestResource = new RequestResource();
        requestResource.setResourceId(1L);
        requestResource.setComment("Test comment");
        requestResource.setEmployeeId(2L);
        requestResource.setManagerId(3L);
        requestResource.setProjectId(4L);

        User employee = new User();
        employee.setId(2L);
        employee.setName("Employee User");
        employee.setUserId("employee123");

        User manager = new User();
        manager.setId(3L);
        manager.setName("Manager User");
        manager.setUserId("manager123");

        when(userRepository.findById(2L)).thenReturn(Optional.of(employee));
        when(userRepository.findById(3L)).thenReturn(Optional.of(manager));

        Project project = new Project();
        project.setProjectId(4L);
        project.setProjectName("Test Project");

        when(projectRepository.findById(4L)).thenReturn(Optional.of(project));

        RequestResourceOutDto dto = userService.requestToOutDto(requestResource);

        assertNotNull(dto);
        assertEquals(requestResource.getResourceId(), dto.getResourceId());
        assertEquals(requestResource.getComment(), dto.getComment());
        assertEquals(requestResource.getEmployeeId(), dto.getEmployeeId());
        assertEquals(requestResource.getManagerId(), dto.getManagerId());
        assertEquals(requestResource.getProjectId(), dto.getProjectId());
        assertEquals(employee.getName(), dto.getEmployeeName());
        assertEquals(employee.getUserId(), dto.getEmployeeUserId());
        assertEquals(manager.getName(), dto.getManagerName());
        assertEquals(manager.getUserId(), dto.getManagerUserId());
        assertEquals(project.getProjectName(), dto.getProjectName());
    }
    @Test
    void testUserToOutDto() {
        User user = new User();
        user.setId(1L);
        user.setName("Test User");
        user.setEmail("test@example.com");
        user.setUserId("test123");
        user.setDesignation(Designation.ENGINEER);
        user.setContactNo(1234567890L);
        user.setDob("1990-01-01");
        user.setDoj("2021-01-01");
        user.setLocation(Location.RAIPUR);
        user.setProjectId(2L);
        user.setManagerId(3L);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        user.setSkills(skills);
        user.setRole(Role.EMPLOYEE);

        User manager = new User();
        manager.setId(3L);
        manager.setName("Manager User");

        when(userRepository.findById(3L)).thenReturn(Optional.of(manager));

        Project project = new Project();
        project.setProjectId(2L);
        project.setProjectName("Test Project");

        when(projectRepository.findByProjectId(2L)).thenReturn(Optional.of(project));

        EmployeeOutDto employeeOutDto = userService.userToOutDto(user);

        assertNotNull(employeeOutDto);
        assertEquals(user.getId(), employeeOutDto.getId());
        assertEquals(user.getName(), employeeOutDto.getName());
        assertEquals(user.getEmail(), employeeOutDto.getEmail());
        assertEquals(user.getUserId(), employeeOutDto.getUserId());
        assertEquals(user.getDesignation(), employeeOutDto.getDesignation());
        assertEquals(user.getContactNo(), employeeOutDto.getContactNo());
        assertEquals(user.getDob(), employeeOutDto.getDob());
        assertEquals(user.getDoj(), employeeOutDto.getDoj());
        assertEquals(user.getLocation(), employeeOutDto.getLocation());
        assertEquals(user.getProjectId(), employeeOutDto.getProjectId());
        assertEquals(user.getManagerId(), employeeOutDto.getManagerId());
        assertEquals(manager.getName(), employeeOutDto.getManagerName());
        assertEquals(user.getSkills(), employeeOutDto.getSkills());
        assertEquals(user.getRole(), employeeOutDto.getRole());
        assertEquals(project.getProjectName(), employeeOutDto.getProjectName());
    }

}

