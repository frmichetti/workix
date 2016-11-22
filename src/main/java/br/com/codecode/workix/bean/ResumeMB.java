package br.com.codecode.workix.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.dao.implementation.persist.ResumeCompleteDao;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.cdi.qualifier.Push;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.jsf.util.MessagesHelper;
import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Education;
import br.com.codecode.workix.model.scaffold.Experience;
import br.com.codecode.workix.model.scaffold.Resume;
import br.com.codecode.workix.model.scaffold.Skill;

@Model
public class ResumeMB implements Serializable {

	private static final long serialVersionUID = 3136618928143380363L;

	@Inject @Generic
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

	private List<Skill> skills = new ArrayList<>();

	private List<Education> educations = new ArrayList<>();

	private List<Experience> experiences = new ArrayList<>();

	public ResumeMB(){}

	/**
	 * Must be Called by f:viewAction After f:viewParam {@link page} 
	 */
	public void init(){

		System.out.println("Candidate ID RECEIVED -> " + id);

		try {

			candidate = dao.findById(id);

		} catch (NotImplementedYetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			goToErrorPage();
		}	

		if(candidate == null){
			goToErrorPage();
		}

		resume = daoResume.findResumebyOwner(candidate);

		if(resume == null){
			goToErrorPage();
		}

		skills.addAll(resume.getSkills());

		educations.addAll(resume.getEducations());

		experiences.addAll(resume.getExperiences());

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

	public List<Skill> getSkills() {
		return skills;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void notifyByEmail(){
		messagesHelper.addFlash(new FacesMessage("Email Enviado com Sucesso !"));
	}

	public void notifyByPush(){
		messagesHelper.addFlash(new FacesMessage("Push Message Enviado com Sucesso !"));
		notification.doSendMessage(resume.getCandidate(), messageTitle, messageBody);
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
