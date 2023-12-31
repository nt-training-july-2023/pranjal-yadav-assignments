package com.employee.employeeManagement.dto;

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
    public String getName() {
        return name;
    }
    /**
     * Set the name of the user.
     *
     * @param nameParam The user's name.
     */
    public void setName(final String nameParam) {
        this.name = nameParam;
    }
}
