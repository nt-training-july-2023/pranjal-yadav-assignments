//package com.employee.employeeManagement.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//import com.employee.employeeManagement.Model.User;
//import com.employee.employeeManagement.dto.LoginDto;
//import com.employee.employeeManagement.dto.UserDto;
//import com.employee.employeeManagement.enums.Role;
//import com.employee.employeeManagement.repository.UserRepository;
//import com.employee.employeeManagement.response.ApiResponse;
//import com.employee.employeeManagement.validation.UserValidation;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Optional;
//
//public class UserServiceTest {
//
//    @InjectMocks
//    private UserService userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @Mock
//    private UserValidation userValidation;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testAddUser() {
//        UserDto userDto = new UserDto();
//        userDto.setName("John Doe");
//        userDto.setEmail("john.doe@example.com");
//        userDto.setRole(Role.MANAGER);
//        // Set other userDto properties
//
//        User user =
//        // Set user properties
//
//
////        when(userValidation.validateUsero(userDto)).thenReturn(true);
//        when(userRepository.save(any(User.class))).thenReturn(user);
//
//        ApiResponse response = userService.addUser(userDto);
//
//        assertNotNull(response);
//        assertEquals("User Added successfully", response.getMessage());
//    }
//
//    @Test
//    public void testLogin() {
//        LoginDto loginDto = new LoginDto();
//        loginDto.setEmail("john.doe@example.com");
//        // Set other loginDto properties
//
//        User user = new User();
//        user.setRole(Role.EMPLOYEE);
//        // Set other user properties
//
//        when(userRepository.findByEmail(loginDto.getEmail())).thenReturn(Optional.of(user));
//
//        ApiResponse response = userService.login(loginDto);
//
//        assertNotNull(response);
//        assertEquals("Logged in successfully", response.getMessage());
//        assertEquals(Role.EMPLOYEE, response.getRole());
//    }
//
//
//}
//
