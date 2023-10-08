package com.employee.employeeManagement.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.*;

import com.employee.employeeManagement.dto.EmployeeOutDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.LoginResponse;
import com.employee.employeeManagement.dto.UserInDto;
import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.exception.InvalidCredentialsExceptions;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.dto.UserNameDto;
import com.employee.employeeManagement.response.ResponseDto;
import com.employee.employeeManagement.service.UserService;
import com.employee.employeeManagement.validation.UserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @MockBean
    private UserValidation userValidation;

    @InjectMocks
    private UserController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }
    List<String> skills = new ArrayList<>();
    @Test
    public void testLogin() throws Exception {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("ankita.sharma@nucleusteq.com");
        loginDto.setPassword("admin123");
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(loginDto);
        LoginResponse response = new LoginResponse();
        response.setMessage("Login Successful");
        response.setName("Ankita Sharma");
        response.setRole(Role.ADMIN);
        response.setId(1L);
        doNothing().when(userValidation).checkLoginDto(loginDto);
        when(userService.login(Mockito.any())).thenReturn(response);

        MvcResult mvcResult = this.mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testLoginEmailException() throws Exception {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("ankita@nucleusteq.com");
        loginDto.setPassword("admin123");
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(loginDto);
        doThrow(InvalidCredentialsExceptions.class).when(userValidation)
                .checkLoginDto(loginDto);
        MvcResult mvcResult = this.mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(401, status);

    }
    @Test
    public void testAddAdmin()throws Exception{
        UserInDto user = new UserInDto();
        user.setName("Ankita Sharma");
        user.setUserId("N1000");
        user.setManagerId(9L);
        user.setDesignation(Designation.ENGINEER);
        user.setRole(Role.ADMIN);
        user.setContactNo(9876543210L);
        user.setEmail("ankita.sharma@nucleusteq.com");
        user.setDob("17-08-2001");
        user.setDoj("17-07-2023");
        user.setProjectId(3L);
        skills.add("Java");
        skills.add("React");
        user.setSkills(skills);
        user.setLocation(Location.RAIPUR);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(user);
        ResponseDto responseDto = new ResponseDto("User Added successfully");
        doNothing().when(userValidation).checkUser(user);
        when(userService.addUser(Mockito.any())).thenReturn(responseDto);
        MvcResult mvcResult =
                this.mockMvc.perform(post("/user/save").contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);


    }
    @Test
    public void testAdminEmailException() throws Exception{
        UserInDto empDto =  new UserInDto();
        skills.add("React");
        skills.add("Java");
        empDto.setUserId("N0001");
        empDto.setName("Ankita Sharma");
        empDto.setEmail("ankita.sharma@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.BANGALORE);
        empDto.setDesignation(Designation.RECRUITER);
        empDto.setContactNo(1234567890L);
        empDto.setPassword("admin123");
        empDto.setRole(Role.ADMIN);
        empDto.setProjectId(0L);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);
        doThrow(ResourceAlreadyExistsException.class).when(userValidation)
                .checkUser(empDto);
        MvcResult mvcResult = this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(409, status);
    }

    @Test
    public void testAdminEmpIdException() throws Exception{
        UserInDto empDto =  new UserInDto();
        skills.add("React");
        skills.add("Java");
        empDto.setUserId("N0001");
        empDto.setName("Ankita Sharma");
        empDto.setEmail("ankita.sharma@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.BANGALORE);
        empDto.setDesignation(Designation.RECRUITER);
        empDto.setContactNo(1234567890L);
        empDto.setPassword("admin123");
        empDto.setRole(Role.ADMIN);
        empDto.setProjectId(0L);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);
        doThrow(ResourceAlreadyExistsException.class).when(userValidation)
                .checkUser(empDto);
        MvcResult mvcResult = this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(409, status);
    }
    @Test
    public void testAddEmployee() throws Exception {
        UserInDto user = new UserInDto();
        user.setName("Ishita Verma");
        user.setUserId("N2038");
        user.setManagerId(1L);
        user.setDesignation(Designation.ENGINEER);
        user.setRole(Role.EMPLOYEE);
        user.setContactNo(9876543210L);
        user.setEmail("ishita@nucleusteq.com");
        user.setDob("17-08-2001");
        user.setDoj("17-07-2023");
        user.setProjectId(null);
        user.setPassword("N2038@20010817");
        skills.add("Java");
        skills.add("React");
        user.setSkills(skills);
        user.setLocation(Location.RAIPUR);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(user);
        ResponseDto responseDto = new ResponseDto("User Added successfully");

        doNothing().when(userValidation).checkUser(user);
        when(userService.addUser(Mockito.any())).thenReturn(responseDto);

        MvcResult mvcResult =
                this.mockMvc.perform(post("/user/save-emp").contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testAddEmployeeEmailException() throws Exception {
        UserInDto empDto =  new UserInDto();
        skills.add("React");
        skills.add("Java");
        empDto.setUserId("N7929");
        empDto.setName("Ishita Verma");
        empDto.setEmail("ishita@nucleusteq.com");
        empDto.setDob("2001-08-17");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.RAIPUR);
        empDto.setDesignation(Designation.ENGINEER);
        empDto.setContactNo(1234567890L);
        empDto.setPassword("N7929@20010817");
        empDto.setRole(Role.EMPLOYEE);
        empDto.setProjectId(null);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);
        doThrow(ResourceAlreadyExistsException.class).when(userValidation)
                .checkUser(empDto);
        MvcResult mvcResult = this.mockMvc.perform(post("/user/save-emp")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(409, status);
    }

    @Test
    public void testGetAllEmployeeByRole() throws Exception {
        EmployeeOutDto e1 = new EmployeeOutDto();
        e1.setName("Rashmi Shukla");
        e1.setEmail("rashmi@nucleusteq.com");
        e1.setContactNo(9876543210L);
        e1.setUserId("N1111");
        skills.add("Java");
        skills.add("React");
        e1.setSkills(skills);
        e1.setRole(Role.EMPLOYEE);

        EmployeeOutDto e2 = new EmployeeOutDto();
        e2.setName("Vanshika Sharma");
        e2.setEmail("vanshika@nucleusteq.com");
        e2.setContactNo(9876543210L);
        e2.setUserId("N2222");
        skills.add("Spring");
        skills.add("sql");
        e2.setSkills(skills);
        e2.setRole(Role.EMPLOYEE);

        List<EmployeeOutDto> expectedEmployees = Arrays.asList(e1, e2);
        when(userService.allUserByRole("EMPLOYEE")).thenReturn(expectedEmployees);
        MvcResult mvcResult =
        mockMvc.perform(get("/user/all/EMPLOYEE").contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testListAllEmployees() throws Exception{
        EmployeeOutDto employeeOutDto = new EmployeeOutDto();
        employeeOutDto.setName("Anjali Sharma");
        employeeOutDto.setEmail("anjali.sharma@nucluesteq.com");
        employeeOutDto.setUserId("N1001");
        employeeOutDto.setManagerName("Ankita Sharma");
        employeeOutDto.setDesignation(Designation.ENGINEER);
        employeeOutDto.setLocation(Location.RAIPUR);
        employeeOutDto.setDob("2001-09-07");
        employeeOutDto.setDoj("2023-07-17");
        employeeOutDto.setContactNo(1234567890L);
        skills.add("Spring");
        skills.add("Hibernate");
        employeeOutDto.setSkills(skills);
        List<EmployeeOutDto> empOutList = new ArrayList<>();
        empOutList.add(employeeOutDto);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(employeeOutDto);
        when(userService.getAllUsers()).thenReturn(empOutList);

        MvcResult mvcResult = this.mockMvc.perform(get("/user/allUsers")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testGetEmployeeById() throws Exception{
        skills.add("React");
        skills.add("Java");
//        EmployeeOutDto empDto = new EmployeeOutDto();
//        empDto.setUserId("N0001");
//        empDto.setName("Nachiketa Mohanty");
//        empDto.setEmail("nachiketa@nucleusteq.com");
//        empDto.setDob("2001-08-17");
//        empDto.setDoj("2019-11-21");
//        empDto.setLocation(Location.BANGALORE);
//        empDto.setDesignation(Designation.RECRUITER);
//        empDto.setContactNo(1234567890L);
//        empDto.setRole(Role.EMPLOYEE);
//        empDto.setProjectId(3L);
//        empDto.setSkills(skills);
//        empDto.setManagerId(1L);
//        empDto.setManagerName("Ankita Sharma");
//        empDto.setProjectName("Fynder");
//        empDto.setId(1L);
        UserNameDto userNameDto = new UserNameDto();
        userNameDto.setName("Rashmi Shukla");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(userNameDto);
        when(userService.getEmployeeNameByLongId(Mockito.any())).thenReturn(userNameDto);

        MvcResult mvcResult = this.mockMvc.perform(get("/user/getUserById/1")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testAssignProject() throws Exception {
        skills.add("React");
        skills.add("Java");
        UserInDto empDto = new UserInDto();
        empDto.setUserId("N0004");
        empDto.setName("Pranjal Yadav");
        empDto.setEmail("pranjal@nucleusteq.com");
        empDto.setDob("2001-08-17");
        empDto.setDoj("2023-07-17");
        empDto.setLocation(Location.RAIPUR);
        empDto.setDesignation(Designation.ENGINEER);
        empDto.setContactNo(1234567890L);
        empDto.setRole(Role.EMPLOYEE);
        empDto.setProjectId(null);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);
        empDto.setPassword("N1004@20010817");
        empDto.setSkills(skills);

        ResponseDto resp= new ResponseDto("Project Assigned Successfully");
        Map<String,Long> map= new HashMap<String,Long>();
        map.put("projectId", empDto.getProjectId());
        map.put("managerId", empDto.getManagerId());
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(map);
        when(userService.updateEmployee(1L,map)).thenReturn(resp);

        MvcResult mvcResult = this.mockMvc.perform(put("/user/1/assignProject")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }
    @Test
    void testUpdateSkills() throws Exception{
        skills.add("React");
        skills.add("Java");
        ResponseDto resp= new ResponseDto("Skills are updated.");

        UserInDto empDto = new UserInDto();
        empDto.setSkills(skills);

        Map<String,List<String>> map= new HashMap<String,List<String>>();
        map.put("skills",skills);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);
        when(userService.updateSkills(1L,skills)).thenReturn(resp);

        MvcResult mvcResult = this.mockMvc.perform(put("/user/1/skill")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void employeeWithSkill() throws Exception{
        skills.add("React");
        skills.add("Java");

        List<EmployeeOutDto> empOutList = new ArrayList<EmployeeOutDto>();

        when(userService.searchBySkills(skills,true)).thenReturn(empOutList);

        MvcResult mvcResult = this.mockMvc.perform(get("/user/employees/skills")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("skills", "React", "Java")
                        .param("isCheck", "true"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testUnassignProject() throws Exception {

        ResponseDto resp= new ResponseDto("Project unassigned");

        UserInDto empDto= new UserInDto();

        empDto.setUserId("N0320");
        empDto.setName("Vanshika Sharma");
        empDto.setEmail("vanshika@nucleusteq.com");
        empDto.setDob("2001-09-07");
        empDto.setDoj("2023-07-17");
        empDto.setLocation(Location.RAIPUR);
        empDto.setDesignation(Designation.ENGINEER);
        empDto.setContactNo(1234567890L);
        empDto.setRole(Role.EMPLOYEE);
        empDto.setProjectId(0L);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);
        empDto.setPassword("N0320@07092001");
        empDto.setSkills(skills);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);
        when(userService.unAssignProject(1L)).thenReturn(resp);

        MvcResult mvcResult = this.mockMvc.perform(put("/user/unassign/1")
                        .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}
