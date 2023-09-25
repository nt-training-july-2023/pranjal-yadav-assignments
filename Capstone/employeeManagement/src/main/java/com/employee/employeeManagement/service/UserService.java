package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.Project;
import com.employee.employeeManagement.Model.RequestResource;
import com.employee.employeeManagement.dto.RequestResourceDto;
import com.employee.employeeManagement.dto.IsRequested;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.outDtos.EmployeeOutDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.dto.UserDto;
import com.employee.employeeManagement.outDtos.RequestResourceOutDto;
import com.employee.employeeManagement.outDtos.UserNameDto;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.RequestResourceRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ApiResponse;
import com.employee.employeeManagement.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashSet;
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
    public final ApiResponse addUser(final UserDto userDto) {
        User user = userDtoToUser(userDto);
        userRepository.save(user);
        return new ApiResponse("User Added successfully");

    }
    /**
     * Performs user login and returns the login DTO if successful.
     *
     * @param loginDto The login details.
     * @return The login DTO if successful, otherwise null.
     */
    public final ApiResponse login(final LoginDto loginDto) {
        Optional<User> optionalUser = userRepository.findByEmail(
                loginDto.getEmail());
        User user = optionalUser.get();
        return new ApiResponse("Logged in successfully", user.getRole());

    }
    /**
     * Saves an employee and returns the employee's name.
     *
     * @param userDto The employee details to be saved.
     * @return The name of the saved employee.
     */
    public final ApiResponse saveEmp(final UserDto userDto) {
        if (userDto.getManagerId() == null && !userDto.getRole().equals(
                Role.ADMIN)) {
            userDto.setManagerId(1L);
        }
        User user = userDtoToUser(userDto);
        userRepository.save(user);
        return new ApiResponse(
                "User added", user.getRole());
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
                List<String> team = new ArrayList<>();
                List<User> userDb =
                        userRepository.findAllByProjectId(user.getProjectId());
                for (User currUser : userDb) {
                    System.out.println(currUser);
                    team.add(currUser.getName());
                }
//               System.out.println(team);
//                employeeOutDto.setTeam(null);

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
        if (userRepository.findByUserId(userId).isEmpty()) {
            throw new ResourceNotFoundException("This id does not exists");
        }
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException(
                        "Employee Id does not exist"));
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
        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("This id does not exists");
        }
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException(
                        "Employee Id does not exist"));
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
        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("This id doesnot exists");
        }
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException(
                        "Employee Id does not exist"));
        EmployeeOutDto employeeOutDto = userToOutDto(user);
        return employeeOutDto;
    }
    /**
     * Retrieves an EmployeeOutDto object by employee email.
     *
     * @param email The email address of the employee.
     * @return An EmployeeOutDto object representing the employee.
     * @throws ResourceNotFoundException If the
     * employee with the specified email does not exist.
     */
    public final EmployeeOutDto getEmployeeByEmail(final String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(
                () -> new ResourceNotFoundException(
                        "Employee email does not exist"));
        EmployeeOutDto employeeOutDto = userToOutDto(user);
        return employeeOutDto;

    }
    /**
     * Updates employee details such as project and manager.
     *
     * @param id            The ID of the employee to be updated.
     * @param updatedDetails A Map containing updated project and manager IDs.
     * @return An ApiResponse indicating the result of the update.
     * @throws ResourceNotFoundException If the
     * employee with the specified ID does not exist.
     */

    public final ApiResponse updateEmployee(final Long id, final Map<String,
            Long> updatedDetails) {
        Long projectId = updatedDetails.get("projectId");
        Long managerId = updatedDetails.get("managerId");
        User employee = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Resource not found."));
        employee.setManagerId(managerId);
        employee.setProjectId(projectId);
        userRepository.save(employee);

        return new ApiResponse("Updated Successfully");

    }
    /**
     * Updates the skills of a user.
     *
     * @param id     The ID of the user whose skills are to be updated.
     * @param skills The list of skills to update.
     * @return An ApiResponse indicating the status of the operation.
     */
    public final ApiResponse updateSkills(
            final Long id, final List<String> skills) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        user.setSkills(skills);
        userRepository.save(user);
        return new ApiResponse("Skills are updated.");

    }
    /**
     * Requests a resource based on the provided RequestResourceDto.
     *
     * @param requestResourceDto The RequestResourceDto
     *                           containing the request details.
     * @return An ApiResponse indicating the status of the operation.
     */
    public final ApiResponse requestResource(
            final RequestResourceDto requestResourceDto) {
        RequestResource requestResource =
                dtoToRequestResource(requestResourceDto);
        requestResourceRepository.save(requestResource);
        return new ApiResponse("Resource added.");
    }
    /**
     * Retrieves a list of all request resources and
     * converts them to RequestResourceOutDto objects.
     *
     * @return A list of RequestResourceOutDto
     * objects representing all request resources.
     */
    public final List<RequestResourceOutDto> getAllRequests() {
        List<RequestResource> requestResourceList =
                requestResourceRepository.findAll();
        List<RequestResourceOutDto> returnedList = new ArrayList<>();
        for (RequestResource r: requestResourceList) {
            RequestResourceOutDto requestResourceOutDto = requestToOutDto(r);
            returnedList.add(requestResourceOutDto);
        }
        return returnedList;
    }
    /**
     * Deletes a request resource by its ID.
     *
     * @param resourceId The ID of the request resource to delete.
     * @return An ApiResponse indicating the status of the operation.
     */
    public ApiResponse deleteRequest(final Long resourceId) {
        requestResourceRepository.deleteById(resourceId);
        return new ApiResponse("Deleted successfully!");
    }
    /**
     * Accepts a request by updating the project and manager for an employee.
     *
     * @param id        The ID of the employee.
     * @return An ApiResponse indicating the status of the operation.
     */
    public final ApiResponse acceptRequest(
            final Long id) {
        RequestResource requestResource =
                requestResourceRepository.findById(id).get();
        User employee =
                userRepository.findById(requestResource.getEmployeeId()).get();
        employee.setProjectId(requestResource.getProjectId());
        employee.setManagerId(requestResource.getManagerId());
        this.userRepository.save(employee);
        deleteRequest(id);

        List<RequestResource> employeeRequests =
                requestResourceRepository.findByEmployeeId(employee.getId());
        for (RequestResource req : employeeRequests) {
            deleteRequest(req.getResourceId());
        }
        return new ApiResponse("Accepted");
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
        List<User> employeesWithSkills =
                allEmployees.stream().filter(
                        user -> new HashSet<>(user.getSkills()).containsAll(
                                skills)).toList();
        List<User> returnedList;
        if (isCheck) {
            returnedList = employeesWithSkills.stream()
                    .filter(employee -> employee.getProjectId() == null)
                    .collect(Collectors.toList());
        } else {
            returnedList = employeesWithSkills;
        }
        List<EmployeeOutDto> outList = new ArrayList<>();
        for (User user : returnedList) {
            EmployeeOutDto currOut = userToOutDto(user);
            outList.add(currOut);
        }
        return outList;
    }
    /**
     * Unassigns a project from an employee.
     *
     * @param id The ID of the employee to unassign the project from.
     * @return An ApiResponse indicating the status of the operation.
     */
    public final ApiResponse unAssignProject(final Long id) {
        User user = userRepository.findById(id).get();

        User admin = userRepository.findByUserId("N0001").get();
        user.setManagerId(admin.getId());
        user.setProjectId(null);
        this.userRepository.save(user);
        return new ApiResponse("Project unassigned");
    }

    /**
     * check if the resource is already requested.
     * @param reqDto requested resource.
     * @return boolean value.
     */
    public boolean isRequested(final IsRequested reqDto) {
        User manager = userRepository
                .findByEmail(reqDto.getManagerEmail()).get();

        Optional<RequestResource> req =
                requestResourceRepository.findByEmployeeIdAndManagerId(
                        reqDto.getEmployeeId(),
                        manager.getId());
        if (req.isEmpty()) {
            return false;
        }
        return true;
    }
    /**
     * Converts a UserDto object to a User object.
     *
     * @param userDto The UserDto object to be converted.
     * @return A User object created from the provided UserDto.
     */
    public final User userDtoToUser(final UserDto userDto) {
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
//        empDto.setTeam(null);
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
        System.out.println(empDto.getSkills());
        return empDto;
    }
    /**
     * Converts a RequestResourceDto to a RequestResource entity.
     *
     * @param requestResourceDto The RequestResourceDto to convert.
     * @return The corresponding RequestResource entity.
     */
    private RequestResource dtoToRequestResource(
            final RequestResourceDto requestResourceDto) {
        RequestResource requestResource = new RequestResource();
        requestResource.setComment(requestResourceDto.getComment());
        requestResource.setManagerId(requestResourceDto.getManagerId());
        requestResource.setEmployeeId(requestResourceDto.getEmployeeId());
        requestResource.setProjectId(requestResourceDto.getProjectId());
        return requestResource;
    }
    /**
     * Converts a RequestResource entity to a RequestResourceOutDto.
     *
     * @param requestResource The RequestResource entity to convert.
     * @return The corresponding RequestResourceOutDto.
     */
    private RequestResourceOutDto requestToOutDto(
            final RequestResource requestResource) {
        RequestResourceOutDto r = new RequestResourceOutDto();
        r.setResourceId(requestResource.getResourceId());
        r.setComment(requestResource.getComment());
        r.setEmployeeId(requestResource.getEmployeeId());
        r.setManagerId(requestResource.getManagerId());
        r.setProjectId(requestResource.getProjectId());
        Optional<User> optionalUser =
                userRepository.findById(requestResource.getEmployeeId());
        User user = optionalUser.get();
        r.setEmployeeName(user.getName());
        r.setEmployeeUserId(user.getUserId());
        Optional<User> optionalManager =
                userRepository.findById(requestResource.getManagerId());
        User manager = optionalManager.get();
        r.setManagerName(manager.getName());
        r.setManagerUserId(manager.getUserId());
        Optional<Project> projectOptional =
                projectRepository.findById(requestResource.getProjectId());
        Project project = projectOptional.get();
        r.setProjectName(project.getProjectName());
        return r;
    }


}
