/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.cdi.qualifier.Push;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.jsf.util.MessagesHelper;
import br.com.codecode.workix.model.jpa.Candidate;

@Model
public class SendTokenMB extends BaseMB{

	private static final long serialVersionUID = -1733875145783240249L;

	@Inject @Push
	private Notification sendPush;

	@Inject
	private MessagesHelper messagesHelper;

	@Inject @Generic
	private Crud<Candidate> dao;

	@Inject
	private Candidate candidate;

	private String title,message;
	
	private List<Candidate> candidates;

	@PostConstruct
	@Override
	protected void init(){
		
		try {
			candidates = dao.listAll(0, Integer.MAX_VALUE);
			
		} catch (NotImplementedYetException e) {
			
			e.printStackTrace();
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCustomers(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate customer) {
		this.candidate = customer;
	}
	
	public void doSendPush(){
	
		sendPush.doSendMessage(candidate, title, message);

		messagesHelper.addFlash(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "Message sent successfully!"));
	}

	public void doSendPush(String title, String message, Candidate candidate){

		sendPush.doSendMessage(candidate, title, message);

		messagesHelper.addFlash(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "Message sent successfully!"));

	}

	public void doSendPush(String title, String message, Candidate ... candidates){

		for (Candidate c : candidates) {

			sendPush.doSendMessage(c, title, message);

			messagesHelper.addFlash(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "Message sent successfully!"));

		}

	}

	public String doBack() {		

		return "index.xhtml?faces-redirect=true";
	}
}
