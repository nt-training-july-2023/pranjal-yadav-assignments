package com.employee.employeeManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {

    private String admin_name;
    private String admin_email;
    private long id;
    private String admin_DOB;
    private String admin_DOJ;

    private String admin_location;
    private String admin_designation;

    private long admin_contact_no;
    private String password;

}
