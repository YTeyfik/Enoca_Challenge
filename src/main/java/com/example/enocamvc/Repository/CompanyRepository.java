package com.example.enocamvc.Repository;

import com.example.enocamvc.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
