package com.employee.employeeManagement.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestResourceDtoTest {
    @Test
    void testGetSetComment() {
        RequestResourceDto dto = new RequestResourceDto();
        assertNull(dto.getComment());

        String comment = "Comment Comment";
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
    @Test
    public void testEqualsAndHashCode() {
        // Create two RequestResourceDto objects with the same property values
        RequestResourceDto request1 = new RequestResourceDto();
        RequestResourceDto request2 = new RequestResourceDto();
        request1.setComment("Comment");
        request1.setManagerId(3L);
        request1.setEmployeeId(1L);
        request1.setProjectId(2L);

        request2.setComment("Comment");
        request2.setManagerId(3L);
        request2.setEmployeeId(1L);
        request2.setProjectId(2L);

        assertTrue(request1.equals(request2));

        assertEquals(request1.hashCode(), request2.hashCode());

        request2.setComment("Comment2");

        assertFalse(request1.equals(request2));
    }
}
