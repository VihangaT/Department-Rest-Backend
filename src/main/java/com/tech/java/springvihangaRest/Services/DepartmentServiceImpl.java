package com.tech.java.springvihangaRest.Services;

import com.tech.java.springvihangaRest.Exceptions.DepartmentNotFoundException;
import com.tech.java.springvihangaRest.Models.Department;
import com.tech.java.springvihangaRest.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException {
        Optional<Department> DepartmentfrmDB = departmentRepository.findById(departmentId);

        if (!DepartmentfrmDB.isPresent()) {
            throw new DepartmentNotFoundException("Department with the ID no: " + departmentId + " not found");
        } else {

            if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
                DepartmentfrmDB.get().setDepartmentName(department.getDepartmentName());
            }

            if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
                DepartmentfrmDB.get().setDepartmentAddress(department.getDepartmentAddress());
            }

            if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
                DepartmentfrmDB.get().setDepartmentCode(department.getDepartmentCode());
            }
        }
        return departmentRepository.save(DepartmentfrmDB.get());

    }

    @Override
    public Department getDepamentByID(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department with the ID:" + departmentId + " is Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> DBdepartment = departmentRepository.findById(departmentId);
        if (!DBdepartment.isPresent()) {
            throw new DepartmentNotFoundException("Department with the ID:" + departmentId + " is Not Available");
        } else {
            departmentRepository.deleteById(departmentId);
        }
    }

    @Override
    public Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException {
        Optional<Department> DepartmentFrmDB = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if (!DepartmentFrmDB.isPresent()) {
            throw new DepartmentNotFoundException("Department with name " + departmentName + " is not found");
        }
        return DepartmentFrmDB.get();
    }


}
