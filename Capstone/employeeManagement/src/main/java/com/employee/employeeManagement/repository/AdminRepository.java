package com.employee.employeeManagement.repository;

import com.employee.employeeManagement.Model.Admin;
import com.employee.employeeManagement.service.AdminService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin, Long> {
//    Optional<Admin> findOneByEmailAndPassword(String email, String password);

    @Query("select u from Admin as u where u.admin_email = :admin_email")
    Optional<Admin> findByAdmin_Email( @Param("admin_email") String admin_email);
}
