package com.employee.employeeManagement.dto;

import jakarta.validation.constraints.Email;

/**
 * Data Transfer Object (DTO) representing login
 * credentials for admin authentication.
 */
public class LoginDto {
    /**
     * The email of the admin for authentication.
     */
    @Email
    private String email;

    /**
     * The password for authentication.
     */
    private String password;

    /**
     * Get the email address of the user.
     *
     * @return The user's email address.
     */
    public final String getEmail() {
        return email;
    }

    /**
     * Set the email address of the user.
     *
     * @param emailParam The user's email address.
     */
    public final void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    /**
     * Get the password of the user.
     *
     * @return The user's password.
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Set the password of the user.
     *
     * @param passwordParam The user's password.
     */
    public final void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

}
