package br.com.codecode.openjobs.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@SessionScoped
@ManagedBean
@Named
public class SecurityMB implements Serializable{

	private static final long serialVersionUID = 4062470003123871957L;
	
	private String firebaseUser;
		
	public SecurityMB() {
		System.out.println(firebaseUser);
		discoverInput();
	}
	
	@PostConstruct
	public void discoverInput(){
		
		
		
	}
	
	

}
