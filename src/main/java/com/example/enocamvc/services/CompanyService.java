package com.example.enocamvc.services;

import com.example.enocamvc.Repository.CompanyRepository;
import com.example.enocamvc.exception.CompanyNotFoundExeption;
import com.example.enocamvc.exception.EmployeeNotFoundExeption;
import com.example.enocamvc.models.Company;
import com.example.enocamvc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final EmployeeService employeeService;
    @Autowired
    public CompanyService(CompanyRepository companyRepository, EmployeeService employeeService) {
        this.companyRepository = companyRepository;
        this.employeeService = employeeService;
    }

    public List<Company> getCompanies()
    {
        return StreamSupport
                .stream(companyRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Company getCompany(Long id)
    {
        return companyRepository.findById(id)
                .orElseThrow(()->new CompanyNotFoundExeption(id));
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);

    }

    public Company deleteCompany(Long id) {
        Company company=getCompany(id);
        this.companyRepository.delete(company);
        return company;
    }
    @Transactional
    public Company editCompany(Long id,Company company)
    {
        Company editCompany=getCompany(id);
        editCompany.setContact(company.getContact());
        editCompany.setName(company.getName());
        editCompany.setAddress(company.getAddress());
        return editCompany;
    }
    @Transactional
    public Company addEmployeeToCompany(Long companyId,Long employeeId){
        Company company=getCompany(companyId);
        Employee employee= employeeService.getEmployee(employeeId);
        company.addEmp(employee);
        employee.setCompany(company);
        return  company;
    }
    @Transactional
    public Company deleteEmployeeFromCompany(Long companyId,Long employeeId){
        Company company=getCompany(companyId);
        Employee employee= employeeService.getEmployee(employeeId);
        company.removeEmployee(employee);
        return company;
    }

}
