package com.example.enocamvc.controllers;


import com.example.enocamvc.models.Employee;
import com.example.enocamvc.models.dtos.EmployeeDto;
import com.example.enocamvc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List<Employee> employees=employeeService.getEmployees();
        List<EmployeeDto> employeeDtos=employees.stream().map(EmployeeDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(employeeDtos,HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id){
        Employee employee=employeeService.getEmployee(id);
        return new ResponseEntity<>(EmployeeDto.from(employee),HttpStatus.OK);
    }

   @PostMapping
   public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto ){
        Employee employee=employeeService.addEmployee(Employee.from(employeeDto));
        return new ResponseEntity<>(EmployeeDto.from(employee),HttpStatus.OK);
   }

   @DeleteMapping(value = "{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable Long id){
        Employee employee=employeeService.deleteEmployee(id);
        return new ResponseEntity<>(EmployeeDto.from(employee),HttpStatus.OK);
   }

   @PutMapping(value = "{id}")
   public ResponseEntity<EmployeeDto> editEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
     Employee editEmp=employeeService.editEmployee(id,Employee.from(employeeDto));
     return new ResponseEntity<>(EmployeeDto.from(editEmp),HttpStatus.OK);
   }
}
