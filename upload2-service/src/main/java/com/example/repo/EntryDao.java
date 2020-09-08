package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Entry;

@Repository
public interface EntryDao extends JpaRepository<Entry, Integer> {
	
	public List<Entry> findByCompanyCodeAndStockExchange(Long companyCode,String stockExString);

	
	

}
