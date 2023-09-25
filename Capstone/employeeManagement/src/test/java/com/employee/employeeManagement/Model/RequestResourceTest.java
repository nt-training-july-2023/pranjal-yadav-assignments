package com.employee.employeeManagement.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestResourceTest {
    private RequestResource requestResource;

    @BeforeEach
    public void setUp() {
        requestResource = new RequestResource();
    }

    @Test
    public void testResourceIdGetterSetter() {
        requestResource.setResourceId(1L);

        assertEquals(1L, requestResource.getResourceId());
    }

    @Test
    public void testCommentGetterSetter() {
        requestResource.setComment("Test comment");

        assertEquals("Test comment", requestResource.getComment());
    }

    @Test
    public void testManagerIdGetterSetter() {
        requestResource.setManagerId(101L);

        assertEquals(101L, requestResource.getManagerId());
    }

    @Test
    public void testEmployeeIdGetterSetter() {
        requestResource.setEmployeeId(201L);

        assertEquals(201L, requestResource.getEmployeeId());
    }

    @Test
    public void testProjectIdGetterSetter() {
        requestResource.setProjectId(301L);
        assertEquals(301L, requestResource.getProjectId());
    }
}
