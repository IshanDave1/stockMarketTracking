package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.example.model.Company;

public interface CompanyService {
	
	public Company getCompanyDetails(Integer id) ;
	public List<Company> getMatchingCompanies(String companyName);
	public List<Company> findCompaniesInStockExchange(String stockExchange);
	Long getCompanyCode(Integer id, String stockExchange);
	

}
