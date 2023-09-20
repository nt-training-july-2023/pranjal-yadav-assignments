package com.employee.employeeManagement.outDtos;

/**
 * Data Transfer Object (DTO) representing a user's name.
 */
public class UserNameDto {
    /**
     * Name of the user.
     */
    private String name;
    /**
     * Get the name of the user.
     *
     * @return The user's name.
     */
    public final String getName() {
        return name;
    }
    /**
     * Set the name of the user.
     *
     * @param nameParam The user's name.
     */
    public final void setName(final String nameParam) {
        this.name = nameParam;
    }
}
