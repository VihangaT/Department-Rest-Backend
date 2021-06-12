package com.tech.java.springvihangaRest.Services;

import com.tech.java.springvihangaRest.Exceptions.DepartmentNotFoundException;
import com.tech.java.springvihangaRest.Models.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException;

    Department getDepamentByID(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException;
}
