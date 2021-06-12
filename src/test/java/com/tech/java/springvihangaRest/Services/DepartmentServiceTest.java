package com.tech.java.springvihangaRest.Services;

import com.tech.java.springvihangaRest.Exceptions.DepartmentNotFoundException;
import com.tech.java.springvihangaRest.Models.Department;
import com.tech.java.springvihangaRest.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department=
                Department.builder()
                .departmentID(1L)
                .departmentAddress("GALLE")
                .departmentName("IT")
                .departmentCode("Test-01")
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(Optional.ofNullable(department));
    }

    @Test
    @DisplayName("Get Data basedon valid Department Name")
    void whenValidDepartmentName_thenDepartmentShouldFound() throws DepartmentNotFoundException {
        String departmentName= "IT";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }


}