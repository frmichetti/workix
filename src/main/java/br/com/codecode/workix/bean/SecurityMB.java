package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SecurityMB extends BaseMB{

	private static final long serialVersionUID = 4062470003123871957L;
	
	private String firebaseUser;	
	
	@PostConstruct
	public void init(){}	

}
