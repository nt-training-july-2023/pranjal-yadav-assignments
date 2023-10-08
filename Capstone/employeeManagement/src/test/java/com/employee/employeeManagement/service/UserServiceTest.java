package com.employee.employeeManagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.employee.employeeManagement.model.Project;
import com.employee.employeeManagement.model.User;
import com.employee.employeeManagement.dto.*;
import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.dto.UserNameDto;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.RequestResourceRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ResponseDto;
import com.employee.employeeManagement.validation.UserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private RequestResourceRepository requestResourceRepository;
    @Mock
    private RequestResourceService requestResourceService;


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

        assertEquals("This employee does not exist", exception.getMessage());
    }
    @Test
    void testGetEmployeeByIdWhenExists() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("Test User");
        user.setManagerId(2L);
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
    void testAllUserByRole() {
        Role role = Role.EMPLOYEE;
        User user1 = new User();
        user1.setRole(role);
        user1.setName("Rashmi Shukla");
        user1.setEmail("rashmi@nucleusteq.com");
        user1.setProjectId(1L);
        user1.setManagerId(3L);
        user1.setRole(Role.EMPLOYEE);
        List<String> skills = new ArrayList<>();
        skills.add("Spring boot");
        skills.add("Data Analysis");
        user1.setSkills(skills);
        user1.setProjectId(5L);
        when(userRepository.findByRole(role)).thenReturn(List.of(user1));

        User manager = new User();
        manager.setName("Vanshika");
        when(userRepository.findById(3L)).thenReturn(Optional.of(manager));

        Project project = new Project();
        project.setProjectId(5L);
        project.setProjectName("Petsmart");
        when(projectRepository.findByProjectId(5L)).thenReturn(Optional.of(project));

        List<EmployeeOutDto> outUsers = userService.allUserByRole(role.toString());

        assertEquals(1, outUsers.size());
        EmployeeOutDto employeeOutDto = outUsers.get(0);

        verify(userRepository, times(1)).findByRole(role);
        verify(userRepository, times(1)).findById(3L);
        verify(projectRepository, times(1)).findByProjectId(5L);
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
    @Test
    public void testGetEmployeeNameByLongId_ExistingId() {
        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setName("Ankita Sharma");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        user.setSkills(skills);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        UserNameDto result = userService.getEmployeeNameByLongId(id);
        assertEquals("Ankita Sharma", result.getName());
    }

    @Test
    public void testGetEmployeeNameByLongId_NonExistingId() {
        Long id = 2L;
        when(userRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            userService.getEmployeeNameByLongId(id);
        });
    }

    @Test
    public void testUnAssignProject() {
        Long userId = 1L;

        User user = new User();
        user.setUserId("Pranjal");
        user.setName("N1111");
        user.setEmail("pranjal@nucleusteq.com");
        user.setContactNo(8839069226L);
        user.setManagerId(2L);
        user.setProjectId(3L);

        User admin = new User();
        admin.setUserId("N0001");
        admin.setName("Ankita");
        admin.setEmail("ankita.sharma@nucleusteq.com");
        admin.setContactNo(9876501234L);
        admin.setId(2L); // Assuming admin user ID is 2

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findByUserId("N0001")).thenReturn(Optional.of(admin));

        ResponseDto responseDto = userService.unAssignProject(userId);

        assertEquals(admin.getId(), user.getManagerId());

        assertNull(user.getProjectId());

        verify(userRepository, times(1)).save(user);

        assertEquals("Project unassigned", responseDto.getMessage());

    }
    @Test
    public void testUserDtoToUser() {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("SQL");
        UserInDto userDto = new UserInDto();
        userDto.setName("Pranjal Yadagv");
        userDto.setRole(Role.EMPLOYEE);
        userDto.setProjectId(1L);
        userDto.setPassword("password123");
        userDto.setDob("1990-01-01");
        userDto.setDoj("2022-01-01");
        userDto.setEmail("pranjal@nucleusteq.com");
        userDto.setUserId("N1111");
        userDto.setLocation(Location.RAIPUR);
        userDto.setDesignation(Designation.ENGINEER);
        userDto.setContactNo(1234567890L);
        userDto.setSkills(skills);
        userDto.setManagerId(2L);


        UserService userService = new UserService();
        User user = userService.userDtoToUser(userDto);

        assertEquals(userDto.getName(), user.getName());
        assertEquals(userDto.getRole(), user.getRole());
        assertEquals(userDto.getProjectId(), user.getProjectId());
        assertEquals(userDto.getPassword(), user.getPassword());
        assertEquals(userDto.getDob(), user.getDob());
        assertEquals(userDto.getDoj(), user.getDoj());
        assertEquals(userDto.getEmail(), user.getEmail());
        assertEquals(userDto.getUserId(), user.getUserId());
        assertEquals(userDto.getLocation(), user.getLocation());
        assertEquals(userDto.getDesignation(), user.getDesignation());
        assertEquals(userDto.getContactNo(), user.getContactNo());
        assertEquals(userDto.getSkills(), user.getSkills());
        assertEquals(userDto.getManagerId(), user.getManagerId());
    }
    @Test
    public void testGetEmployeeNameById() {

        String userId = "N1111";

        User user = new User();
        user.setName("Pranjal Yadav");
        user.setUserId(userId);
        user.setEmail("pranjal@nucleusteq.com");
        user.setId(9L);
        user.setContactNo(8839069226L);

        Mockito.when(userRepository.findByUserId(userId)).thenReturn(Optional.of(user));

        UserNameDto userNameDto = userService.getEmployeeNameById(userId);

        assertEquals("Pranjal Yadav", userNameDto.getName());

        Mockito.verify(userRepository, Mockito.times(1)).findByUserId(userId);
    }
    @Test
    public void testGetEmployeeNameByIdUserNotFound() {
        String userId = "N1010";

        Mockito.when(userRepository.findByUserId(userId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.getEmployeeNameById(userId));

        Mockito.verify(userRepository, Mockito.times(1)).findByUserId(userId);

    }
    @Test
    public void testDeleteRequest() {
        Long resourceIdToDelete = 1L;

        doNothing().when(requestResourceRepository).deleteById(resourceIdToDelete);

        ResponseDto responseDto = userService.deleteRequest(resourceIdToDelete);

        assertEquals("Deleted successfully!", responseDto.getMessage());
        verify(requestResourceRepository, times(1)).deleteById(resourceIdToDelete);
    }

    @Test
    void testDecodePassword() {
        String originalPassword = "mySecretPassword123";
        String encodedPassword = Base64.getEncoder().encodeToString(originalPassword.getBytes(StandardCharsets.UTF_8));

        String decodedPassword = userService.decodePassword(encodedPassword);
        assertEquals(originalPassword, decodedPassword);
    }
    @Test
    void testGetAllUsers() {
        MockitoAnnotations.openMocks(this);

        List<String> skills = new ArrayList<>();
        skills.add("Hibernate");
        skills.add("Data Science");
        User adminUser = new User();
        adminUser.setRole(Role.ADMIN);
        adminUser.setSkills(skills);

        User employeeUser = new User();
        employeeUser.setRole(Role.EMPLOYEE);
        employeeUser.setSkills(skills);

        User managerUser = new User();
        managerUser.setRole(Role.MANAGER);
        managerUser.setSkills(skills);

        List<User> userList = new ArrayList<>();
        userList.add(adminUser);
        userList.add(employeeUser);
        userList.add(managerUser);

        Project project = new Project();
        project.setProjectId(4L);
        project.setProjectName("Fyndr");
        when(userRepository.findAll()).thenReturn(userList);
        when(userRepository.findById(any())).thenReturn(Optional.of(adminUser));
        when(projectRepository.findByProjectId(any())).thenReturn(Optional.of(project));

        List<EmployeeOutDto> userDtoList = userService.getAllUsers();

        assertEquals(2, userDtoList.size()); // Expecting two non-admin users

        verify(userRepository, times(1)).findAll();
    }

}

