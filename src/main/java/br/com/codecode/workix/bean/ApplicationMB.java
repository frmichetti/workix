package br.com.codecode.workix.bean;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * This ManagedBean Shares info in index.xhtml
 * Execute with {@link ApplicationScoped}
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Named
@ApplicationScoped
public class ApplicationMB extends BaseMB {

	private static final long serialVersionUID = -8121534895073326681L;

	private String appName, slogan ;

	private int year;	

	@PostConstruct
	@Override
	protected void init(){

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
