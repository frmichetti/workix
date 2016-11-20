package br.com.codecode.workix.bean;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.jsf.util.MessagesHelper;
import br.com.codecode.workix.model.scaffold.NewsLetterSubscriber;

@Model
public class SignupMB {
	
	@Inject
	private MessagesHelper messagesHelper;
	
	@Inject @Generic
	private Crud<NewsLetterSubscriber> dao;
	
	private String email;
	
	@Transactional
	public void addToList(){
		
		NewsLetterSubscriber subscriber = new NewsLetterSubscriber(email);
		
		dao.save(subscriber);
		
		messagesHelper.addFlash(new FacesMessage(FacesMessage.SEVERITY_INFO, subscriber.getEmail() + 
				" inscrito na Lista de Novidades", "Obrigado!"));
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

}
