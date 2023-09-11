package com.employee.employeeManagement.exception;

import com.employee.employeeManagement.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * Global exception handling class for handling custom exceptions and
 * providing appropriate responses.
 */
@RestControllerAdvice
public class CustomExceptionHandler {
    /**
     * Exception handler for ResourceNotFoundException.
     *
     * @param ex The ResourceNotFoundException to handle.
     * @return ResponseEntity containing an
     * ApiResponse with a NOT_FOUND status.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ApiResponse> handleNotFoundException(
            final ResourceNotFoundException ex) {
        ApiResponse apiResponse = new ApiResponse(ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    /**
     * Exception handler for WrongCredentialsExceptions.
     *
     * @param ex The WrongCredentialsExceptions to handle.
     * @return ApiResponse with an UNAUTHORIZED status.
     */
    @ExceptionHandler(WrongCredentialsExceptions.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ApiResponse handleWrongCredentialException(
            final WrongCredentialsExceptions ex) {
        String message = ex.getMessage();
        return new ApiResponse(message);
    }
    /**
     * Exception handler for ValidationException.
     *
     * @param ex The ValidationException to handle.
     * @return ApiResponse with a BAD_REQUEST status.
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ApiResponse handleIllegalArgumentException(
            final ValidationException ex) {
        String message = ex.getMessage();
        return new ApiResponse(message);
    }
    /**
     * Exception handler for ResourceAlreadyExistsException.
     *
     * @param ex The ResourceAlreadyExistsException to handle.
     * @return ApiResponse with a FOUND status.
     */
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public final ApiResponse handleResourceAlreadyExistsException(
            final ResourceAlreadyExistsException ex) {
        String message = ex.getMessage();
        return new ApiResponse(message);
    }

}
