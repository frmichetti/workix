package br.com.codecode.workix.beans;

import java.io.IOException;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;

/**
 * Job Detail ManagedBean
 * @author felipe
 * @see BaseMB
 */
@Model
public class JobDetailMB extends BaseMB {

    @Inject
    @Generic
    private Crud<Job> dao;

    private long id;

    private Job currentJob;

    @Inject
    @Factory
    @Default
    private FacesContext facesContext;

    private String prefix, sufix;

    @Inject
    private MessagesHelper messagesHelper;

    /**
     * Must be Called by f:viewAction After f:viewParam {page}
     */
    @Override
    public void init() {

	prefix = facesContext.getExternalContext().getRequestContextPath();

	sufix = "?faces-redirect=true";

	System.out.println("JOB ID RECEIVED -> " + id);

	if (id < 1)
	    goToErrorPage();
	else

	    try {

		currentJob = dao.findById(id);

	    } catch (NotImplementedYetException e) {

		e.printStackTrace();

		goToErrorPage();

	    } catch (NoResultException e) {

		e.printStackTrace();

		goToErrorPage();
	    }

	if (currentJob == null) {
	    goToErrorPage();
	}

    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Job getCurrentJob() {
	return currentJob;
    }

    public void signup() {
	messagesHelper.addFlash(new FacesMessage("Você foi inscrito com Sucesso !"));

    }

    private String goToErrorPage() {

	try {

	    facesContext.getExternalContext().redirect(prefix + "/404.xhtml" + sufix);

	} catch (IOException e) {

	    e.printStackTrace();
	}
	return prefix + "/404.xhtml" + sufix;
    }

}
