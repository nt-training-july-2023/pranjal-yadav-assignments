package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.dto.EmployeeOutDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.dto.UserNameDto;
import com.employee.employeeManagement.exception.ResourceAlreadyExistsException;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ApiResponse;
import com.employee.employeeManagement.validation.Validation;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Service class that handles operations related to users.
 */
@Service
public class UserService {
    /**
     * UserRepository autowired for adding to database.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * ModelMapper autowired to map dto to entity and vice versa.
     */
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProjectRepository projectRepository;
    /**
     * PasswordEncoder autowired to encode password.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * Validation autowired to validate parameters.
     */
    @Autowired
    private Validation validation;
    /**
     * Decodes a Base64-encoded password string.
     *
     * @param pwd The Base64-encoded password.
     * @return The decoded password string.
     */
    public static String decodePassword(final String pwd) {
        byte[] decodedBytes = Base64.getDecoder().decode(pwd);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
    /**
     * Adds a new user.
     *
     * @param userDto The user details to be added.
     * @return The added user details.
     */
    public final ApiResponse addUser(final UserDto userDto) {
        if (validation.checkUser(userDto)) {
            modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.STRICT);
            User user = this.modelMapper.map(userDto, User.class);
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                throw new ResourceAlreadyExistsException(
                        "This email id already exists");
            }
            userRepository.save(user);
            return new ApiResponse("Admin Added successfully", user.getRole());
        } else {
            return new ApiResponse("Invalid Credentials", null);
        }

    }
    /**
     * Performs user login and returns the login DTO if successful.
     *
     * @param loginDto The login details.
     * @return The login DTO if successful, otherwise null.
     */
    public final User login(final LoginDto loginDto) {

        User user = userRepository.
                findByEmail(loginDto.getEmail()).orElseThrow(() -> new
                        ResourceNotFoundException("Email id does not exist"));
            System.out.println(decodePassword(loginDto.getPassword()));

        if (user != null && passwordEncoder.matches(
                decodePassword(loginDto.getPassword()),
                user.getPassword())) {
            return user;
        }
        return null;

    }
    /**
     * Saves an employee and returns the employee's name.
     *
     * @param userDto The employee details to be saved.
     * @return The name of the saved employee.
     */
    public final User saveEmp(final UserDto userDto) {
        if (userDto.getManagerId() == null && !userDto.getRole().equals(
                Role.ADMIN)) {
            userDto.setManagerId(1L);
        }
        if (!userRepository.findByEmail(userDto.getEmail()).isEmpty()) {
            throw new ResourceAlreadyExistsException("Email id already exists");
        }
        if (!userRepository.findByUserId(userDto.getUserId()).isEmpty()) {
            throw new ResourceAlreadyExistsException("User id already exists");
        }
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        User user = this.modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return user;
    }
public final List<EmployeeOutDto> allUserByRole(final String roleName){
        Role role = Role.valueOf(roleName);
    List<User> users = userRepository.findByRole(role);
    List<EmployeeOutDto> outUsers = new ArrayList<>();
    for(User user : users){
        EmployeeOutDto employeeOutDto = UserToOutDto(user);
        outUsers.add(employeeOutDto);
    }
    return outUsers;
}
    public final List<EmployeeOutDto> getAllUsers(){
        List<User> userList = userRepository.findAll();
        List<EmployeeOutDto> userDtoList = new ArrayList<>();
        for(User user : userList){
            if(user.getRole() != Role.ADMIN) {
                EmployeeOutDto employeeOutDto = UserToOutDto(user);
                userDtoList.add(employeeOutDto);
            }
        }
        return userDtoList;
    }

    public final UserNameDto getEmployeeNameById(final String userId) {
        if(userRepository.findByUserId(userId).isEmpty()){
            throw new ResourceNotFoundException("This id doesnot exists");
        }
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException("Employee Id does not exist"));
        UserNameDto userNameDto = new UserNameDto(user.getName());
        return userNameDto;

    }
    public final UserNameDto getEmployeeNameByLongId(final Long id){
        if(userRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("This id doesnot exists");
        }
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException("Employee Id does not exist"));
        UserNameDto userNameDto = new UserNameDto(user.getName());
        return userNameDto;
    }
    public final EmployeeOutDto getEmployeeById(final Long id){
        if(userRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("This id doesnot exists");
        }
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException("Employee Id does not exist"));
        EmployeeOutDto employeeOutDto = UserToOutDto(user);
        return employeeOutDto;
    }
    public final EmployeeOutDto getEmployeeByEmail(String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException("Employee email does not exist"));
        EmployeeOutDto employeeOutDto = UserToOutDto(user);
        return employeeOutDto;

    }

    public final ApiResponse updateEmployee(final Long id, final Map<String, Long> updatedDetails){
        Long projectId = updatedDetails.get("projectId");
        Long managerId = updatedDetails.get("managerId");
        User employee = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found."));
        User manager = userRepository.findById(managerId).orElseThrow(()-> new ResourceNotFoundException("Resource not found."));

        employee.setManagerId(managerId);
        employee.setProjectId(projectId);
        userRepository.save(employee);

        return new ApiResponse("Updated Successfully");

    }

    public final EmployeeOutDto UserToOutDto(User user){
        EmployeeOutDto empDto = new EmployeeOutDto();
        empDto.setId(user.getId());
        empDto.setName(user.getName());
        empDto.setEmail(user.getEmail());
        empDto.setUserId(user.getUserId());
        empDto.setDesignation(user.getDesignation());
        empDto.setContactNo(user.getContactNo());
        empDto.setDob(user.getDob());
        empDto.setDoj(user.getDoj());
        empDto.setLocation(user.getLocation());
        empDto.setProjectId(user.getProjectId());
        User manager = userRepository
                .findById(user.getManagerId()).get();
        empDto.setManagerName(manager.getName());
        empDto.setSkills(user.getSkills());
        empDto.setRole(user.getRole());
        if(user.getProjectId() == null){
            empDto.setProjectName("");
        }else{
            Project project = projectRepository.findByProjectId(user.getProjectId()).get();
            empDto.setProjectName(project.getProjectName());
        }
        return empDto;
    }
}
