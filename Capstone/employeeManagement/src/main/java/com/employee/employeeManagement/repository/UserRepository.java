package com.employee.employeeManagement.repository;

import com.employee.employeeManagement.Model.Role;
import com.employee.employeeManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
//    @Query("SELECT u FROM User u WHERE u.role = com.employee.employeeManagement.Model.Role.USER")
//    List<User> findAllEmployees();
    List<User> findByRole(Role role);
    @Query("SELECT u FROM User u WHERE u.role = com.employee.employeeManagement.Model.Role.MANAGER")
    List<User> findAllManagers();
}
