package com.employee.employeeManagement.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectOutDto {
    /**
     * ID of project.
     */
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

    /**
     * get manager name.
     * @return manager name.
     */
    public final String getManagerName() {
        return managerName;
    }

    /**
     * set manager name.
     * @param managerNameParam manager name.
     */
    public final void setManagerName(final String managerNameParam) {
        this.managerName = managerNameParam;
    }

    /**
     * Name of manager.
     */
    private String managerName;

    /**
     * get team.
     * @return list of team members.
     */
    public final List<String> getTeam() {
        return Collections.unmodifiableList(team);
    }

    /**
     * set team.
     * @param teamParam list of team members.
     */
    public final void setTeam(final List<String> teamParam) {
        if (teamParam != null) {
            this.team = new ArrayList<>(teamParam);
        } else {
            this.team = null;
        }
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
