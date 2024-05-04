package com.springdev.SpringbootTutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "please add Department name")
//    @Length(max = 5, min = 1)
//    @Size(max = 10, min = 0)
    private String departmentName;
    @NotBlank(message = "plese add DepAddress")
    private String getDepartmentAddress;


    private String getDepartmentCode;



}
