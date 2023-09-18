package com.employee.employeeManagement.dto;

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


}
