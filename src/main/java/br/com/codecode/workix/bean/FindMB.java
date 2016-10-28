package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.codecode.workix.jsf.util.MessagesHelper;

@Model
public class FindMB {
	
	@Inject
	private MessagesHelper messagesHelper;

	private String query;
	
	public FindMB(){}
	
	@PostConstruct
	public void init(){
		
	}
	
	public void doFind(){
		if (!query.equals("")){
			messagesHelper.addFlash(new FacesMessage("Looking for " + query));
		}
	}
	

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
