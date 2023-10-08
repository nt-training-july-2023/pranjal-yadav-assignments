package com.employee.employeeManagement.exception;

import com.employee.employeeManagement.response.ResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomExceptionHandlerTest {

    @InjectMocks
    private CustomExceptionHandler customExceptionHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testResourceNotFoundException() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Resource not found");
        ResponseEntity<ResponseDto> response = customExceptionHandler.notFoundException(ex);

        assertEquals("Resource not found", response.getBody().getMessage());
    }

    @Test
    public void testInvalidCredentialsException() {
        InvalidCredentialsExceptions ex = new InvalidCredentialsExceptions("Invalid credentials");
        ResponseDto response = customExceptionHandler.invalidCredentialException(ex);

        assertEquals("Invalid credentials", response.getMessage());
    }

    @Test
    public void testValidationException() {
        ValidationException ex = new ValidationException("Validation failed");
        ResponseDto response = customExceptionHandler.illegalArgumentException(ex);

        assertEquals("Validation failed", response.getMessage());
    }

    @Test
    public void testResourceAlreadyExistsException() {
        ResourceAlreadyExistsException ex = new ResourceAlreadyExistsException("Resource already exists");
        ResponseDto response = customExceptionHandler.resourceAlreadyExistsException(ex);

        assertEquals("Resource already exists", response.getMessage());
    }
}
