package com.employee.employeeManagement.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Project entity in the database.
 */
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

    /**
     * Default constructor for the Project class.
     */
    public Project() {
    }


    /**
     * Computes the hash code of the Project based on its projectId.
     *
     * @return The hash code value for this Project.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getProjectId(), getProjectName(),
                getManagerId(), getDescription(), getStartDate(),
                getSkills());
    }
    /**
     * equals.
     * @param obj object
     * @return boolean
     */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Project other = (Project) obj;
        return Objects.equals(description, other.description)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(projectId, other.projectId)
                && Objects.equals(projectName, other.projectName)
                && Objects.equals(skills, other.skills)
                && Objects.equals(startDate, other.startDate);
    }


    /**
     * Generates a string representation of the Project.
     *
     * @return A string representation of the Project.
     */
    @Override
    public final String toString() {
        return "Project{"
                + "projectId=" + projectId
                + ", projectName='" + projectName + '\''
                + ", managerId=" + managerId
                + ", description='" + description + '\''
                + ", startDate='" + startDate + '\''
                + ", skills=" + skills + '}';
    }



}
