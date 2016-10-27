package br.com.codecode.workix.bean;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.codecode.workix.jsf.util.MessagesHelper;

@Model
public class SignupMB {
	
	@Inject
	private MessagesHelper messagesHelper;
	
	private String email;
	
	
	public void addToList(){
		messagesHelper.addFlash(new FacesMessage(FacesMessage.SEVERITY_INFO, email + " inscrito na Lista de Novidades", "Obrigado!"));
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

}
