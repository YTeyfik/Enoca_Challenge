package com.example.enocamvc.models.dtos;

import com.example.enocamvc.models.Company;
import com.example.enocamvc.models.Employee;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CompanyDto {
    private Long id;
    private String name;
    private String address;
    private String contact;
    private List<EmployeeDto> employeeDtos=new ArrayList<>();

    public static CompanyDto from(Company company){
        CompanyDto companyDto=new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setAddress(company.getAddress());
        companyDto.setContact(company.getContact());
        companyDto.setEmployeeDtos(company.getEmployees().stream().map(EmployeeDto::from).collect(Collectors.toList()));
        return companyDto;
    }
}
