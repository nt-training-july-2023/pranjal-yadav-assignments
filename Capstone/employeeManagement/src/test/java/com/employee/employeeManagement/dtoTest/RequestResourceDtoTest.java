package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.dto.RequestResourceDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RequestResourceDtoTest {
    @Test
    void testGetSetComment() {
        RequestResourceDto dto = new RequestResourceDto();
        assertNull(dto.getComment());

        String comment = "Sample Comment";
        dto.setComment(comment);
        assertEquals(comment, dto.getComment());
    }

    @Test
    void testGetSetManagerId() {
        RequestResourceDto dto = new RequestResourceDto();
        assertNull(dto.getManagerId());
        Long managerId = 1L;
        dto.setManagerId(managerId);
        assertEquals(managerId, dto.getManagerId());
    }

    @Test
    void testGetSetEmployeeId() {
        RequestResourceDto dto = new RequestResourceDto();
        assertNull(dto.getEmployeeId());

        Long employeeId = 2L;
        dto.setEmployeeId(employeeId);
        assertEquals(employeeId, dto.getEmployeeId());
    }

    @Test
    void testGetSetProjectId() {
        RequestResourceDto dto = new RequestResourceDto();
        assertNull(dto.getProjectId());

        Long projectId = 3L;
        dto.setProjectId(projectId);
        assertEquals(projectId, dto.getProjectId());
    }
}
