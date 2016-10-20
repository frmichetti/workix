package br.com.codecode.bean;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ApplicationScoped
@ManagedBean
@Named
public class ApplicationMB {

	private String appName ;
	
	private int year;
	
	public ApplicationMB() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init(){
		
		appName = "AkiJob";
		
		year = LocalDate.now().getYear();
	}

	public String getAppName() {
		return appName;
	}

	public int getYear() {
		return year;
	}
	
	
}
