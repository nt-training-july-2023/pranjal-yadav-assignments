//package com.employee.employeeManagement.Model;
//
//import com.employee.employeeManagement.Model.Designation;
//import com.employee.employeeManagement.Model.Location;
//import com.employee.employeeManagement.Model.Role;
//import com.employee.employeeManagement.Model.User;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class UserTest {
//    @Test
//    public void testConstructorAndGetters(){
//        User user = new User(1, "ankita sharma",
//                "ankita@nucleusteq.com",
//                "N123",
//                "20-12-1990",
//                "20-12-2014",
//                Location.BANGALORE,
//                Designation.RECRUITER,
//                1234567890L,
//                "Nuodata",
//                Role.ADMIN,
//                "12345"
//                );
//        assertEquals("ankita sharma", user.getName());
//        assertEquals("ankita@nucleusteq.com", user.getEmail());
//        assertEquals("N123", user.getUserId());
//        assertEquals("20-12-1990", user.getDob());
//        assertEquals("20-12-2014", user.getDoj());
//        assertEquals(Location.BANGALORE,user.getLocation());
//        assertEquals(Designation.RECRUITER, user.getDesignation());
//        assertEquals(1234567890, user.getContactNo());
//        assertEquals("Nuodata", user.getProjectName());
//        assertEquals(Role.ADMIN, user.getRole());
//        assertEquals("12345", user.getPassword());
//    }
//    public void testSetters(){
//        User user = new User();
//        user.setId(1);
//        user.setName("ankita sharma");
//        user.setEmail("ankita@nucleusteq.com");
//        user.setUserId("N123");
//        user.setDob("20-12-1990");
//        user.setDoj("20-12-2914");
//        user.setLocation(Location.BANGALORE);
//        user.setDesignation(Designation.RECRUITER);
//        user.setContactNo(1234567890);
//        user.setProjectName("Nuodata");
//        user.setRole(Role.ADMIN);
//        user.setPassword("12345");
//
//        assertEquals("ankita sharma", user.getName());
//        assertEquals("ankita@nucleusteq.com", user.getEmail());
//        assertEquals("N123", user.getUserId());
//        assertEquals("20-12-1990", user.getDob());
//        assertEquals("20-12-2014", user.getDoj());
//        assertEquals(Location.BANGALORE,user.getLocation());
//        assertEquals(Designation.RECRUITER, user.getDesignation());
//        assertEquals(1234567890, user.getContactNo());
//        assertEquals("Nuodata", user.getProjectName());
//        assertEquals(Role.ADMIN, user.getRole());
//        assertEquals("12345", user.getPassword());
//    }
//}
//
//
