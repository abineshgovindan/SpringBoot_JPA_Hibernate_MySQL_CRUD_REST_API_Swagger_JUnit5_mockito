package com.springdev.SpringbootTutorial.repository;
import com.springdev.SpringbootTutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long> {
    public Department findBydepartmentName(String departmentName);

   public Department findBygetDepartmentAddress(String getDepartmentAddress);
    public Department findBygetDepartmentAddressIgnoreCase(String getDepartmentAddress);
}
