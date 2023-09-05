package com.employee.employeeManagement.exception;

import com.employee.employeeManagement.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(ResourceNotFoundException ex){
        ApiResponse apiResponse= new ApiResponse(ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(WrongCredentialsExceptions.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse handleWrongCredentialException(WrongCredentialsExceptions ex) {
        String message=ex.getMessage();
        return new ApiResponse(message);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleIllegalArgumentException(ValidationException ex) {
        String message =ex.getMessage();
        return new ApiResponse(message);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        String message = ex.getMessage();
        return new ApiResponse(message);
    }

}
