package com.employee.employeeManagement.exception;

public class ValidationException extends RuntimeException{
    public ValidationException(final String message) {
        super(message);
    }
}
