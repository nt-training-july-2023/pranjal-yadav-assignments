package com.employee.employeeManagement.controller;


import com.employee.employeeManagement.dto.RequestResourceDto;
import com.employee.employeeManagement.dto.RequestResourceOutDto;
import com.employee.employeeManagement.response.ResponseDto;
import com.employee.employeeManagement.service.RequestResourceService;
import com.employee.employeeManagement.validation.RequestResourceValidation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class RequestResourceController {
    /**
     * request resource validation autowired.
     */
    @Autowired
    private RequestResourceValidation requestResourceValidation;

    /**
     * requestResourceService autowired.
     */
    @Autowired
    private RequestResourceService requestResourceService;
    /**
     * The logger for this class.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserController.class);

    /**
     * Endpoint for adding a request.
     * @param requestResourceDto Request resource dto.
     * @return Response.
     */
    @PostMapping(path = "/request/resource")
    public final ResponseDto requestResource(
            @RequestBody @Valid final RequestResourceDto requestResourceDto) {
        requestResourceValidation.checkRequest(requestResourceDto);
        LOGGER.info("Adding request resource.");
        ResponseDto responseDto =
                requestResourceService.requestResource(requestResourceDto);
        LOGGER.info("Request resource dto: " + requestResourceDto.toString());
        return responseDto;
    }

    /**
     * Endpoint for retrieving all requested resources.
     * @return List of requested resources.
     */
    @GetMapping(path = "/all/request")
    public final List<RequestResourceOutDto> getAllRequests() {
        LOGGER.info("Getting all requests");
        List<RequestResourceOutDto> list =
                requestResourceService.getAllRequests();
        return list;
    }

    /**
     * Endpoint for deleting a requested resource.
     * @param resourceId Id of that resource.
     * @return Response.
     */
    @DeleteMapping(path = "/request/delete/{resourceId}")
    public final ResponseDto deleteRequest(
            @PathVariable final Long resourceId) {
        LOGGER.info("Deleting request.");
        requestResourceValidation.checkDelete(resourceId);
        ResponseDto responseDto =
                requestResourceService.deleteRequest(resourceId);
        LOGGER.info("Resource id: " + resourceId);
        return responseDto;
    }

    /**
     * Endpoint for accepting request.
     * @param resourceId of requested resource.
     * @return Response.
     */
    @PostMapping("/accept/{resourceId}")
    public final ResponseDto acceptRequest(
            @PathVariable final Long resourceId) {
        requestResourceValidation.checkResourceIdAccept(resourceId);
        LOGGER.info("Accepting resource");
        ResponseDto responseDto =
                requestResourceService.acceptRequest(resourceId);
        LOGGER.info("Resource id: " + resourceId);
        return responseDto;
    }


    /**
     * Check if that particular employee is already
     * requested by that manager.
     * @param empId requested resource employee id.
     * @param managerId requested resource manager id.
     * @return boolean value.
     */
    @GetMapping("/employee/isRequested")
    public boolean isRequested(@RequestParam final Long empId,
                               @RequestParam final Long managerId) {
        LOGGER.info("Is requested");
        boolean returnedValue =
                requestResourceService.isRequested(empId, managerId);
        return returnedValue;
    }
}
