package com.employee.employeeManagement.exception;

import com.employee.employeeManagement.response.ResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomExceptionHandlerTest {

    @InjectMocks
    private CustomExceptionHandler customExceptionHandler;
    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidException;
    @Mock
    private BindingResult bindingResult;

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
    @Test
    void testHandleDtoValidation() {
        when(methodArgumentNotValidException.getBindingResult()).thenReturn(bindingResult);
        FieldError fieldError = mock(FieldError.class);
        when(fieldError.getField()).thenReturn("fieldName");
        when(fieldError.getDefaultMessage()).thenReturn("Validation error message");
        when(bindingResult.getAllErrors()).thenReturn(List.of(fieldError));
        Map<String, String> response =
                customExceptionHandler. handleEmptyDataValidation(methodArgumentNotValidException);
        assertEquals("Validation error message", response.get("fieldName"));
    }
}
