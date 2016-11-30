package br.com.codecode.workix.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;
import br.com.codecode.workix.mail.MailSender;

/**
 * This ManagedBean controls Contact Fragment in fragments/contact.xhtml
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Model
public class ContactMB extends BaseMB {

    @Inject
    private MessagesHelper messagesHelper;

    @Inject
    @Factory
    private ManagedExecutorService managedExecutorService;

    @Inject
    private MailSender mailSender;

    private String name, email, subject, body;

    @PostConstruct
    @Override
    protected void init() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getBody() {
	return body;
    }

    public void setBody(String body) {
	this.body = body;
    }

    public void doSendAMessage() {

	managedExecutorService.execute(() -> {

	    System.out.println("[DEBUG - doSendAMessage]");

	    System.out.println("Received Name " + getName());

	    System.out.println("Received Email " + getEmail());

	    System.out.println("Received Subject " + getSubject());

	    System.out.println("Received Body Message " + getBody());

	    mailSender.send(email, email, subject, body);

	});

	showMessage();
    }

    private String showMessage() {

	messagesHelper
		.addFlash(new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem Enviada com Sucesso", "Obrigado!"));

	return "./index.xhtml?faces-redirect=true";
    }

}