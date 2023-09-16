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
    /**
     * Id of manager.
     */
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
