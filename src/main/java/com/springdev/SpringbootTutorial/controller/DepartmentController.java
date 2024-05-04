package com.springdev.SpringbootTutorial.controller;

import com.springdev.SpringbootTutorial.entity.Department;
import com.springdev.SpringbootTutorial.error.DepartmentNotFoundExpection;
import com.springdev.SpringbootTutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


   // private  final Logger LOGGER =  LoggerFactory.getLogger( name: DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
     //   LOGGER.info("Inside save dep controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        //LOGGER.info("Inside list  controller");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundExpection {
        return departmentService.fetchDepartmentById(departmentId);

    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById( @PathVariable("id") Long departmentId){
    departmentService.deleteDepartmentById(departmentId);
    return "Department deleted sucessfully";

    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);

    }


    @GetMapping("/departments/address/{address}")
    public Department fetchDepartmentByAddress(@PathVariable("address") String getDepartmentAddress ){
        return departmentService.fetchDepartmentByAddress( getDepartmentAddress);
    }

}


