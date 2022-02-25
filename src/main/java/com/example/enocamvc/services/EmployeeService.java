package com.example.enocamvc.services;

import com.example.enocamvc.Repository.EmployeeRepository;
import com.example.enocamvc.exception.EmployeeNotFoundExeption;
import com.example.enocamvc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees()
    {
        return this.employeeRepository.findAll();
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).orElseThrow(
                ()->new EmployeeNotFoundExeption(id));
    }

    public Employee addEmployee(Employee employee)
    {
        return this.employeeRepository.save(employee);
    }

    public Employee deleteEmployee(Long id){
        Employee employee= getEmployee(id);
        employeeRepository.delete(employee);
        return employee;
    }

    public Employee editEmployee(Long id,Employee employee){
        Employee editEmployee=getEmployee(id);
        editEmployee.setEmail(employee.getEmail());
        editEmployee.setName(employee.getName());
        editEmployee.setSurname(employee.getSurname());
        return editEmployee;
    }
}
