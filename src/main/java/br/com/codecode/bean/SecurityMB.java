package br.com.codecode.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
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
	
	public void discoverInput(){
		
		HtmlInputText inputText = new HtmlInputText();	
		
		
		
	}
	
	

}
