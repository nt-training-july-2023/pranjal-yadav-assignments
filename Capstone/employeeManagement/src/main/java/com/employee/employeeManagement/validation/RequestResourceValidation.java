package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.model.RequestResource;
import com.employee.employeeManagement.model.User;
import com.employee.employeeManagement.dto.RequestResourceDto;
import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.constants.ErrorConstants;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.exception.ValidationException;
import com.employee.employeeManagement.repository.ProjectRepository;
import com.employee.employeeManagement.repository.RequestResourceRepository;
import com.employee.employeeManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestResourceValidation {
    /**
     * RequestResource repository autowired.
     */
    @Autowired
    private RequestResourceRepository requestResourceRepository;
    /**
     * User repository autowired.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * Project repository autowired.
     */
    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Checking request before adding.
     * @param requestResourceDto Request resource dto.
     */
    public final void checkRequest(
            final RequestResourceDto requestResourceDto) {
                userRepository.findById(requestResourceDto.getEmployeeId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                ErrorConstants.EMPLOYEE_NOT_EXIST));
        userRepository.findById(requestResourceDto.getManagerId())
                        .orElseThrow(() ->  new ResourceNotFoundException(
                                ErrorConstants.MANAGER_NOT_EXIST));
        projectRepository.findByProjectId(
                        requestResourceDto.getProjectId()).
                        orElseThrow(() -> new ResourceNotFoundException(
                                ErrorConstants.PROJECT_NOT_EXIST));
    }

    /**
     * Method to check Accepted request.
     * @param resourceId primary key of request resource.
     */
    public final void checkResourceIdAccept(final Long resourceId) {
        RequestResource requestResource =
                requestResourceRepository.findById(resourceId).orElseThrow(()
                        -> new ResourceNotFoundException(
                                ErrorConstants.RESOURCE_NOT_EXIST));
        User user =
                userRepository.findById(requestResource.getEmployeeId()).get();
        if (user.getProjectId() != null) {
            throw new ValidationException(
                    ErrorConstants.EMPLOYEE_ALREADY_ASSIGNED);
        }
    }

    /**
     * Method to check weather delete requests resource id is valid or not.
     * @param resourceId
     */
    public final void checkDelete(final Long resourceId) {
                requestResourceRepository.findById(resourceId).orElseThrow(()
                        -> new ResourceNotFoundException(
                        ErrorConstants.RESOURCE_NOT_EXIST));
    }

    /**
     * Method to check isRequested.
     * @param empId Employee id.
     * @param managerId Manager id.
     */
    public final void checkIsRequested(final Long empId, final Long managerId) {
        User employee = userRepository.findById(empId).orElse(null);
        if (employee == null || employee.getRole() != Role.EMPLOYEE) {
            throw new ResourceNotFoundException(
                    ErrorConstants.EMPLOYEE_NOT_EXIST);
        }
        User manager = userRepository.findById(managerId).orElse(null);
        if (manager == null || manager.getRole() != Role.MANAGER) {
            throw new ResourceNotFoundException(
                    ErrorConstants.MANAGER_NOT_EXIST);
        }
    }

}
