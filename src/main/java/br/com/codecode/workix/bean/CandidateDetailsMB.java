package br.com.codecode.workix.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.cdi.qualifier.Push;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.jsf.util.MessagesHelper;
import br.com.codecode.workix.model.jpa.Candidate;

@Named
@SessionScoped
public class CandidateDetailsMB implements Serializable {

	private static final long serialVersionUID = 8847505514073013416L;
	
	private String messageTitle, messageBody;
	
	@Inject @Generic
	private Crud<Candidate> dao;
	
	@Inject @Push
	private Notification notification;
	
	private long id;
	
	private Candidate candidate ;
	
	@Inject
	private MessagesHelper messagesHelper;
	
	public CandidateDetailsMB(){}
	

	/**
	 * Must be Called by f:viewAction After f:viewParam {@link page} 
	 */
	public void init(){
		
		System.out.println("Candidate ID RECEIVED -> " + id);
		
		if(id == 0){
			goToError();
		}else{
			
			try {
				
				candidate = dao.findById(id);
				
			} catch (NotImplementedYetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}		
		
		if (candidate == null){
			goToError();		
		}
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}
	
	public void notifyByEmail(){
		messagesHelper.addFlash(new FacesMessage("Email Enviado com Sucesso !"));
		
	}
	
	public void notifyByPush(){
		messagesHelper.addFlash(new FacesMessage("Push Message Enviado com Sucesso !"));
		notification.doSendMessage(candidate, messageTitle, messageBody);
		
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	
	private String goToError(){
		return "404.xhtml?faces-redirect=true";
	}
	
	

	
}
