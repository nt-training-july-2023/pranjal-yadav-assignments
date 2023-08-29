package com.employee.employeeManagement.Model;

import jakarta.persistence.*;
import lombok.Data;


/**
 * Represents the admin in the project.
 */
@Entity
@Table(name = "admin")
@Data
public class Admin {

    /**
     * The unique ID of the admin.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The name of the admin.
     */
    @Column
    private String adminName;

    /**
     * The email address of the admin.
     */
    @Column
    private String adminEmail;

    /**
     * The unique identifier of the admin.
     */
    @Column
    private String adminId;

    /**
     * The date of birth of the admin.
     */
    @Column
    private String adminDob;

    /**
     * The date of joining of the admin.
     */
    @Column
    private String adminDoj;

    /**
     * The location of the admin.
     */
    @Column
    private String adminLocation;

    /**
     * The designation of the admin.
     */
    @Column
    private String adminDesignation;

    /**
     * The contact number of the admin.
     */
    @Column
    private long adminContactNo;

    /**
     * The password associated with the admin's account.
     */
    @Column
    private String password;

}
