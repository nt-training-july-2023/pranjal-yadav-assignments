package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.dto.AdminDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminDtoTest {
    @Test
    public void testConstructorAndGetters() {
        AdminDto adminDto = new AdminDto( "Ankita Sharma", "ankita.sharma@nucleusteq.com", "N001", "20-06-1998", "02-01-2023", "Raipur", "Head", 987654321, "Ankita@123");
        assertEquals("Ankita Sharma", adminDto.getAdminName());
        assertEquals("ankita.sharma@nucleusteq.com", adminDto.getAdminEmail());
        assertEquals("N001", adminDto.getAdminId());
        assertEquals("20-06-1998", adminDto.getAdminDob());
        assertEquals("02-01-2023", adminDto.getAdminDoj());
        assertEquals("Raipur", adminDto.getAdminLocation());
        assertEquals("Head", adminDto.getAdminDesignation());
        assertEquals(987654321, adminDto.getAdminContactNo());
        assertEquals("Ankita@123", adminDto.getPassword());
    }
    @Test
    public void testSetters() {
        AdminDto adminDTO = new AdminDto();
        adminDTO.setAdminName("Ankita Sharma");
        adminDTO.setAdminEmail("ankita.sharma@nucleusteq.com");
        adminDTO.setAdminId("N001");
        adminDTO.setAdminDob("20-06-1998");
        adminDTO.setAdminDoj("02-01-2023");
        adminDTO.setAdminLocation("Raipur");
        adminDTO.setAdminDesignation("Head");
        adminDTO.setAdminContactNo(987654321);
        adminDTO.setPassword("Ankita@123");
        assertEquals("Ankita Sharma", adminDTO.getAdminName());
        assertEquals("ankita.sharma@nucleusteq.com", adminDTO.getAdminEmail());
        assertEquals("N001", adminDTO.getAdminId());
        assertEquals("20-06-1998", adminDTO.getAdminDob());
        assertEquals("02-01-2023", adminDTO.getAdminDoj());
        assertEquals("Raipur", adminDTO.getAdminLocation());
        assertEquals("Head", adminDTO.getAdminDesignation());
        assertEquals(987654321, adminDTO.getAdminContactNo());
        assertEquals("Ankita@123", adminDTO.getPassword());
    }
}
