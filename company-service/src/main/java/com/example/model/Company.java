package com.example.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "company_table")
public class Company {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")	
	private Integer id;
    
    @Column(name = "name")	
	private String name;
    
    @Column(name = "turnover")	
	private Long Turnover;
    
    @Column(name = "ceo")	
	private String ceo;
    
    @Column(name = "board_of_directors")	
	@ElementCollection
    private List<String> boardOfDirectors;
    
    @Column(name = "sector")	
	private String sector;
    
    @Column(name = "brief_writeup")	
	private String briefWriteup;
    
    @ElementCollection
    @CollectionTable(name = "company_code_table")
    @MapKeyColumn(name = "se_name")
    @Column(name = "company_code_info")
    private Map<String,Long> companyCodeInfo;
    
    
	public Company() {
		// TODO Auto-generated constructor stub
	}

	
	

	public Company(Integer id, String name, Long turnover, String ceo, List<String> boardOfDirectors, String sector,
			String briefWriteup, Map<String, Long> companyCodeInfo) {
		super();
		this.id = id;
		this.name = name;
		Turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.sector = sector;
		this.briefWriteup = briefWriteup;
		this.companyCodeInfo = companyCodeInfo;
	}




	public Map<String, Long> getCompanyCodeInfo() {
		return companyCodeInfo;
	}


	public void setCompanyCodeInfo(Map<String, Long> companyCodeInfo) {
		this.companyCodeInfo = companyCodeInfo;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTurnover() {
		return Turnover;
	}

	public void setTurnover(Long turnover) {
		Turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	
	public List<String> getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(List<String> boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getBriefWriteup() {
		return briefWriteup;
	}

	public void setBriefWriteup(String briefWriteup) {
		this.briefWriteup = briefWriteup;
	}
    
    
    

}
