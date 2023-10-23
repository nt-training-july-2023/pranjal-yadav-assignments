package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.constants.ErrorConstants;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserInDto;
import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.exception.ValidationException;
import com.employee.employeeManagement.model.User;
import com.employee.employeeManagement.exception.InvalidCredentialsExceptions;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserValidationTest {
    @InjectMocks
    private UserValidation userValidation;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testCheckName_ValidName() {
        assertDoesNotThrow(() -> userValidation.checkName("Ankita Sharma"));
    }

    @Test
    public void testCheckName_InvalidName() {
        assertThrows(InvalidCredentialsExceptions.class, () -> userValidation.checkName("12345"));
    }
    @Test
    public void testCheckEmail_EmailNotExists() {
        when(userRepository.findByEmail("rashmi@nucleusteq.com")).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> userValidation.checkEmail("rashmi@nucleusteq.com"));
    }

    @Test
    public void testCheckEmail_EmailExists() {
        when(userRepository.findByEmail("rashmi@nucleusteq.com")).thenReturn(Optional.of(new User()));
        assertThrows(ResourceAlreadyExistsException.class, () -> userValidation.checkEmail("rashmi@nucleusteq.com"));
    }

    @Test
    public void testCheckLoginEmail_ValidEmail() {
        when(userRepository.findByEmail("rashmi@nucleusteq.com")).thenReturn(Optional.of(new User()));
        assertDoesNotThrow(() -> userValidation.checkLoginEmail("rashmi@nucleusteq.com"));
    }

    @Test
    public void testCheckLoginEmail_InvalidEmail() {
        when(userRepository.findByEmail("rashmi@nucleusteq.com")).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> userValidation.checkLoginEmail("rashmi" +
                "@nucleusteq.com"));
    }


    @Test
    public void testCheckUserId_UserIdNotExists() {
        when(userRepository.findByUserId("N2345")).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> userValidation.checkUserId("N2345"));
    }

    @Test
    public void testCheckUserId_UserIdExists() {
        when(userRepository.findByUserId("N2345")).thenReturn(Optional.of(new User()));
        assertThrows(ResourceAlreadyExistsException.class,
                () -> userValidation.checkUserId("N2345"));
    }
    @Test
    void testDecodePassword() {
        String originalPassword = "mySecretPassword123";
        String encodedPassword = Base64.getEncoder().encodeToString(originalPassword.getBytes(StandardCharsets.UTF_8));

        String decodedPassword = userValidation.decodePassword(encodedPassword);
        assertEquals(originalPassword, decodedPassword);
    }
    @Test
    public void testCheckRole_ValidRoles() {
        String[] validRoles = { "EMPLOYEE", "MANAGER", "ADMIN" };

        for (String roleName : validRoles) {
           userValidation.checkRole(roleName);

        }
    }
    @Test
    public void testCheckRole_InvalidRole() {
        String rolename = "USER";
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> userValidation.checkRole(rolename));
        assertEquals(ErrorConstants.ROLE_NOT_EXISTS, exception.getMessage());
    }
      @Test
    public void testCheckId_ValidEmployeeId() {
        Long validEmployeeId = 1L;

        User validEmployee = new User();
        validEmployee.setId(validEmployeeId);
        validEmployee.setRole(Role.EMPLOYEE);

        when(userRepository.findById(validEmployeeId)).thenReturn(Optional.of(validEmployee));

        userValidation.checkId(validEmployeeId);

    }
    @Test
    public void testCheckId_AdminEmployeeId() {
        Long adminEmployeeId = 2L;

        User adminEmployee = new User();
        adminEmployee.setId(adminEmployeeId);
        adminEmployee.setRole(Role.ADMIN);

        when(userRepository.findById(adminEmployeeId)).thenReturn(Optional.of(adminEmployee));

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> userValidation
                        .checkId(adminEmployeeId)
        );

        assertEquals(ErrorConstants.EMPLOYEE_NOT_EXIST, exception.getMessage());
    }
    @Test
    public void testCheckId_InvalidEmployeeId() {
        Long invalidEmployeeId = 3L;

        when(userRepository.findById(invalidEmployeeId)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> userValidation.checkId(invalidEmployeeId)
        );

        assertEquals(ErrorConstants.EMPLOYEE_NOT_EXIST, exception.getMessage());
    }
    @Test
    public void testCheckAdminRegister() {
        UserInDto user = new UserInDto();
        user.setUserId("N2345");
        user.setName("Ankita Sharma");
        user.setEmail("ankita@nucleusteq.com");
        assertDoesNotThrow(() -> userValidation.checkName("Ankita Sharma"));
        when(userRepository.findByEmail("rashmi@nucleusteq.com")).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> userValidation.checkEmail("rashmi@nucleusteq.com"));
        when(userRepository.findByUserId("N2345")).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> userValidation.checkUserId("N2345"));
        ValidationException exception =
                assertThrows(ValidationException.class,
                        ()-> userValidation.checkAdminRegistration(user));
        assertEquals("Only ankita.sharma@nucleusteq can " +
                "register.", exception.getMessage());
    }
//    @Test
//    public void checkLoginTest(){
//        LoginDto loginDto = new LoginDto();
//        loginDto.setEmail("ankita.sharma@nucleusteq.com");
//        loginDto.setPassword("ankita@123");
//        doNothing().when(userValidation).checkLoginEmail(loginDto.getEmail());
//        doNothing().when(userValidation).checkPassword(loginDto);
//
//
//    }


}
