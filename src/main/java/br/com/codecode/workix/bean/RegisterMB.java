package br.com.codecode.workix.bean;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.jpa.User;

@Model
public class RegisterMB extends BaseMB {

	private static final long serialVersionUID = 2464412752323820654L;

	@Inject @Factory @Default
	private FacesContext facescontext;

	@Inject @Generic
	private Crud<User> dao;

	@Inject
	private User user;

	private String fbEmail,fbToken;
	
	public String doRegister(){	
		
		ExternalContext ec = facescontext.getExternalContext();
		
		fbEmail = ec.getRequestParameterMap().get("fbUser");	

		fbToken = ec.getRequestParameterMap().get("fbToken");
		
		System.out.println("[doRegister]");
		
		System.out.println(fbEmail);
		
		System.out.println(fbToken);

		try {
			
			dao.saveOrUpdate(user);
			
		} catch (IllegalArgumentException | NotImplementedYetException e) {
			
			e.printStackTrace();
		}

		return "main.xhtml";
	}

	public FacesContext getFacescontext() {
		return facescontext;
	}

	public void setFacescontext(FacesContext facescontext) {
		this.facescontext = facescontext;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFbEmail() {
		return fbEmail;
	}

	public void setFbEmail(String fbEmail) {
		this.fbEmail = fbEmail;
	}

	public String getFbToken() {
		return fbToken;
	}

	public void setFbToken(String fbToken) {
		this.fbToken = fbToken;
	}





}

