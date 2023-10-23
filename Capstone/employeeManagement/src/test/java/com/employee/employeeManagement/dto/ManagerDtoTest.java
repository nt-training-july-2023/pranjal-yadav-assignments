package com.employee.employeeManagement.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("react");
        UserInDto user = new UserInDto();
        user.setName("Pranjal");
        user.setSkills(skills);
        user.setUserId("N7281");
        user.setContactNo(9876543210L);

        assertTrue(manager1.equals(manager2));
        assertEquals(manager1, manager1);
        assertNotEquals(manager1, user);

        assertEquals(manager1.hashCode(), manager2.hashCode());

        manager2.setUserId("N8888");

        assertFalse(manager1.equals(manager2));
    }
}
