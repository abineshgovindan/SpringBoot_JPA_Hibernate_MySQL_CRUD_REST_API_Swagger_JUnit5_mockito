package com.springdev.SpringbootTutorial.service;

import com.springdev.SpringbootTutorial.entity.Department;
import com.springdev.SpringbootTutorial.error.DepartmentNotFoundExpection;
import com.springdev.SpringbootTutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl  implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundExpection {
      Optional<Department> department =
              departmentRepository.findById(departmentId);
      if(!department.isPresent()){
          throw new DepartmentNotFoundExpection("Department Not Available");

      }
      return  department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getGetDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getGetDepartmentAddress())){
            depDB.setGetDepartmentAddress(department.getGetDepartmentAddress());
        }
        if(Objects.nonNull(department.getGetDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getGetDepartmentCode())){
            depDB.setGetDepartmentCode(department.getGetDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findBydepartmentName(departmentName);
    }

    @Override
    public Department fetchDepartmentByAddress(String getDepartmentAddress) {
        return departmentRepository.findBygetDepartmentAddressIgnoreCase(getDepartmentAddress);
    }


}
