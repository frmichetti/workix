package br.com.codecode.workix.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.dao.implementation.standalone.ResumeCompleteDao;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifier.Email;
import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.cdi.qualifier.Push;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.interfaces.Notificable;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;
import br.com.codecode.workix.model.jpa.Candidate;
import br.com.codecode.workix.model.jpa.Education;
import br.com.codecode.workix.model.jpa.Experience;
import br.com.codecode.workix.model.jpa.Resume;
import br.com.codecode.workix.model.jpa.Skill;

/**
 * This ManagedBean controls resume.xhtml
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Model
public class ResumeMB extends BaseMB {	

	@Inject @Generic
	private Crud<Candidate> dao;

	@Inject 
	private ResumeCompleteDao daoResume;

	@Inject @Push
	private Notification notification;	

	@Inject @Email
	private Notification mailNotification;

	@Inject @Factory @Default
	private FacesContext facesContext;

	@Inject 
	private MessagesHelper messagesHelper;

	private long id;		

	private String prefix, sufix, messageTitle, messageBody;	

	private Resume resume;

	private DataModel<Skill> skills;

	private DataModel<Education> educations;

	private DataModel<Experience> experiences;	

	/**
	 * Must be Called by f:viewAction After f:viewParam {page} 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void init(){

		prefix = facesContext.getExternalContext().getRequestContextPath();

		sufix = "?faces-redirect=true";

		System.out.println("Candidate ID RECEIVED -> " + id);	

		try {

			Candidate candidate = dao.findById(id);

			if(candidate == null)
				goToErrorPage();
			else
				resume = daoResume.findResumebyOwner(candidate);

			if(resume == null)
				goToErrorPage();

		} catch (NotImplementedYetException | NoResultException e) {

			e.printStackTrace();	

		}


		ArrayList<Skill> skillList = new ArrayList<>();

		skillList.addAll((Collection<? extends Skill>) resume.getSkills());

		skills = new ListDataModel<Skill>(skillList);


		ArrayList<Education> educationList = new ArrayList<>();

		educationList.addAll((Collection<? extends Education>) resume.getEducations());

		educations = new ListDataModel<>(educationList);


		ArrayList<Experience> experienceList = new ArrayList<>();

		experienceList.addAll((Collection<? extends Experience>) resume.getExperiences());

		experiences = new ListDataModel<>(experienceList);

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public Resume getResume() {
		return resume;
	}

	public DataModel<Skill> getSkills() {
		return skills;
	}

	public DataModel<Education> getEducations() {
		return educations;
	}

	public DataModel<Experience> getExperiences() {
		return experiences;
	}

	public void notifyByEmail(){
		messagesHelper.addFlash(new FacesMessage("Email Enviado com Sucesso !"));
		mailNotification.doSendMessage((Notificable) resume.getCandidate().getUser(), messageTitle, messageBody);
	}

	public void notifyByPush(){
		messagesHelper.addFlash(new FacesMessage("Push Message Enviado com Sucesso !"));
		notification.doSendMessage((Notificable) resume.getCandidate().getUser(), messageTitle, messageBody);
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

	private void goToErrorPage(){		

		try {			

			facesContext.getExternalContext()
			.redirect(prefix + "/404.xhtml" + sufix);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}


}
