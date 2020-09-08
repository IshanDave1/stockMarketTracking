package com.example.service;

import java.util.List;

import com.example.model.StockExchange;

public interface StockExchangeService   {
	
	public StockExchange addStockExchange(StockExchange stockExchange);
	public List<StockExchange> getStockExchangesList();
	//public List<Company> getCompaniesList(String stockExchage);

	

}
