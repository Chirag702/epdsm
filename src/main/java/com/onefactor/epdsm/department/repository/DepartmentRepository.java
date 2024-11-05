 
package com.onefactor.epdsm.department.repository;

import com.onefactor.epdsm.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Additional custom query methods can be added here if needed
}
