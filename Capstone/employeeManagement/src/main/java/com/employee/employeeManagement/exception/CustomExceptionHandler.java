package com.employee.employeeManagement.exception;

import com.employee.employeeManagement.response.ResponseDto;
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
     * ResponseDto with a NOT_FOUND status.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<ResponseDto> notFoundException(
            final ResourceNotFoundException ex) {
        ResponseDto apiResponse = new ResponseDto(ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    /**
     * Exception handler for WrongCredentialsExceptions.
     *
     * @param ex The WrongCredentialsExceptions to handle.
     * @return ResponseDto with an UNAUTHORIZED status.
     */
    @ExceptionHandler(WrongCredentialsExceptions.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseDto invalidCredentialException(
            final WrongCredentialsExceptions ex) {
        String message = ex.getMessage();
        return new ResponseDto(message);
    }
    /**
     * Exception handler for ValidationException.
     *
     * @param ex The ValidationException to handle.
     * @return ResponseDto with a BAD_REQUEST status.
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseDto illegalArgumentException(
            final ValidationException ex) {
        String message = ex.getMessage();
        return new ResponseDto(message);
    }
    /**
     * Exception handler for ResourceAlreadyExistsException.
     *
     * @param ex The ResourceAlreadyExistsException to handle.
     * @return ResponseDto with a FOUND status.
     */
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public final ResponseDto resourceAlreadyExistsException(
            final ResourceAlreadyExistsException ex) {
        String message = ex.getMessage();
        return new ResponseDto(message);
    }

}
