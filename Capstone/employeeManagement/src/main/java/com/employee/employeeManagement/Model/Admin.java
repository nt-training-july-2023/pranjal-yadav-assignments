package com.employee.employeeManagement.Model;

import jakarta.persistence.*;
import lombok.*;

//@NoArgsConstructor
//@Getter
//@Setter
//@AllArgsConstructor
@Entity
@Table(name="admin")
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String admin_name;

    @Column
    private String admin_email;

    @Column
    private String admin_id;

    @Column
    private String admin_DOB;

    @Column
    private String admin_DOJ;

    @Column
    private String admin_location;

    @Column
    private String admin_designation;

    @Column
    private long admin_contact_no;

    @Column
    private String password;

}
