//package com.employee.employeeManagement.exceptionTest;
//
//import com.employee.employeeManagement.exception.*;
//import com.employee.employeeManagement.response.ResponseDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class CustomExceptionHandlerTest {
//
//    private CustomExceptionHandler customExceptionHandler;
//
//    @BeforeEach
//    public void setUp() {
//        customExceptionHandler = new CustomExceptionHandler();
//    }
//
//    @Test
//    public void handleNotFoundException() {
//        ResourceNotFoundException ex = new ResourceNotFoundException("Resource not found");
//        ResponseEntity<ResponseDto> responseEntity = customExceptionHandler.handleNotFoundException(ex);
//
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Resource not found", responseEntity.getBody().getMessage());
//    }
//
//    @Test
//    public void handleWrongCredentialException() {
//        WrongCredentialsExceptions ex = new WrongCredentialsExceptions("Wrong credentials");
//        ResponseDto apiResponse = customExceptionHandler.handleWrongCredentialException(ex);
//
//        assertEquals("Wrong credentials", apiResponse.getMessage());
//    }
//
//    @Test
//    public void handleIllegalArgumentException() {
//        ValidationException ex = new ValidationException("Validation error");
//        ResponseDto apiResponse = customExceptionHandler.IllegalArgumentException(ex);
//
//        assertEquals("Validation error", apiResponse.getMessage());
//    }
//
//    @Test
//    public void handleResourceAlreadyExistsException() {
//        ResourceAlreadyExistsException ex = new ResourceAlreadyExistsException("Resource already exists");
//        ResponseDto apiResponse = customExceptionHandler.handleResourceAlreadyExistsException(ex);
//
//        assertEquals("Resource already exists", apiResponse.getMessage());
//    }
//}
