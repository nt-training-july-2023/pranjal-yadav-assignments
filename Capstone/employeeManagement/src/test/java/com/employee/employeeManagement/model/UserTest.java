package com.employee.employeeManagement.model;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setId(1L);
        user.setName("Rashmi Shukla");
        user.setEmail("rashmi@nucleusteq.com");
        user.setUserId("N1000");
        user.setDob("17-08-2001");
        user.setDoj("17-07-2023");
        user.setLocation(Location.INDORE);
        user.setDesignation(Designation.SENIOR_ENGINEER);
        user.setContactNo(1234567890L);
        user.setProjectId(1L);
        user.setRole(Role.EMPLOYEE);
        user.setPassword("N1000@17082001");
        user.setSkills(Collections.singletonList("Java"));
        user.setManagerId(4L);

        assertEquals(1L, user.getId());
        assertEquals("Rashmi Shukla", user.getName());
        assertEquals("rashmi@nucleusteq.com", user.getEmail());
        assertEquals("N1000", user.getUserId());
        assertEquals("17-08-2001", user.getDob());
        assertEquals("17-07-2023", user.getDoj());
        assertEquals(Location.INDORE, user.getLocation());
        assertEquals(Designation.SENIOR_ENGINEER, user.getDesignation());
        assertEquals(1234567890L, user.getContactNo());
        assertEquals(1L, user.getProjectId());
        assertEquals(Role.EMPLOYEE, user.getRole());
        assertEquals("N1000@17082001", user.getPassword());
        assertEquals(Collections.singletonList("Java"), user.getSkills());
        assertEquals(4L, user.getManagerId());
    }
    @Test
    public void testToString() {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setUserId("johndoe123");
        user.setDob("2000-01-01");
        user.setDoj("2023-01-01");
        user.setLocation(Location.RAIPUR);
        user.setDesignation(Designation.ENGINEER);
        user.setContactNo(1234567890L);
        user.setProjectId(1L);
        user.setRole(Role.EMPLOYEE);
        user.setPassword("password123");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Spring");
        user.setSkills(skills);
        user.setManagerId(2L);

        String expectedToString = "User{" +
                "id=1, " +
                "name='John Doe', " +
                "email='john.doe@example.com', " +
                "userId='johndoe123', " +
                "dob='2000-01-01', " +
                "doj='2023-01-01', " +
                "location=RAIPUR, " +
                "designation=ENGINEER, " +
                "contactNo=1234567890, " +
                "projectId=1, " +
                "role=EMPLOYEE, " +
                "password='password123', " +
                "skills=[Java, Spring], " +
                "managerId=2" +
                "}";

        assertEquals(expectedToString, user.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Ankita Sharma");
        user1.setEmail("ankita@nucleusteq.com");
        user1.setUserId("N1111");
        user1.setDob("2000-01-01");
        user1.setDoj("2023-01-01");
        user1.setLocation(Location.RAIPUR);
        user1.setDesignation(Designation.ENGINEER);
        user1.setContactNo(1234567890L);
        user1.setProjectId(1L);
        user1.setRole(Role.EMPLOYEE);
        user1.setPassword("password123");
        List<String> skills1 = new ArrayList<>();
        skills1.add("Java");
        skills1.add("Spring");
        user1.setSkills(skills1);
        user1.setManagerId(2L);

        User user2 = new User();
        user2.setId(1L);
        user2.setName("Ankita Sharma");
        user2.setEmail("ankita@nucleusteq.com");
        user2.setUserId("N1111");
        user2.setDob("2000-01-01");
        user2.setDoj("2023-01-01");
        user2.setLocation(Location.RAIPUR);
        user2.setDesignation(Designation.ENGINEER);
        user2.setContactNo(1234567890L);
        user2.setProjectId(1L);
        user2.setRole(Role.EMPLOYEE);
        user2.setPassword("password123");
        user2.setSkills(skills1);
        user2.setManagerId(2L);

        User differentUser = new User();
        differentUser.setId(2L);
        differentUser.setName("Ankit Kothana");
        differentUser.setEmail("ankit@example.com");
        differentUser.setUserId("ankit123@");
        differentUser.setDob("1990-01-01");
        differentUser.setDoj("2022-01-01");
        differentUser.setLocation(Location.RAIPUR);
        differentUser.setDesignation(Designation.SENIOR_ENGINEER);
        differentUser.setContactNo(9876543210L);
        differentUser.setProjectId(2L);
        differentUser.setRole(Role.MANAGER);
        differentUser.setPassword("password456");
        List<String> differentSkills = new ArrayList<>();
        differentSkills.add("Python");
        differentSkills.add("Django");
        differentUser.setSkills(differentSkills);
        differentUser.setManagerId(3L);

        Project project1 = new Project();
        project1.setProjectId(1L);
        project1.setProjectName("Project 1");
        skills1.add("Java");
        skills1.add("React");
        project1.setSkills(skills1);

        assertEquals(user1.equals(user1), user2.equals(user2));
        assertEquals(user1, user1);
        assertNotEquals(user1, project1);


        assertEquals(user1.hashCode(), user2.hashCode());

        assertNotEquals(user1, differentUser);
        assertNotEquals(user1.hashCode(), differentUser.hashCode());
    }
}


