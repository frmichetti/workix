package br.com.codecode.akijob.bean;

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
		
		System.out.println("[CDI - " + this.getClass().getSimpleName() + "]");

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
