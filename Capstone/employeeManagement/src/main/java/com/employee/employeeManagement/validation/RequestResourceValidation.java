package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.Model.User;
import com.employee.employeeManagement.repository.RequestResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestResourceValidation {
    @Autowired
    RequestResourceRepository requestResourceRepository;
    public void checkEmployeeId(Long employeeId){
//        User user =
//                requestResourceRepository.findByEmployeeId(employeeId).get();
    }
}
