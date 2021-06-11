package com.tech.java.springvihangaRest.controller;

import com.tech.java.springvihangaRest.Models.Department;
import com.tech.java.springvihangaRest.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/savedepartments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getalldepartments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PutMapping("/updatedepartment/{id}")
    public ResponseEntity<Department> UpdateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        Department department1=departmentService.updateDepartment(departmentId,department);
        return new ResponseEntity<>(department1, HttpStatus.OK);
    }

    @GetMapping("/getdepartment/{id}")
    public Department getDepartmentByID(@PathVariable("id") Long departmentId){
        return departmentService.getDepamentByID(departmentId);

    }

    @DeleteMapping("/deletedepartment/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department with id :"+departmentId+" deleted Successfully";

    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String DepartmentName){
        return departmentService.getDepartmentByName(DepartmentName);
    }

}
