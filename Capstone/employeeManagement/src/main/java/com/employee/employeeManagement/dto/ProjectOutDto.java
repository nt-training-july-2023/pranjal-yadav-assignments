package com.employee.employeeManagement.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
    public String getManagerName() {
        return managerName;
    }

    /**
     * set manager name.
     * @param managerNameParam manager name.
     */
    public void setManagerName(final String managerNameParam) {
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
    public List<String> getTeam() {
        return Collections.unmodifiableList(team);
    }

    /**
     * set team.
     * @param teamParam list of team members.
     */
    public void setTeam(final List<String> teamParam) {
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
    public Long getProjectId() {
        return projectId;
    }

    /**
     * Set the project ID.
     *
     * @param projectIdParam The project ID to set.
     */
    public void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * Get the project name.
     *
     * @return The project name.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Set the project name.
     *
     * @param projectNameParam The project name to set.
     */
    public void setProjectName(final String projectNameParam) {
        this.projectName = projectNameParam;
    }

    /**
     * Get the manager's user ID associated with the project.
     *
     * @return The manager's user ID.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * Set the manager's user ID associated with the project.
     *
     * @param managerIdParam The manager's user ID to set.
     */
    public void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * Get the description of the project.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the project.
     *
     * @param descriptionParam The description to set.
     */
    public void setDescription(final String descriptionParam) {
        this.description = descriptionParam;
    }

    /**
     * Get the start date of the project.
     *
     * @return The start date.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Set the start date of the project.
     *
     * @param startDateParam The start date to set.
     */
    public void setStartDate(final String startDateParam) {
        this.startDate = startDateParam;
    }

    /**
     * Get the list of skills required for the project.
     *
     * @return The list of skills.
     */
    public List<String> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    /**
     * Set the list of skills required for the project.
     *
     * @param skillsParam The list of skills to set.
     */
    public void setSkills(final List<String> skillsParam) {
        if (skillsParam != null) {
            this.skills = new ArrayList<>(skillsParam);
        } else {
            this.skills = null;
        }
    }

    /**
     * toString method for ProjectOutDto.
     *
     * @return String.
     */
    @Override
    public final String toString() {
        return "ProjectOutDto{"
                + "projectId=" + projectId
                + ", projectName='" + projectName + '\''
                + ", managerId=" + managerId
                + ", description='" + description + '\''
                + ", startDate='" + startDate + '\''
                + ", skills=" + skills
                + ", managerName='" + managerName + '\''
                + ", team=" + team
                + '}';
    }

    /**
     * Equals method for projectOutDto class.
     * @param o Object o.
     * @return boolean value.
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProjectOutDto that)) {
            return false;
        }
        return Objects.equals(getProjectId(), that.getProjectId())
                && Objects.equals(getProjectName(), that.getProjectName())
                && Objects.equals(getManagerId(), that.getManagerId())
                && Objects.equals(getDescription(), that.getDescription())
                && Objects.equals(getStartDate(), that.getStartDate())
                && Objects.equals(getSkills(), that.getSkills())
                && Objects.equals(getManagerName(), that.getManagerName())
                && Objects.equals(getTeam(), that.getTeam());
    }

    /**
     * Hashcode method for ProjectOutDto.
     * @return int value.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getProjectId(), getProjectName(), getManagerId(),
                getDescription(), getStartDate(), getSkills(),
                getManagerName(), getTeam());
    }
}
