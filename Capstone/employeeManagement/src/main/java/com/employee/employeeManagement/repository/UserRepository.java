package com.employee.employeeManagement.repository;

import com.employee.employeeManagement.enums.Role;
import com.employee.employeeManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing User entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by their email address.
     *
     * @param email The email address to search for.
     * @return An Optional containing the user if found, or empty if not found.
     */
    Optional<User> findByEmail(String email);

    /**
     * Finds user by their User id.
     * @param userId .
     * @return An optional containing user if found.
     */
    Optional<User> findByUserId(String userId);
    /**
     * Finds users by their role.
     *
     * @param role The role to filter users by.
     * @return A list of users with the specified role.
     */
    List<User> findByRole(Role role);
    List<User> findAllByProjectId(Long projectId);
}
