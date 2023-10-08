package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.constants.ErrorConstants;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserInDto;
import com.employee.employeeManagement.enums.Role;
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
import java.util.Base64;
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
        // Valid role names
        String[] validRoles = { "EMPLOYEE", "MANAGER", "ADMIN" };

        for (String roleName : validRoles) {
            // Call the method under test with a valid role name
            userValidation.checkRole(roleName);

            // No exception should be thrown for valid roles
        }
    }
    @Test
    public void testCheckRole_InvalidRole() {
        // Invalid role names
        String[] invalidRoles = { "INVALID_ROLE", "GUEST", "SUPERVISOR" };

        for (String roleName : invalidRoles) {
            // Call the method under test with an invalid role name
            ResourceNotFoundException exception = assertThrows(
                    ResourceNotFoundException.class,
                    () -> userValidation.checkRole(roleName)
            );

            // Verify that the expected exception is thrown
            assertEquals(ErrorConstants.ROLE_NOT_EXISTS, exception.getMessage());
        }
    }  @Test
    public void testCheckId_ValidEmployeeId() {
        // Create a valid employee ID
        Long validEmployeeId = 1L;

        // Mock the userRepository behavior for finding the employee
        User validEmployee = new User();
        validEmployee.setId(validEmployeeId);
        validEmployee.setRole(Role.EMPLOYEE);

        when(userRepository.findById(validEmployeeId)).thenReturn(Optional.of(validEmployee));

        // Call the method under test with a valid employee ID
        userValidation.checkId(validEmployeeId);

        // No exception should be thrown for a valid employee ID
    }
    @Test
    public void testCheckId_AdminEmployeeId() {
        // Create an employee ID that corresponds to an ADMIN
        Long adminEmployeeId = 2L;

        // Mock the userRepository behavior for finding the employee
        User adminEmployee = new User();
        adminEmployee.setId(adminEmployeeId);
        adminEmployee.setRole(Role.ADMIN);

        when(userRepository.findById(adminEmployeeId)).thenReturn(Optional.of(adminEmployee));

        // Call the method under test with an employee ID that has ADMIN role
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> userValidation
                        .checkId(adminEmployeeId)
        );

        // Verify that the expected exception is thrown
        assertEquals(ErrorConstants.EMPLOYEE_NOT_EXIST, exception.getMessage());
    }
    @Test
    public void testCheckId_InvalidEmployeeId() {
        // Create an invalid employee ID
        Long invalidEmployeeId = 3L;

        // Mock the userRepository behavior for not finding the employee
        when(userRepository.findById(invalidEmployeeId)).thenReturn(Optional.empty());

        // Call the method under test with an invalid employee ID
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> userValidation.checkId(invalidEmployeeId)
        );

        // Verify that the expected exception is thrown
        assertEquals(ErrorConstants.EMPLOYEE_NOT_EXIST, exception.getMessage());
    }



}
