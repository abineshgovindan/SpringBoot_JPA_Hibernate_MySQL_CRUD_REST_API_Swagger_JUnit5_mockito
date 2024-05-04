package com.springdev.SpringbootTutorial.service;

import com.springdev.SpringbootTutorial.entity.Department;
import com.springdev.SpringbootTutorial.error.DepartmentNotFoundExpection;

import java.util.List;

public interface DepartmentService {
  public   Department saveDepartment(Department department);

  public  List<Department> fetchDepartmentList();

   public  Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundExpection;

   public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);

   public Department fetchDepartmentByAddress(String getDepartmentAddress);
}
