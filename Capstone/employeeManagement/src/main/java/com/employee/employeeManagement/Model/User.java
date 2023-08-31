package com.employee.employeeManagement.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String userId;
    @Column
    private String dob;
    @Column
    private String doj;
    @Enumerated(EnumType.STRING)
    private Location location;
    @Enumerated(EnumType.STRING)
    private Designation designation;
    @Column
    private String projectName;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column
    private String password;

}
