package br.com.codecode.workix.bean;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ApplicationMB {

	private String appName, slogan ;

	private int year;

	public ApplicationMB() {
		System.out.println("[CDI - " + this.getClass().getSimpleName() + "]");
	}

	@PostConstruct
	private void init(){

		appName = "Workix";
		
		slogan = "Plataforma de Empregos Totalmente Grátis";

		year = LocalDate.now().getYear();		

	}

	public String getAppName() {
		return appName;
	}	

	public String getSlogan() {
		return slogan;
	}

	public int getYear() {
		return year;
	}


}
