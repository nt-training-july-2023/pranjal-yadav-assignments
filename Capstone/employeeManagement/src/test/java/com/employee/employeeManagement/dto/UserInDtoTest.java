package com.employee.employeeManagement.dto;

import com.employee.employeeManagement.enums.Designation;
import com.employee.employeeManagement.enums.Location;
import com.employee.employeeManagement.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class UserInDtoTest {
    private UserInDto userDto;

    @BeforeEach
    public void setUp() {
        userDto = new UserInDto();
    }

    @Test
    public void testGettersAndSetters() {
        userDto.setName("Rashmi Shukla");
        userDto.setEmail("rashmi@nucleusteq.com");
        userDto.setUserId("N1234");
        userDto.setDob("17-08-2001");
        userDto.setDoj("17-07-2023");
        userDto.setLocation(Location.INDORE);
        userDto.setDesignation(Designation.ENGINEER);
        userDto.setContactNo(1234567890L);
        userDto.setProjectId(1L);
        userDto.setRole(Role.EMPLOYEE);
        userDto.setPassword("password");
        List<String> skills = Arrays.asList("Java", "Spring", "SQL");
        userDto.setSkills(skills);
        userDto.setManagerId(101L);

        assertEquals("Rashmi Shukla", userDto.getName());
        assertEquals("rashmi@nucleusteq.com", userDto.getEmail());
        assertEquals("N1234", userDto.getUserId());
        assertEquals("17-08-2001", userDto.getDob());
        assertEquals("17-07-2023", userDto.getDoj());
        assertEquals(Location.INDORE, userDto.getLocation());
        assertEquals(Designation.ENGINEER, userDto.getDesignation());
        assertEquals(1234567890L, userDto.getContactNo());
        assertEquals(1L, userDto.getProjectId());
        assertEquals(Role.EMPLOYEE, userDto.getRole());
        assertEquals("password", userDto.getPassword());
        assertEquals(skills, userDto.getSkills());
        assertEquals(101L, userDto.getManagerId());

    }
    @Test
    public void testToString() {

        UserInDto employee = new UserInDto();
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        employee.setSkills(skills);
        employee.setName("Pranjal Yadav");
        employee.setEmail("pranjal@example.com");
        employee.setUserId("pranjal123");
        employee.setDob("2001-08-17");
        employee.setDoj("2023-07-17");
        employee.setLocation(Location.RAIPUR);
        employee.setDesignation(Designation.ENGINEER);
        employee.setContactNo(9087654321L);
        employee.setProjectId(2L);
        employee.setRole(Role.EMPLOYEE);
        employee.setManagerId(3L);

        String expectedToString = "UserInDto{" +
                "name='Pranjal Yadav', " +
                "email='pranjal@example.com', " +
                "userId='pranjal123', " +
                "dob='2001-08-17', " +
                "doj='2023-07-17', " +
                "location=RAIPUR, " +
                "designation=ENGINEER, " +
                "contactNo=9087654321, " +
                "projectId=2, " +
                "role=EMPLOYEE, " +
                "password='null', " +
                "skills=[Java, React], " +
                "managerId=3" +
                "}";
        assertEquals(expectedToString, employee.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        UserInDto user1 = new UserInDto();
        user1.setName("John");
        user1.setEmail("john@example.com");
        user1.setUserId("johndoe");
       user1.setSkills(skills);

        UserInDto user2 = new UserInDto();
        user2.setName("John");
        user2.setEmail("john@example.com");
        user2.setUserId("johndoe");
user2.setSkills(skills);
        UserInDto differentUser = new UserInDto();
        differentUser.setName("Alice");
        differentUser.setEmail("alice@example.com");
        differentUser.setUserId("alicedoe");
        differentUser.setSkills(skills);
        // Set other fields as needed...

        assertThat(user1).isEqualTo(user2);
        assertThat(user1.hashCode()).isEqualTo(user2.hashCode());

        assertThat(user1).isNotEqualTo(differentUser);
        assertThat(user1.hashCode()).isNotEqualTo(differentUser.hashCode());
    }
}
