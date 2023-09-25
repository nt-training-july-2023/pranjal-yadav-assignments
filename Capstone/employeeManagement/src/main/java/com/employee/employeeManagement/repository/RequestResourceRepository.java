package com.employee.employeeManagement.repository;

import com.employee.employeeManagement.Model.RequestResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing request resource data.
 */
public interface RequestResourceRepository
        extends JpaRepository<RequestResource, Long> {
    /**
     * find all requested resources by employee id.
     * @param id Id of employee.
     * @return list of requested resources.
     */
    List<RequestResource> findByEmployeeId(Long id);

    /**
     * returning optional requested resource by employee
     * id and manager id.
     * @param id Id of employee.
     * @param managerId manager id.
     * @return requested resource.
     */
    Optional<RequestResource> findByEmployeeIdAndManagerId(Long id,
                                                           Long managerId);
}
