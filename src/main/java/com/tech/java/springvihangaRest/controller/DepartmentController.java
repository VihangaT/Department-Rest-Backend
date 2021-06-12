package com.tech.java.springvihangaRest.controller;

import com.tech.java.springvihangaRest.Exceptions.DepartmentNotFoundException;
import com.tech.java.springvihangaRest.Models.Department;
import com.tech.java.springvihangaRest.Services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/savedepartments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        String info =String.format("Saved the new department : %s" , department);
        logger.info(info);
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getalldepartments")
    public List<Department> getAllDepartments() {
        logger.info("Returned all the departments");
        return departmentService.getAllDepartments();
    }

    @PutMapping("/updatedepartment/{id}")
    public ResponseEntity<Department> UpdateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) throws DepartmentNotFoundException {
        Department department1 = departmentService.updateDepartment(departmentId, department);
        String info =String.format("updated the department : %s", department);
        logger.info(info);
        return new ResponseEntity<>(department1, HttpStatus.OK);
    }

    @GetMapping("/getdepartment/{id}")
    public Department getDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        String info=String.format("Returned the department with ID: %s",departmentId);
        logger.info(info);
        return departmentService.getDepamentByID(departmentId);

    }

    @DeleteMapping("/deletedepartment/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        departmentService.deleteDepartmentById(departmentId);
        String info=String.format("Department with id : %s deleted Successfully",departmentId);
        logger.info(info);
        return "Department with id :" + departmentId + " deleted Successfully";

    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String DepartmentName) throws DepartmentNotFoundException {
        return departmentService.getDepartmentByName(DepartmentName);
    }

}
