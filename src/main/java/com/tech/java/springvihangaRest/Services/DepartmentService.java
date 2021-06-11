package com.tech.java.springvihangaRest.Services;

import com.tech.java.springvihangaRest.Exceptions.DepartmentNotFoundException;
import com.tech.java.springvihangaRest.Models.Department;

import java.util.List;

public interface DepartmentService {
     Department saveDepartment(Department department);

     List<Department> getAllDepartments();

     Department updateDepartment(Long departmentId,Department department);

     Department getDepamentByID(Long departmentId);

     void deleteDepartmentById(Long departmentId);

     Department getDepartmentByName(String departmentName);
}
