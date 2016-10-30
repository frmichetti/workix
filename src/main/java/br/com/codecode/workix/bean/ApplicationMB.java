package br.com.codecode.workix.bean;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named
public class ApplicationMB {

	private String appName ;

	private int year;

	public ApplicationMB() {
		System.out.println("[CDI - " + this.getClass().getSimpleName() + "]");
	}

	@PostConstruct
	private void init(){

		appName = "Workix";

		year = LocalDate.now().getYear();		

	}

	public String getAppName() {
		return appName;
	}

	public int getYear() {
		return year;
	}


}
