package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Role;

import java.util.Objects;

/**
 * The `LoginResponse` class represents the response data for a login operation.
 */
public class LoginResponse {
    /**
     * Message to be sent.
     */
    private String message;
    /**
     * Id of user who logs in..
     */
    private Long id;
    /**
     * role of user who logs in.
     */
    private Role role;
    /**
     * Name of user who logs in.
     */
    private String name;

    /**
     * Constructs a `LoginResponse` object with the specified parameters.
     *
     * @param messageParam The message associated with the login response.
     * @param idParam      The ID associated with the user in the response.
     * @param roleParam    The role associated with the user in the response.
     * @param nameParam    The name associated with the user in the response.
     */
    public LoginResponse(final String messageParam, final Long idParam,
                         final Role roleParam, final String nameParam) {
        this.message = messageParam;
        this.id = idParam;
        this.role = roleParam;
        this.name = nameParam;
    }

    /**
     * No argument constructor of this class.
     */
    public LoginResponse() {

    }

    /**
     * Gets the role associated with the login response.
     *
     * @return The role.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role associated with the login response.
     *
     * @param roleParam The role to set.
     */
    public void setRole(final Role roleParam) {
        this.role = roleParam;
    }

    /**
     * Gets the message associated with the login response.
     *
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message associated with the login response.
     *
     * @param messageParam The message to set.
     */
    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    /**
     * Gets the ID associated with the user in the response.
     *
     * @return The ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID associated with the user in the response.
     *
     * @param idParam The ID to set.
     */
    public void setId(final Long idParam) {
        this.id = idParam;
    }

    /**
     * Gets the name associated with the user in the response.
     *
     * @return The name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name associated with the user in the response.
     *
     * @param nameParam The name to set.
     */
    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * Returns a string representation of the `LoginResponse` object.
     *
     * @return A string containing the message, ID, role, and name fields.
     */
    @Override
    public final String toString() {
        return "LoginResponse{"
                + "message='" + message + '\''
                + ", id=" + id
                + ", role=" + role
                + ", name='" + name + '\''
                + '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the `o` argument;
     *         {@code false} otherwise.
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LoginResponse that)) {
            return false;
        }
        return Objects.equals(getMessage(), that.getMessage())
                && Objects.equals(getId(), that.getId())
                && getRole() == that.getRole()
                && Objects.equals(getName(), that.getName());
    }

    /**
     * Returns a hash code value for the `LoginResponse` object.
     *
     * @return A hash code computed from the message, ID, role, and name fields.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), getId(), getRole(), getName());
    }
}

