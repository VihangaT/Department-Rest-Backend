package com.tech.java.springvihangaRest.controller;

import com.tech.java.springvihangaRest.Exceptions.DepartmentNotFoundException;
import com.tech.java.springvihangaRest.Models.Department;
import com.tech.java.springvihangaRest.Services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {

        department= Department.builder()
                .departmentAddress("Tester")
                .departmentCode("Tester")
                .departmentName("Controler Test")
                .departmentID(1L)
                .build();

        }

    @Test
    void saveDepartment() throws Exception {
        Department departmentInput= Department.builder()
                .departmentAddress("Tester")
                .departmentCode("Tester")
                .departmentName("Controler Test")
                .build();

        Mockito.when(departmentService.saveDepartment(departmentInput))
                .thenReturn(department);

        mockMvc.perform(post("/api/v1/department/savedepartments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                    "        \"departmentName\": \"Controler Test\",\n" +
                    "        \"departmentAddress\": \"Tester\",\n" +
                    "        \"departmentCode\": \"Tester\"\n" +
                    "    }"))
                    .andExpect(status().isOk());


    }

    @Test
    void getDepartmentByID() throws Exception {

        Mockito.when(departmentService.getDepamentByID(1L))
                .thenReturn(department);

        mockMvc.perform(get("/api/v1/department/getdepartment/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }
}