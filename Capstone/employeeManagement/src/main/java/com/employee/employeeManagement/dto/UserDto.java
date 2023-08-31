package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.Model.Designation;
import com.employee.employeeManagement.Model.Location;
import com.employee.employeeManagement.Model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String userId;
    private String dob;
    private String doj;
    private Location location;
    private Designation designation;
    private String projectName;
    private Role role;
    private String password;
}
