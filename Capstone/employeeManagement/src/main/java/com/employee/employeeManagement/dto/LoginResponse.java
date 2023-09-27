package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Role;

public class LoginResponse {
    String message;
    Long id;
    Role role;
    String name;

    public Role getRole() {
        return role;
    }

    public void setRole(final Role roleParam) {
        this.role = roleParam;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long idParam) {
        this.id = idParam;
    }

    public String getName() {
        return name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public LoginResponse(String message, Long id, Role role, String name) {
        this.message = message;
        this.id = id;
        this.role = role;
        this.name = name;
    }
}
