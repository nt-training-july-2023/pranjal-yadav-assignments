package com.employee.employeeManagement.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestResourceOutDtoTest {
    @Test
    public void testToString() {
        RequestResourceOutDto dto = new RequestResourceOutDto();
        dto.setResourceId(1L);
        dto.setComment("Sample comment");
        dto.setManagerId(2L);
        dto.setEmployeeId(3L);
        dto.setProjectId(4L);
        dto.setProjectName("Fyndr");
        dto.setEmployeeName("Pranjal Yadav");
        dto.setManagerName("Vanshika Sharma");
        dto.setEmployeeUserId("N1001");
        dto.setManagerUserId("N6272");

        String expected = "RequestResourceOutDto{" +
                "resourceId=1, comment='Sample comment', managerId=2, " +
                "employeeId=3, projectId=4, projectName='Fyndr', " +
                "employeeName='Pranjal Yadav', managerName='Vanshika Sharma'," +
                " " +
                "employeeUserId='N1001', managerUserId='N6272'}";

        assertEquals(expected, dto.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        RequestResourceOutDto dto1 = new RequestResourceOutDto();
        dto1.setResourceId(1L);
        dto1.setComment("Sample comment");
        dto1.setManagerId(2L);
        dto1.setEmployeeId(3L);
        dto1.setProjectId(4L);
        dto1.setProjectName("Fyndr");
        dto1.setEmployeeName("Pranjal Yadav");
        dto1.setManagerName("Vanshika Sharma");
        dto1.setEmployeeUserId("N1001");
        dto1.setManagerUserId("N6272");

        RequestResourceOutDto dto2 = new RequestResourceOutDto();
        dto2.setResourceId(1L);
        dto2.setComment("Sample comment");
        dto2.setManagerId(2L);
        dto2.setEmployeeId(3L);
        dto2.setProjectId(4L);
        dto2.setProjectName("Fyndr");
        dto2.setEmployeeName("Pranjal Yadav");
        dto2.setManagerName("Vanshika Sharma");
        dto2.setEmployeeUserId("N1001");
        dto2.setManagerUserId("N6272");
        assertTrue(dto1.equals(dto2));

        assertEquals(dto1.hashCode(), dto2.hashCode());

        dto2.setComment("Modified comment");

        assertFalse(dto1.equals(dto2));
    }
}
