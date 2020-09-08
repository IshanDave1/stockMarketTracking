package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Company;

@Repository
public interface CompanyDao  extends JpaRepository<Company,Integer>{

	
}
