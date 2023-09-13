package com.employee.employeeManagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
/**
 * Data Transfer Object (DTO) for representing project information.
 */
@Getter
@Setter
@NoArgsConstructor
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

