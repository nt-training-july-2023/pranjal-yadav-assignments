package com.employee.employeeManagement.service;

import com.employee.employeeManagement.constants.ErrorConstants;
import com.employee.employeeManagement.constants.SuccessConstants;
import com.employee.employeeManagement.model.Project;
import com.employee.employeeManagement.model.RequestResource;
import com.employee.employeeManagement.dto.UserInDto;
import com.employee.employeeManagement.dto.EmployeeOutDto;
import com.employee.employeeManagement.dto.LoginResponse;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.model.User;
import com.employee.employeeManagement.dto.UserNameDto;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.RequestResourceRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ResponseDto;
import com.employee.employeeManagement.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Map;
import java.util.Base64;
import java.util.stream.Collectors;

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
    private UserValidation userValidation;
    /**
     * RequestResourceRepository autowired.
     */
    @Autowired
    private RequestResourceRepository requestResourceRepository;
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
    public final ResponseDto addUser(final UserInDto userDto) {
        User user = userDtoToUser(userDto);
        userRepository.save(user);
        return new ResponseDto(SuccessConstants.USER_ADDED);

    }
    /**
     * Performs user login and returns the login DTO if successful.
     *
     * @param loginDto The login details.
     * @return The login DTO if successful, otherwise null.
     */
    public final LoginResponse login(final LoginDto loginDto) {
        Optional<User> optionalUser = userRepository.findByEmail(
                loginDto.getEmail());
        User user = optionalUser.get();
        return new LoginResponse(
                SuccessConstants.LOGGED_IN, user.getId(),
                user.getRole(), user.getName());

    }
    /**
     * Saves an employee and returns the employee's name.
     *
     * @param userDto The employee details to be saved.
     * @return The name of the saved employee.
     */
    public final ResponseDto saveEmp(final UserInDto userDto) {
        if (userDto.getManagerId() == null && !userDto.getRole().equals(
                Role.ADMIN)) {
            userDto.setManagerId(1L);
        }
        User user = userDtoToUser(userDto);
        userRepository.save(user);
        return new ResponseDto(
                SuccessConstants.USER_ADDED, user.getRole());
    }
    /**
     * Retrieves a list of EmployeeOutDto
     * objects based on the provided role name.
     *
     * @param roleName The name of the role to filter employees by.
     * @return A list of EmployeeOutDto objects matching the specified role.
     */
    public final List<EmployeeOutDto> allUserByRole(final String roleName) {
        Role role = Role.valueOf(roleName);
        List<User> users =
            userRepository.findByRole(role);
        List<EmployeeOutDto> outUsers = new ArrayList<>();
        for (User user : users) {
            EmployeeOutDto employeeOutDto = userToOutDto(user);

        outUsers.add(employeeOutDto);
    }
    return outUsers;
}
    /**
     * Retrieves a list of all EmployeeOutDto objects for non-admin users.
     *
     * @return A list of EmployeeOutDto objects for non-admin users.
     */
    public final List<EmployeeOutDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<EmployeeOutDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            if (user.getRole() != Role.ADMIN) {
                EmployeeOutDto employeeOutDto = userToOutDto(user);
                userDtoList.add(employeeOutDto);

            }
        }
        return userDtoList;
    }
    /**
     * Retrieves the name of an employee by their user ID.
     *
     * @param userId The user ID of the employee.
     * @return A UserNameDto containing the name of the employee.
     * @throws ResourceNotFoundException If the
     * user with the specified ID does not exist.
     */

    public final UserNameDto getEmployeeNameById(final String userId) {
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException(
                        ErrorConstants.EMPLOYEE_NOT_EXIST));
        UserNameDto userNameDto = new UserNameDto();
        userNameDto.setName(user.getName());
        return userNameDto;

    }
    /**
     * Retrieves the name of an employee by their user ID (as a Long).
     *
     * @param id The user ID of the employee.
     * @return A UserNameDto containing the name of the employee.
     * @throws ResourceNotFoundException If the
     * user with the specified ID does not exist.
     */
    public final UserNameDto getEmployeeNameByLongId(final Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException(
                        ErrorConstants.EMPLOYEE_NOT_EXIST));
        UserNameDto userNameDto = new UserNameDto();
        userNameDto.setName(user.getName());
        return userNameDto;
    }
    /**
     * Retrieves an EmployeeOutDto object by employee ID.
     *
     * @param id The ID of the employee.
     * @return An EmployeeOutDto object representing the employee.
     * @throws ResourceNotFoundException If the
     * employee with the specified ID does not exist.
     */
    public final EmployeeOutDto getEmployeeById(final Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException(
                        ErrorConstants.EMPLOYEE_NOT_EXIST));
        EmployeeOutDto employeeOutDto = userToOutDto(user);
        return employeeOutDto;
    }
    /**
     * Assigns project to employee.
     *
     * @param id            The ID of the employee to be updated.
     * @param updatedDetails A Map containing updated project and manager IDs.
     * @return An ResponseDto indicating the result of the update.
     * @throws ResourceNotFoundException If the
     * employee with the specified ID does not exist.
     */

    public final ResponseDto updateEmployee(final Long id, final Map<String,
            Long> updatedDetails) {
        Long projectId = updatedDetails.get("projectId");
        Long managerId = updatedDetails.get("managerId");
        User employee = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(
                        ErrorConstants.EMPLOYEE_NOT_EXIST));
        employee.setManagerId(managerId);
        employee.setProjectId(projectId);
        userRepository.save(employee);
        List<RequestResource> list =
                requestResourceRepository.findByEmployeeId(id);
        for (RequestResource req : list) {
            deleteRequest(req.getResourceId());
        }

        return new ResponseDto(SuccessConstants.UPDATED_SUCCESSFULLY);

    }
    /**
     * Updates the skills of a user.
     *
     * @param id     The ID of the user whose skills are to be updated.
     * @param skills The list of skills to update.
     * @return An ResponseDto indicating the status of the operation.
     */
    public final ResponseDto updateSkills(
            final Long id, final List<String> skills) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        user.setSkills(skills);
        userRepository.save(user);
        return new ResponseDto(SuccessConstants.UPDATED_SUCCESSFULLY);

    }

    /**
     * Deletes a request resource by its ID.
     *
     * @param resourceId The ID of the request resource to delete.
     * @return An ResponseDto indicating the status of the operation.
     */
    public ResponseDto deleteRequest(final Long resourceId) {
        requestResourceRepository.deleteById(resourceId);
        return new ResponseDto(SuccessConstants.DELETED);
    }

    /**
     * Searches for employees by skills and availability.
     *
     * @param skills  The list of skills to search for.
     * @param isCheck Flag indicating whether
     *               to check availability (project unassigned).
     * @return A list of EmployeeOutDto objects representing matching employees.
     */

    public final List<EmployeeOutDto> searchBySkills(
            final List<String> skills, final boolean isCheck) {
        List<User> allEmployees = userRepository.findByRole(Role.EMPLOYEE);
        List<User> returnedList = new ArrayList<>();
        if (skills.isEmpty()) {
            List<User> unAssignedEmployees = allEmployees.stream()
                    .filter(employee -> employee.getProjectId() == null)
                    .collect(Collectors.toList());
            returnedList = unAssignedEmployees;
        } else {
            List<User> employeesWithRequiredSkills = allEmployees.stream()
                    .filter(employee -> employee.getSkills().
                            stream().anyMatch(skills::contains))
                    .collect(Collectors.toList());
            if (isCheck) {
                List<User> unAssignedEmployees =
                        employeesWithRequiredSkills.stream()
                                .filter(employee -> employee.getProjectId()
                                        == null)
                                .collect(Collectors.toList());
                returnedList = unAssignedEmployees;
            } else {
                returnedList = employeesWithRequiredSkills;
            }

        }
        List<EmployeeOutDto> returnedOutList = new ArrayList<>();
        for (User currUser: returnedList) {
            EmployeeOutDto outDto = userToOutDto(currUser);
            returnedOutList.add(outDto);
        }
        return returnedOutList;
    }
    /**
     * Unassigns a project from an employee.
     *
     * @param id The ID of the employee to unassign the project from.
     * @return An ResponseDto indicating the status of the operation.
     */
    public final ResponseDto unAssignProject(final Long id) {
        User user = userRepository.findById(id).get();
        User admin = userRepository.findByUserId("N0001").get();
        user.setManagerId(admin.getId());
        user.setProjectId(null);
        userRepository.save(user);
        return new ResponseDto(SuccessConstants.PROJECT_ASSIGNED);
    }
    /**
     * Converts a UserInDto object to a User object.
     *
     * @param userDto The UserInDto object to be converted.
     * @return A User object created from the provided UserInDto.
     */
    public final User userDtoToUser(final UserInDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setRole(userDto.getRole());
        user.setProjectId(userDto.getProjectId());
        user.setPassword(userDto.getPassword());
        user.setDob(userDto.getDob());
        user.setDoj(userDto.getDoj());
        user.setEmail(userDto.getEmail());
        user.setUserId(userDto.getUserId());
        user.setLocation(userDto.getLocation());
        user.setDesignation(userDto.getDesignation());
        user.setContactNo(userDto.getContactNo());
        user.setSkills(userDto.getSkills());
        user.setManagerId(userDto.getManagerId());
        return user;
    }
    /**
     * Converts a User object to an EmployeeOutDto object.
     *
     * @param user The User object to be converted.
     * @return An EmployeeOutDto object created from the provided User.
     */
    public final EmployeeOutDto userToOutDto(final User user) {
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
        empDto.setManagerId(user.getManagerId());
        User manager = userRepository
                .findById(user.getManagerId()).get();
        empDto.setManagerName(manager.getName());
        empDto.setSkills(user.getSkills());
        empDto.setRole(user.getRole());

        if (user.getProjectId() == null) {
            empDto.setProjectName("N/A");
        } else {
            Project project = projectRepository.findByProjectId(
                    user.getProjectId()).get();
            empDto.setProjectName(project.getProjectName());
        }
        return empDto;
    }



}
