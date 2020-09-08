package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.CompanyClient;
import com.example.model.Company;
import com.example.model.StockExchange;
import com.example.service.StockExchangeServiceImpl;

@RestController
@RequestMapping("/stockExchange")
public class StockExchangeController {
	
	StockExchangeServiceImpl stockExchangeServiceImpl;
	CompanyClient companyClient;
	
	
	
	public StockExchangeController(StockExchangeServiceImpl stockExchangeServiceImpl,CompanyClient companyClient) {
		super();
		this.stockExchangeServiceImpl = stockExchangeServiceImpl;
		this.companyClient =companyClient;
	}

	@PostMapping("/addstockExchange")
	public ResponseEntity<StockExchange> addStockExchange(@RequestBody StockExchange stockExchange){
		return new ResponseEntity<StockExchange>(stockExchangeServiceImpl.addStockExchange(stockExchange) , HttpStatus.CREATED);
	}
	
	@GetMapping("/getStockExchangesList")
	public ResponseEntity<List<StockExchange>> getStockExchangesList() {
		// TODO Auto-generated method stub
		
		return new ResponseEntity<>(stockExchangeServiceImpl.getStockExchangesList() , HttpStatus.OK);
	}
	
	@GetMapping("/getCompanies/{stockExchange}")
	public ResponseEntity<Company> getCompanies(@PathVariable String stockExchange) {
		return companyClient.findCompaniesInStockExchange(stockExchange);
	}
	

}
