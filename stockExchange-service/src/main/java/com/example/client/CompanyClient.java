package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Company;

@FeignClient(name = "company-service", url = "localhost:8082/company/")
public interface CompanyClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/companyBySe/{stockExchange}")
	public ResponseEntity<Company> findCompaniesInStockExchange(@PathVariable String id);

}
