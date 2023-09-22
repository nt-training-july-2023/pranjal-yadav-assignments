package com.employee.employeeManagement.outDtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectOutDto {
    private Long projectId;
    /**
     * The name of the project.
     */
    private String projectName;
    /**
     * The manager's user ID associated with the project.
     */
    private Long managerId;
    /**
     * The description of the project.
     */
    private String description;
    /**
     * The start date of the project.
     */
    private String startDate;
    /**
     * The skills required for the project.
     */
    private List<String> skills;

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    private String managerName;

    public List<String> getTeam() {
        return team;
    }

    public void setTeam(List<String> team) {
        this.team = team;
    }

    /**
     * The team which is working on the project.
     */
    private List<String> team;

    /**
     * Get the project ID.
     *
     * @return The project ID.
     */
    public final Long getProjectId() {
        return projectId;
    }

    /**
     * Set the project ID.
     *
     * @param projectIdParam The project ID to set.
     */
    public final void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * Get the project name.
     *
     * @return The project name.
     */
    public final String getProjectName() {
        return projectName;
    }

    /**
     * Set the project name.
     *
     * @param projectNameParam The project name to set.
     */
    public final void setProjectName(final String projectNameParam) {
        this.projectName = projectNameParam;
    }

    /**
     * Get the manager's user ID associated with the project.
     *
     * @return The manager's user ID.
     */
    public final Long getManagerId() {
        return managerId;
    }

    /**
     * Set the manager's user ID associated with the project.
     *
     * @param managerIdParam The manager's user ID to set.
     */
    public final void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * Get the description of the project.
     *
     * @return The description.
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Set the description of the project.
     *
     * @param descriptionParam The description to set.
     */
    public final void setDescription(final String descriptionParam) {
        this.description = descriptionParam;
    }

    /**
     * Get the start date of the project.
     *
     * @return The start date.
     */
    public final String getStartDate() {
        return startDate;
    }

    /**
     * Set the start date of the project.
     *
     * @param startDateParam The start date to set.
     */
    public final void setStartDate(final String startDateParam) {
        this.startDate = startDateParam;
    }

    /**
     * Get the list of skills required for the project.
     *
     * @return The list of skills.
     */
    public final List<String> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    /**
     * Set the list of skills required for the project.
     *
     * @param skillsParam The list of skills to set.
     */
    public final void setSkills(final List<String> skillsParam) {
        if (skillsParam != null) {
            this.skills = new ArrayList<>(skillsParam);
        } else {
            this.skills = null;
        }
    }
}
