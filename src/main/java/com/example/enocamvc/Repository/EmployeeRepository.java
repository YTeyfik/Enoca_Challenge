package com.example.enocamvc.Repository;

import com.example.enocamvc.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
