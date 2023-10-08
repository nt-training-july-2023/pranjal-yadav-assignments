package com.employee.employeeManagement.service;

import com.employee.employeeManagement.constants.SuccessConstants;
import com.employee.employeeManagement.model.Project;
import com.employee.employeeManagement.model.RequestResource;
import com.employee.employeeManagement.model.User;
import com.employee.employeeManagement.dto.RequestResourceDto;
import com.employee.employeeManagement.dto.RequestResourceOutDto;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.RequestResourceRepository;
import com.employee.employeeManagement.repository.UserRepository;
import com.employee.employeeManagement.response.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class RequestResourceService {
    /**
     * request resource repository autowired.
     */
    @Autowired
    private RequestResourceRepository requestResourceRepository;
    /**
     * user repository autowired.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * projectRepository autowired.
     */
    @Autowired
    private ProjectRepository projectRepository;
    /**
     * Requests a resource based on the provided RequestResourceDto.
     *
     * @param requestResourceDto The RequestResourceDto
     *                           containing the request details.
     * @return An ResponseDto indicating the status of the operation.
     */
    public final ResponseDto requestResource(
            final RequestResourceDto requestResourceDto) {
        RequestResource requestResource =
                dtoToRequestResource(requestResourceDto);
        requestResourceRepository.save(requestResource);
        return new ResponseDto(SuccessConstants.RESOURCE_ADDED);
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
     * @return An ResponseDto indicating the status of the operation.
     */
    public ResponseDto deleteRequest(final Long resourceId) {
        requestResourceRepository.deleteById(resourceId);
        return new ResponseDto(SuccessConstants.DELETED);
    }
    /**
     * Accepts a request by updating the project and manager for an employee.
     *
     * @param id        The ID of the employee.
     * @return An ResponseDto indicating the status of the operation.
     */
    public final ResponseDto acceptRequest(
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
        return new ResponseDto(SuccessConstants.ACCEPTED);
    }
    /**
     * check if the resource is already requested.
     * @param empId requested resource employee id.
     * @param managerId requested resource manager id.
     * @return boolean value.
     */
    public boolean isRequested(final Long empId, final Long managerId) {
        Optional<RequestResource> req =
                requestResourceRepository.findByEmployeeIdAndManagerId(
                        empId, managerId);
        return req.isPresent();
    }
    /**
     * Converts a RequestResourceDto to a RequestResource entity.
     *
     * @param requestResourceDto The RequestResourceDto to convert.
     * @return The corresponding RequestResource entity.
     */
    public RequestResource dtoToRequestResource(
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
    public RequestResourceOutDto requestToOutDto(
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
