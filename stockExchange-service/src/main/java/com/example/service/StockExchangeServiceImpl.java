package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.model.StockExchange;
import com.example.repo.StockExchangeDao;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {
	
	StockExchangeDao stockExchangeDao;	

	public StockExchangeServiceImpl(StockExchangeDao stockExchangeDao) {
		super();
		this.stockExchangeDao = stockExchangeDao;
	}

	@Override
	public StockExchange addStockExchange(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		stockExchangeDao.save(stockExchange);
		
		return stockExchange;
	}

	@Override
	public List<StockExchange> getStockExchangesList() {
		// TODO Auto-generated method stub
		return stockExchangeDao.findAll();
	}

}
