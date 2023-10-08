package com.employee.employeeManagement.dto;

import jakarta.validation.constraints.Email;

import java.util.Objects;

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

    /**
     * toString method for loginDto.
     * @return String
     */
    @Override
    public final String toString() {
        return "LoginDto{"
                + "email='" + email + '\''
                + ", password='" + password + '\''
                + '}';
    }

    /**
     * equals method for loginDto.
     * @param o object.
     * @return boolean value.
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LoginDto loginDto)) {
            return false;
        }
        return Objects.equals(getEmail(), loginDto.getEmail())
                && Objects.equals(getPassword(), loginDto.getPassword());
    }

    /**
     * Hashcode method for LoginDto.
     * @return int value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword());
    }
}
