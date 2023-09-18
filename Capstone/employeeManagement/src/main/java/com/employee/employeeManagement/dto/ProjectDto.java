package com.employee.employeeManagement.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Data Transfer Object (DTO) for representing project information.
 */

public class ProjectDto {
    /**
     * The unique identifier of the project.
     */
    @NotNull
    private Long projectId;

    /**
     * The name of the project.
     */
    @NotBlank
    private String projectName;
    /**
     * The manager's user ID associated with the project.
     */
    @NotNull
    private Long managerId;
    /**
     * The description of the project.
     */
    @NotBlank
    private String description;
    /**
     * The start date of the project.
     */
    @NotBlank
    private String startDate;
    /**
     * The list of skills required for the project.
     */
    private List<String> skills;

    /**
     * Get the unique identifier of the project.
     *
     * @return The unique identifier of the project.
     */
    public final Long getProjectId() {
        return projectId;
    }

    /**
     * Set the unique identifier of the project.
     *
     * @param projectIdParam The unique identifier of the project.
     */
    public final void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * Get the name of the project.
     *
     * @return The name of the project.
     */
    public final String getProjectName() {
        return projectName;
    }

    /**
     * Set the name of the project.
     *
     * @param projectNameParam The name of the project.
     */
    public final void setProjectName(final String projectNameParam) {
        this.projectName = projectNameParam;
    }

    /**
     * Get the manager's id.
     *
     * @return The manager's user ID associated with the project.
     */
    public final Long getManagerId() {
        return managerId;
    }

    /**
     * Set the manager's id.
     *
     * @param managerIdParam The manager's user ID associated with the project.
     */
    public final void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * Get the description of the project.
     *
     * @return The description of the project.
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Set the description of the project.
     *
     * @param descriptionParam The description of the project.
     */
    public final void setDescription(final String descriptionParam) {
        this.description = descriptionParam;
    }

    /**
     * Get the start date of the project.
     *
     * @return The start date of the project.
     */
    public final String getStartDate() {
        return startDate;
    }

    /**
     * Set the start date of the project.
     *
     * @param startDateParam The start date of the project.
     */
    public final void setStartDate(final String startDateParam) {
        this.startDate = startDateParam;
    }

    /**
     * Get the list of skills required for the project.
     *
     * @return The list of skills required for the project.
     */
    public final List<String> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    /**
     * Set the list of skills required for the project.
     *
     * @param skillsParam The list of skills required for the project.
     */
    public final void setSkills(final List<String> skillsParam) {
        if (skillsParam != null) {
            this.skills = new ArrayList<>(skillsParam);
        } else {
            this.skills = null;
        }
    }


}

