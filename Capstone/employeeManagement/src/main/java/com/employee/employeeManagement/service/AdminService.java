package com.employee.employeeManagement.service;

import com.employee.employeeManagement.Model.Admin;
import com.employee.employeeManagement.dto.AdminDto;
import com.employee.employeeManagement.dto.LoginDto;
import com.employee.employeeManagement.exception.ResourceNotFoundException;
import com.employee.employeeManagement.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/**
 * Service class that handles operations related to administrators.
 */
@Service
public class AdminService {
    /**
     * AdminRepository autowired for adding to database.
     */
    @Autowired
    private AdminRepository adminRepository;
    /**
     * PasswordEncoder autowired to encode password.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * ModelMapper autowired to map dto to entity and vice versa.
     */
    @Autowired
    private ModelMapper modelMapper;
    /**
     * Adds a new administrator based on the provided DTO.
     *
     * @param adminDto The DTO containing the details of the new administrator.
     * @return The name of the added administrator.
     */

    public final String addAdmin(final AdminDto adminDto) {
        String encodedPassword = passwordEncoder.encode(adminDto.getPassword());
        adminDto.setPassword(encodedPassword);
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        Admin admin = this.modelMapper.map(adminDto, Admin.class);
        adminRepository.save(admin);
        return admin.getAdminName();
    }
    /**
     * Performs a login attempt for an administrator using
     * the provided login DTO.
     *
     * @param loginDto The DTO containing login credentials.
     * @return A status indicating the login result.
     */
    public final String login(final LoginDto loginDto) {
        Admin admin = adminRepository.
                findByAdminEmail(loginDto.getAdminEmail()).orElseThrow(() -> new
                        ResourceNotFoundException(""));
        System.out.println(admin);
        if (admin != null && passwordEncoder.matches(loginDto.getPassword(),
                admin.getPassword())) {

            return "Successfull";
        }
        return null;

    }
}
