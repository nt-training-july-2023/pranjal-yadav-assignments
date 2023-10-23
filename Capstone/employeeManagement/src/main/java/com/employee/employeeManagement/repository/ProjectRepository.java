package com.employee.employeeManagement.repository;

import com.employee.employeeManagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Project entities.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
    /**
     * findAllByManagerID.
     * @param managerId manger empID.
     * @return List project.
     */
    List<Project> findAllByManagerId(Long managerId);
    /**
     * findByProjectID.
     * @param projectId project Id.
     * @return project.
     */
    Optional<Project> findByProjectId(Long projectId);

    /**
     * findByProjectName.
     * @param projectName Name of the project.
     * @return project.
     */
    Optional<Project> findByProjectName(String projectName);

}
