package com.employee.employeeManagement.repository;

import com.employee.employeeManagement.Model.Admin;
import com.employee.employeeManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //@Param("adminEmail")
    Optional<User> findByEmail(String email);
}
