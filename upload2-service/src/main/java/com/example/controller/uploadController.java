package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Entry;
import com.example.repo.EntryDao;

@RestController
@RequestMapping("/upload")
public class uploadController {

	EntryDao entryDao;
	
	
	
	public uploadController(EntryDao entryDao) {
		super();
		this.entryDao = entryDao;
	}

	@GetMapping(value = "/test")
	public String test() {
		System.out.println("testing the controller");
		return "Hello World";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sheet")
	public void upload(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("uploading your sheet");
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet sheet = xssfWorkbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			Entry entry = new Entry();
			entry.setCompanyCode((long) row.getCell(0).getNumericCellValue());
			entry.setStockExchange(  row.getCell(1).getStringCellValue() );
			entry.setStockPricePerShare( row.getCell(2).getNumericCellValue() );
			entryDao.save(entry);
			//entry.setCompanyCode((long) row.getCell(3).getNumericCellValue());

		}
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getStockPrice/{companyCode}/{stockExchange}")
	public List<Entry> getCompanyStockPrice(@PathVariable("companyCode") Long companyCode,@PathVariable("stockExchange") String stockExchange) {
		return entryDao.findByCompanyCodeAndStockExchange(companyCode,stockExchange);	
	}

	

}
