package com.springdev.SpringbootTutorial.service;

import com.springdev.SpringbootTutorial.entity.Department;
import com.springdev.SpringbootTutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .getDepartmentAddress("chennai")
                .getDepartmentCode("IT-06")
                .departmentId(1L)
                .build();


        Mockito.when(departmentRepository.findBydepartmentName(("IT")))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on dep name")
    public void  whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());


    }
}