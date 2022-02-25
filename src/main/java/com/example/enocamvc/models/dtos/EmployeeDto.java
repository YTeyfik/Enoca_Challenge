package com.example.enocamvc.models.dtos;

import com.example.enocamvc.models.Employee;
import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String surname;
    private  String email;

    public static EmployeeDto from(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }
}
