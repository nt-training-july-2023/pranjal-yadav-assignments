package com.employee.employeeManagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.validation.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class UserServiceTest {

    @Mock
    private Validation validation;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testSaveEmpWithValidData() {
//        UserDto userDto = new UserDto();
//        userDto.setName("Pranjal Yadav");
//        userDto.setEmail("pranjal@nucleusteq.com");
//        userDto.setUserId("N123");
//        userDto.setContactNo(1234567890L);
//
//        when(validation.checkEmail(userDto.getEmail())).thenReturn(true);
//        when(validation.checkName(userDto.getName())).thenReturn(true);
//        when(validation.checkId(userDto.getUserId())).thenReturn(true);
//        when(validation.checkPhone(userDto.getContactNo())).thenReturn(true);
//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.STRICT);
//        when(modelMapper.map(userDto, User.class)).thenReturn(new User());
//
//        String result = userService.saveEmp(userDto);
//
//        assertEquals("John Doe", result);
//    }

//    @Test
//    public void testSaveEmpWithInvalidData() {
//        // Arrange
//        UserDto userDto = new UserDto();
//        userDto.setName("Pranjal Yadav");
//        userDto.setEmail("email@email.com");
//        userDto.setUserId("N123");
//        userDto.setContactNo(1234567890L);
//
//        when(validation.checkEmail(userDto.getEmail())).thenReturn(false);
//
//        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> userService.saveEmp(userDto)
//        );
//
//        assertEquals("Give valid credentials", exception.getMessage());
//    }
}

