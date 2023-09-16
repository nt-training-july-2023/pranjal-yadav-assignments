package com.employee.employeeManagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
/**
 * Data Transfer Object (DTO) for representing project information.
 */

public class ProjectDto {
    /**
     * The unique identifier of the project.
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
     * The list of skills required for the project.
     */
    private List<String> skills;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    /**
     * All arguments constructor.
     *
     * @param projectIdParam   The unique identifier of the project.
     * @param projectNameParam The name of the project.
     * @param managerIdParam   The manager's user
     *                         ID associated with the project.
     * @param descriptionParam The description of the project.
     * @param startDateParam   The start date of the project.
     * @param skillsParam      The list of skills required for the project.
     */
    public ProjectDto(final Long projectIdParam,
                      final String projectNameParam,
                      final Long managerIdParam, final String descriptionParam,
                      final String startDateParam,
                      final List<String> skillsParam) {
        this.projectId = projectIdParam;
        this.projectName = projectNameParam;
        this.managerId = managerIdParam;
        this.description = descriptionParam;
        this.startDate = startDateParam;
        this.skills = skillsParam;
    }
}

