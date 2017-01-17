package br.com.codecode.workix.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Subscriber;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;

/**
 * This ManagedBean controls Signup Fragment in footer.xhtml
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 */
@Model
public class SignupMB extends BaseMB {

    @Inject
    private MessagesHelper messagesHelper;

    @Inject
    @Generic
    private Crud<Subscriber> dao;

    private String email;

    @PostConstruct
    @Override
    protected void init() {
    }

    @Transactional
    public void addToList() {

	Subscriber subscriber = new Subscriber.Builder(email).build();

	try {

	    dao.save(subscriber);

	    messagesHelper.addFlash(new FacesMessage(FacesMessage.SEVERITY_INFO,
		    subscriber.getEmail() + " inscrito na Lista de Novidades", "Obrigado!"));

	} catch (NotImplementedYetException e) {

	    e.printStackTrace();

	    messagesHelper.addFlash(new FacesMessage(FacesMessage.SEVERITY_ERROR,
		    "Error on Save " + subscriber.getEmail(), "Not Implemented Yet"));

	} catch (Exception e) {

	    e.printStackTrace();

	    messagesHelper.addFlash(new FacesMessage(FacesMessage.SEVERITY_ERROR,
		    "Error on Save " + subscriber.getEmail(), e.toString()));
	}

    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

}
