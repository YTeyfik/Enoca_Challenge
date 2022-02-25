package com.example.enocamvc.controllers;

import com.example.enocamvc.models.Company;
import com.example.enocamvc.models.dtos.CompanyDto;
import com.example.enocamvc.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto){
        Company company=companyService.addCompany(Company.from(companyDto));
        return new ResponseEntity<>(CompanyDto.from(company),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanies(){
        List<Company> companies=companyService.getCompanies();
        List<CompanyDto> companyDtos=companies.stream().map(CompanyDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(companyDtos,HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable Long id){
        Company company=companyService.getCompany(id);
        return new ResponseEntity<>(CompanyDto.from(company),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CompanyDto> deleteCompany(@PathVariable Long id){
        Company company=companyService.deleteCompany(id);
        return new ResponseEntity<>(CompanyDto.from(company),HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CompanyDto> editCompany(@PathVariable Long id,@RequestBody CompanyDto companyDto){
        Company company=companyService.editCompany(id,Company.from(companyDto));
        return new ResponseEntity<>(CompanyDto.from(company),HttpStatus.OK);
    }
    @PostMapping(value = "{companyId}/employees/{employeeId}/add")
    public ResponseEntity<CompanyDto> addEmployeeToCompany(@PathVariable Long companyId,@PathVariable Long employeeId){
        Company company=companyService.addEmployeeToCompany(companyId,employeeId);
        return new ResponseEntity<>(CompanyDto.from(company),HttpStatus.OK);
    }

    @DeleteMapping(value = "{companyId}/employees/{employeeId}/remove")
    public ResponseEntity<CompanyDto> deleteEmployeeFromCompany(@PathVariable Long companyId,@PathVariable Long employeeId){
        Company company=companyService.deleteEmployeeFromCompany(companyId,employeeId);
        return new ResponseEntity<>(CompanyDto.from(company),HttpStatus.OK);
    }
}
