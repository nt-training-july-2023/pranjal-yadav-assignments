package com.employee.employeeManagement.service;

import  java.util.*;
import com.employee.employeeManagement.Model.Admin;
import com.employee.employeeManagement.dto.AdminDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper modelMapper;


    public String addAdmin(AdminDto adminDto){
        String encodedPassword= passwordEncoder.encode(adminDto.getPassword());
        adminDto.setPassword(encodedPassword);

        Admin admin = this.modelMapper.map(adminDto, Admin.class);
        adminRepository.save(admin);
        return admin.getAdmin_name();
    }

    public String login(LoginDto loginDto){
        Admin admin = adminRepository.findByAdmin_Email(loginDto.getAdmin_email()).orElseThrow(() ->new ResourceNotFoundException());
        System.out.println(admin);
        if(admin != null && passwordEncoder.matches(loginDto.getPassword(), admin.getPassword())){

            return "Successfull";
        }
        return null;

    }
}
