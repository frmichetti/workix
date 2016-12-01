package br.com.codecode.workix.beans;

import java.io.IOException;
import java.util.ArrayList;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.dao.implementations.standalone.ResumeCompleteDao;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifiers.Email;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.cdi.qualifiers.Push;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Education;
import br.com.codecode.workix.jpa.models.Experience;
import br.com.codecode.workix.jpa.models.Resume;
import br.com.codecode.workix.jpa.models.Skill;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;

/**
 * This ManagedBean controls resume.xhtml
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 */
@Model
public class ResumeMB extends BaseMB {

    @Inject
    @Generic
    private Crud<Candidate> dao;

    @Inject
    private ResumeCompleteDao daoResume;

    @Inject
    @Push
    private Notification notification;

    @Inject
    @Email
    private Notification mailNotification;

    @Inject
    @Factory
    @Default
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
    @Override
    public void init() {

	prefix = facesContext.getExternalContext().getRequestContextPath();

	sufix = "?faces-redirect=true";

	System.out.println("Candidate ID RECEIVED -> " + id);

	try {

	    Candidate candidate = dao.findById(id);

	    if (candidate == null)
		goToErrorPage();
	    else
		resume = daoResume.findResumebyOwner(candidate);

	    if (resume == null) goToErrorPage();

	} catch (NotImplementedYetException | NoResultException e) {

	    e.printStackTrace();

	}

	ArrayList<Skill> skillList = new ArrayList<>();

	skillList.addAll(resume.getSkills());

	skills = new ListDataModel<Skill>(skillList);

	ArrayList<Education> educationList = new ArrayList<>();

	educationList.addAll(resume.getEducations());

	educations = new ListDataModel<>(educationList);

	ArrayList<Experience> experienceList = new ArrayList<>();

	experienceList.addAll(resume.getExperiences());

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

    public void notifyByEmail() {
	messagesHelper.addFlash(new FacesMessage("Email Enviado com Sucesso !"));
	mailNotification.doSendMessage(resume.getCandidate().getUser(), messageTitle, messageBody);
    }

    public void notifyByPush() {
	messagesHelper.addFlash(new FacesMessage("Push Message Enviado com Sucesso !"));
	notification.doSendMessage(resume.getCandidate().getUser(), messageTitle, messageBody);
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

    private void goToErrorPage() {

	try {

	    facesContext.getExternalContext().redirect(prefix + "/404.xhtml" + sufix);

	} catch (IOException e) {

	    e.printStackTrace();
	}

    }

}
