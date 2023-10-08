package com.employee.employeeManagement.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void testToString() {
        ManagerDto manager = new ManagerDto();
        manager.setName("Vanshika Sharma");
        manager.setId(9L);
        manager.setUserId("N7171");
        String expected = "ManagerDto{name='Vanshika Sharma', " +
                "userId='N7171', id=9}";
        assertEquals(expected, manager.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
        ManagerDto manager1 = new ManagerDto();
        ManagerDto manager2 = new ManagerDto();
        manager1.setName("Vanshika Sharma");
        manager1.setId(9L);
        manager1.setUserId("N7171");

        manager2.setName("Vanshika Sharma");
        manager2.setId(9L);
        manager2.setUserId("N7171");

        // Test equals() method
        assertTrue(manager1.equals(manager2));

        // Test hashCode() method
        assertEquals(manager1.hashCode(), manager2.hashCode());

        // Modify one property in manager2
        manager2.setUserId("N8888");

        // Test equals() method after modifying a property
        assertFalse(manager1.equals(manager2));
    }
}
