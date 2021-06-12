package com.tech.java.springvihangaRest.Repository;

import com.tech.java.springvihangaRest.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);

    @Query(value = "SELECT * From rest.department  where department_name = ?1", nativeQuery = true)
    public Optional<Department> findByDepartmentNameIgnoreCase(String departmentName);


}
