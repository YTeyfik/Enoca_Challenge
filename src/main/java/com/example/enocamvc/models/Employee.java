package com.example.enocamvc.models;

import com.example.enocamvc.models.dtos.EmployeeDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="employee")
public class Employee {
    @Id //
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private  String email;

    @ManyToOne
    private  Company company;

    public static Employee from(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }
}


