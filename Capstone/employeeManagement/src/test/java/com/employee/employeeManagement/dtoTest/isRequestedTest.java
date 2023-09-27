package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.dto.IsRequested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class isRequestedTest {
    @Test
    public void testGetEmployeeId() {
        IsRequested isRequested = new IsRequested();
        Long expectedEmployeeId = 3L;
        isRequested.setEmployeeId(expectedEmployeeId);
        Long actualEmployeeId = isRequested.getEmployeeId();
        assertEquals(expectedEmployeeId, actualEmployeeId);
    }

    @Test
    public void testGetManagerEmail() {
        IsRequested isRequested = new IsRequested();
        String expectedManagerEmail = "vanshika@nucleusteq.com";
        isRequested.setManagerEmail(expectedManagerEmail);
        String actualManagerEmail = isRequested.getManagerEmail();
        assertEquals(expectedManagerEmail, actualManagerEmail);
    }

    @Test
    public void testSetEmployeeId() {
        IsRequested isRequested = new IsRequested();
        Long expectedEmployeeId = 1L;
        isRequested.setEmployeeId(expectedEmployeeId);
        Long actualEmployeeId = isRequested.getEmployeeId();
        assertEquals(expectedEmployeeId, actualEmployeeId);
    }

    @Test
    public void testSetManagerEmail() {
        IsRequested isRequested = new IsRequested();
        String expectedManagerEmail = "anjali@nucleusteq.com";
        isRequested.setManagerEmail(expectedManagerEmail);
        String actualManagerEmail = isRequested.getManagerEmail();
        assertEquals(expectedManagerEmail, actualManagerEmail);
    }
}
