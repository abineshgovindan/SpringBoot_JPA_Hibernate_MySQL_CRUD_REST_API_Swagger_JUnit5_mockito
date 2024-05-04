package com.springdev.SpringbootTutorial.repository;

import com.springdev.SpringbootTutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("MECH")
                .getDepartmentCode("ME-011")
                .getDepartmentAddress("CHE")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void  whenFindById_thenReturnDep(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "MECH" );
    }




}