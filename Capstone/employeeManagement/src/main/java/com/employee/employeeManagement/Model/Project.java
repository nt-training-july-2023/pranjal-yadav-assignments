package com.employee.employeeManagement.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * Represents a Project entity in the database.
 */
@NoArgsConstructor
@Table(name = "Project")
@Entity
public class Project {
    /**
     * The unique identifier of the project.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long projectId;
    /**
     * The name of the project.
     */
    @Column
    private String projectName;
    /**
     * The manager's user ID associated with the project.
     */
    @Column
    private Long managerId;
    /**
     * The description of the project.
     */
    @Column
    private String description;
    /**
     * The start date of the project.
     */
    @Column
    private String startDate;
    /**
     * The skills required for the project.
     */
    @Column
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
    public Project(final Long projectIdParam,
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
     * Compares this Project to another object for equality
     * based on projectId.
     *
     * @param o The object to compare to this Project.
     * @return true if the objects are equal, false otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return Objects.equals(getProjectId(), project.getProjectId()) && Objects.equals(getProjectName(), project.getProjectName()) && Objects.equals(getManagerId(), project.getManagerId()) && Objects.equals(getDescription(), project.getDescription()) && Objects.equals(getStartDate(), project.getStartDate()) && Objects.equals(getSkills(), project.getSkills());
    }
    /**
     * Computes the hash code of the Project based on its projectId.
     *
     * @return The hash code value for this Project.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getProjectId(), getProjectName(), getManagerId(), getDescription(), getStartDate(), getSkills());
    }


    /**
     * Generates a string representation of the Project.
     *
     * @return A string representation of the Project.
     */
    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", managerId=" + managerId +
                ", description='" + description + '\'' +
                ", startDate='" + startDate + '\'' +
                ", skills=" + skills +
                '}';
    }
}
