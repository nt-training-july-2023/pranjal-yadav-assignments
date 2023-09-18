package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.dto.ManagerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerDtoTest {
    private ManagerDto managerDto;

    @BeforeEach
    public void setUp() {
        managerDto = new ManagerDto();
    }

    @Test
    public void testGettersAndSetters() {
        managerDto.setName("Vanshika Sharma");
        managerDto.setUserId("N1001");
        managerDto.setId(1L);

        assertEquals("Vanshika Sharma", managerDto.getName());
        assertEquals("N1001", managerDto.getUserId());
        assertEquals(1L, managerDto.getId());


    }
}
