package com.employee.employeeManagement.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Project entity in the database.
 */
@Getter
@Setter
@AllArgsConstructor
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
    private String managerId;
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
    private String skills;

}
