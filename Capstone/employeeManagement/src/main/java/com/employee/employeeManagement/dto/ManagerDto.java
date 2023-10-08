package com.employee.employeeManagement.dto;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) of manager, used in drop-down
 * for adding project.
 */

public class ManagerDto {
    /**
     * The name of the manager.
     */
    private String name;
    /**
     * The user ID of the manager.
     */
    private String userId;
    /**
     * Id of manager.
     */
    private Long id;

    /**
     * Get the name.
     *
     * @return The name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Set the name.
     *
     * @param nameParam The name to set.
     */
    public final void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * Get the user ID.
     *
     * @return The user ID.
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Set the user ID.
     *
     * @param userIdParam The user ID to set.
     */
    public final void setUserId(final String userIdParam) {
        this.userId = userIdParam;
    }

    /**
     * Get the ID.
     *
     * @return The ID.
     */
    public final Long getId() {
        return id;
    }

    /**
     * Set the ID.
     *
     * @param idParam The ID to set.
     */
    public final void setId(final Long idParam) {
        this.id = idParam;
    }

    /**
     * toString method for managerDto.
     * @return String value.
     */
    @Override
    public final String toString() {
        return "ManagerDto{"
                + "name='" + name + '\''
                + ", userId='" + userId + '\''
                + ", id=" + id
                + '}';
    }

    /**
     * Equals method for managerDto.
     * @param o object.
     * @return boolean value.
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ManagerDto that)) {
            return false;
        }
        return Objects.equals(getName(), that.getName())
                && Objects.equals(getUserId(), that.getUserId())
                && Objects.equals(getId(), that.getId());
    }

    /**
     * hashcode for managerDto.
     * @return int value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUserId(), getId());
    }
}
