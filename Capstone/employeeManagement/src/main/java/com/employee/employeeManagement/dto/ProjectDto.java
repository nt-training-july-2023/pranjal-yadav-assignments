package com.employee.employeeManagement.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor

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
    private String managerId;
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
}
