package com.example.enocamvc.models;

import com.example.enocamvc.models.dtos.CompanyDto;
import com.example.enocamvc.models.dtos.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contact;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "company_id")
    private List<Employee> employees=new ArrayList<>();


    public static Company from(CompanyDto companyDto){
        Company company=new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setAddress(companyDto.getAddress());
        company.setContact(companyDto.getContact());
        return company;
    }

    public void addEmp(Employee employee){
        employees.add(employee);
    }

    public  void removeEmployee(Employee employee){
        employees.remove(employee);
    }


}
