package br.com.codecode.workix.bean;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.dao.ResumeCompleteDao;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.cdi.qualifier.Push;
import br.com.codecode.workix.jsf.util.MessagesHelper;
import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Resume;

@Model
public class ResumeMB implements Serializable {

	private static final long serialVersionUID = 3136618928143380363L;


	@Inject @Mockup
	private Crud<Candidate> dao;

	@Inject 
	private ResumeCompleteDao daoResume;

	@Inject @Push
	private Notification notification;	

	@Inject
	private MessagesHelper messagesHelper;

	private Long id;	

	private String messageTitle,messageBody;

	private Candidate candidate;

	private Resume resume;

	public ResumeMB(){}

	public void init(){

		System.out.println("Candidate ID RECEIVED -> " + id);

		candidate = dao.findById(id);	
		if(candidate == null){
			goToErrorPage();
		}
		
		resume = daoResume.findResumebyOwner(candidate);
		
		if(resume == null){
			goToErrorPage();
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}	

	public Resume getResume() {
		return resume;
	}

	public void notifyByEmail(){
		messagesHelper.addFlash(new FacesMessage("Email Enviado com Sucesso !"));
	}

	public void notifyByPush(){
		messagesHelper.addFlash(new FacesMessage("Push Message Enviado com Sucesso !"));
		notification.doSendMessage(resume.getOwner(), messageTitle, messageBody);
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

	private String goToErrorPage(){
		return "/404.xhtml?faces-redirect=true";
	}
	
	



}
