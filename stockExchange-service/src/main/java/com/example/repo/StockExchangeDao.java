package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.StockExchange;

@Repository
public interface  StockExchangeDao extends JpaRepository<StockExchange, Integer>{
	
	

}
