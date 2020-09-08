package com.example.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.model.Company;
import com.example.repo.CompanyDao;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	CompanyDao companyDao;
	
	

	public CompanyServiceImpl(CompanyDao companyDao) {
		super();
		this.companyDao = companyDao;
	}

	@Override
	public Company getCompanyDetails(Integer id) {
		// TODO Auto-generated method stub
		return companyDao.findById(id).get();
	}

	@Override
	public List<Company> getMatchingCompanies(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCompanyCode(Integer id, String stockExchange)
	{
		// TODO Auto-generated method stub
		//companyDao.findById(id).get().getCompanyCodeInfo().get(stockExchange);
		
		
		return companyDao.findById(id).get().getCompanyCodeInfo().get(stockExchange);
	}

	@Override
	public List<Company> findCompaniesInStockExchange(String stockExchange) {
		// TODO Auto-generated method stub
		List<Company> companyList = companyDao.findAll();
		List<Company> returnList = new LinkedList<Company>();
		for(Company company : companyList) 
			if(company.getCompanyCodeInfo().containsKey(stockExchange))
				returnList.add(company);
		return returnList;
	}

}
