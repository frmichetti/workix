package br.com.codecode.workix.bean;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Model
public class SearchMB {
	
	@Inject @Default
	private EntityManager em;
	
	private String keyword;
	
	public SearchMB(){}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String fetch(){
		return "";
	}
	
	

}
