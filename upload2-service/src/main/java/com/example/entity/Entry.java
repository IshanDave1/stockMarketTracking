package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entry_table")
public class Entry {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @Column(name = "company_code")
	private Long companyCode;
    
    @Column(name = "stock_exchange")
	private String stockExchange;
    
    @Column(name = "stock_price_per_share")
	private Double stockPricePerShare;
    
    @Column(name = "date_time")
	private LocalDateTime dateTime;
    
    public Entry() {
		// TODO Auto-generated constructor stub
	}

	public Entry(Integer id, Long companyCode, String stockExchange, Double stockPricePerShare,
			LocalDateTime dateTime) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.stockPricePerShare = stockPricePerShare;
		this.dateTime = dateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Double getStockPricePerShare() {
		return stockPricePerShare;
	}

	public void setStockPricePerShare(Double stockPricePerShare) {
		this.stockPricePerShare = stockPricePerShare;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
    
	
    
	
	
}
