package com.employee.employeeManagement.dto;

import lombok.Getter;
import lombok.Setter;
/**
 * Data Transfer Object (DTO) of manager, used in drop-down
 * for adding project.
 */
@Getter
@Setter
public class ManagerDto {
    /**
     * The name of the manager.
     */
    private String name;
    /**
     * The user ID of the manager.
     */
    private String userId;
}
