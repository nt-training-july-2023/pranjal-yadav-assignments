package com.employee.employeeManagement.Model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

/**
 * Represents a user.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
public class User {
    /**
     * Id of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The name of the user.
     */
    @Column
    private String name;

    /**
     * The email address of the user (must be unique).
     */
    @Column(unique = true)
    private String email;

    /**
     * The user ID of the user (must be unique).
     */
    @Column(unique = true)
    private String userId;

    /**
     * The date of birth (DOB) of the user.
     */
    @Column
    private String dob;

    /**
     * The date of joining (DOJ) of the user.
     */
    @Column
    private String doj;

    /**
     * The location where the user is based.
     */
    @Enumerated(EnumType.STRING)
    private Location location;

    /**
     * The designation or job title of the user.
     */
    @Enumerated(EnumType.STRING)
    private Designation designation;

    /**
     * The contact number of the user.
     */
    private long contactNo;

    /**
     * The name of the project associated with the user.
     */
    @Column
    private String projectId;

    /**
     * The role of the user within the organization.
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * The password associated with the user.
     */
    @Column
    private String password;

    /**
     * The skills or expertise possessed by the user.
     */
    @Column
    private String skills;

    /**
     * The name of the manager of user.
     */
    @Column
    private String managerId;
}

