package br.com.codecode.workix.bean;

import java.io.IOException;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifier.Email;
import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.cdi.qualifier.Push;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.jsf.util.MessagesHelper;
import br.com.codecode.workix.model.jpa.Candidate;

/**
 * This ManagedBean controls candidate-details.xhtml
 * @author felipe
 *
 */
@Model
public class CandidateDetailsMB extends BaseMB {

	private static final long serialVersionUID = 8847505514073013416L;

	private String messageTitle, messageBody;

	@Inject @Generic
	private Crud<Candidate> dao;

	@Inject @Push
	private Notification pushNotification;	
	
	@Inject @Email
	private Notification mailNotification;
	
	@Inject
	private MessagesHelper messagesHelper;

	@Inject @Factory @Default
	private FacesContext facesContext;

	private long id;	

	private String prefix, sufix;
	
	private Candidate candidate ;

	/**
	 * Must be Called by f:viewAction After f:viewParam {page} 
	 */
	public void init(){		

		prefix = facesContext.getExternalContext().getRequestContextPath();

		sufix = "?faces-redirect=true";		

		try {				

			candidate = dao.findById(id);

		} catch (NotImplementedYetException e) {

			e.printStackTrace();

			goToErrorPage();

		}catch (Exception e) {
			
			e.printStackTrace();

			goToErrorPage();
		}
		
		if(candidate == null){
			goToErrorPage();
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
		mailNotification.doSendMessage(candidate, messageTitle, messageBody);

	}

	public void notifyByPush(){
		messagesHelper.addFlash(new FacesMessage("Push Message Enviado com Sucesso !"));
		pushNotification.doSendMessage(candidate, messageTitle, messageBody);

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

		try {

			facesContext.getExternalContext()
			.redirect(prefix + "/404.xhtml" + sufix);

		} catch (IOException e) {

			e.printStackTrace();
		}
		return prefix + "/404.xhtml" + sufix;
	}




}
