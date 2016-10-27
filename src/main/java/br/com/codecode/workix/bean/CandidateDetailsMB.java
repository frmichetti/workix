package br.com.codecode.workix.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.cdi.qualifier.Push;
import br.com.codecode.workix.jsf.util.MessagesHelper;
import br.com.codecode.workix.model.scaffold.Candidate;

@SessionScoped
@ManagedBean
@Named
public class CandidateDetailsMB implements Serializable {

	private static final long serialVersionUID = 8847505514073013416L;
	
	private String messageTitle,messageBody;
	
	@Inject @Mockup
	private Crud<Candidate> dao;
	
	@Inject @Push
	private Notification notification;
	
	private Long id = 0L;
	
	private Candidate currentCandidate ;
	
	@Inject
	private MessagesHelper messagesHelper;
	
	public CandidateDetailsMB(){}

	public void init(){
		
		System.out.println("Candidate ID RECEIVED -> " + id);
		
		if(id > 0){
			currentCandidate = dao.findById(id);	
		}		
		
		if (currentCandidate == null){
			currentCandidate = new Candidate();
			currentCandidate.setId(0L);
			currentCandidate.setName("Não Encontrado");			
		
		}
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidate getCurrentCandidate() {
		return currentCandidate;
	}
	
	public void notifyByEmail(){
		messagesHelper.addFlash(new FacesMessage("Email Enviado com Sucesso !"));
		
	}
	
	public void notifyByPush(){
		messagesHelper.addFlash(new FacesMessage("Push Message Enviado com Sucesso !"));
		notification.doSendMessage(currentCandidate, messageTitle, messageBody);
		
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
	
	

	
}
