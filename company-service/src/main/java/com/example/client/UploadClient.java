package com.example.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Entry;


@FeignClient(name = "upload-service", url = "localhost:8085/upload/")
public interface UploadClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "getStockPrice/{companyCode}/{stockExchange}")
	public List<Entry> getCompanyStockPrice(@PathVariable("companyCode") Long companyCode,@PathVariable("stockExchange") String stockExchange);


}
