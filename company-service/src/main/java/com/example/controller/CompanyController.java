package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.UploadClient;
import com.example.model.Company;
import com.example.model.Entry;
import com.example.service.CompanyServiceImpl;

@RestController
@RequestMapping("/company")
public class CompanyController {

	CompanyServiceImpl companyServiceImpl;
	UploadClient uploadClient;

	public CompanyController(CompanyServiceImpl companyServiceImpl, UploadClient uploadClient) {
		super();
		this.companyServiceImpl = companyServiceImpl;
		this.uploadClient = uploadClient;
	}

	// @GetMapping("/getCompanyDetails/{id}" , )
	@RequestMapping(method = RequestMethod.GET, value = "/getCompanyDetails/{id}", produces = { "application/json" })
	public ResponseEntity<Company> getCompanyDetails(@PathVariable Integer id) {
		// companyServiceImpl.getCompanyDetails(id)
		return new ResponseEntity<>(companyServiceImpl.getCompanyDetails(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/price/{id}/{stockExchange}" , produces = { "application/json" } )
	public List<Entry> getCompanyStockPrice(@PathVariable Integer id,@PathVariable  String stockExchange, LocalDateTime from,
			LocalDateTime to) {
		
		Long companyCode = companyServiceImpl.getCompanyCode(id, stockExchange);
		
		
		return uploadClient.getCompanyStockPrice(companyCode, stockExchange);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/companyBySe/{stockExchange}" , produces = { "application/json" } )
	public List<Company> findCompaniesInStockExchange(String stockExchange) {
		return companyServiceImpl.findCompaniesInStockExchange(stockExchange);
	}

}
