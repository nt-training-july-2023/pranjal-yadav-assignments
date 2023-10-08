package com.employee.employeeManagement.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    @Test
    public void testToString() {
        RequestResource resource = new RequestResource();
        resource.setResourceId(1L);
        resource.setComment("Test comment");
        resource.setManagerId(2L);
        resource.setEmployeeId(3L);
        resource.setProjectId(4L);

        String expectedToString = "RequestResource{" +
                "resourceId=1, " +
                "comment='Test comment', " +
                "managerId=2, " +
                "employeeId=3, " +
                "projectId=4" +
                "}";

        assertEquals(expectedToString, resource.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        RequestResource resource1 = new RequestResource();
        resource1.setResourceId(1L);
        resource1.setComment("Test comment");
        resource1.setManagerId(2L);
        resource1.setEmployeeId(3L);
        resource1.setProjectId(4L);

        RequestResource resource2 = new RequestResource();
        resource2.setResourceId(1L);
        resource2.setComment("Test comment");
        resource2.setManagerId(2L);
        resource2.setEmployeeId(3L);
        resource2.setProjectId(4L);

        RequestResource differentResource = new RequestResource();
        differentResource.setResourceId(2L);
        differentResource.setComment("Different comment");
        differentResource.setManagerId(3L);
        differentResource.setEmployeeId(4L);
        differentResource.setProjectId(5L);

        assertEquals(resource1, resource2);
        assertEquals(resource1.hashCode(), resource2.hashCode());

        assertNotEquals(resource1, differentResource);
        assertNotEquals(resource1.hashCode(), differentResource.hashCode());
    }
}
