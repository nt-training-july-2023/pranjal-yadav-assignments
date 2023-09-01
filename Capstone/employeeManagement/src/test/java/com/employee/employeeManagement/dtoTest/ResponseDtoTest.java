package com.employee.employeeManagement.dtoTest;

import com.employee.employeeManagement.dto.ResponseEntityDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseDtoTest {
    @Test
    public void testConstructorsAndGetters(){
        ResponseEntityDto responseEntityDto = new ResponseEntityDto(true, "Successful");
        assertEquals(true, responseEntityDto.getIsSuccess());
        assertEquals("Successful", responseEntityDto.getMessage());
    }
    @Test
    public void testSetters(){
        ResponseEntityDto responseEntityDto= new ResponseEntityDto();
        responseEntityDto.setSuccess(true);
        responseEntityDto.setMessage("Successful");
        assertEquals(true, responseEntityDto.getIsSuccess());
        assertEquals("Successful", responseEntityDto.getMessage());
    }
}
