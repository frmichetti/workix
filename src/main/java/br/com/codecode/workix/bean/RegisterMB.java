package br.com.codecode.workix.bean;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.model.scaffold.User;

@Model
public class RegisterMB implements Serializable {

	private static final long serialVersionUID = 2464412752323820654L;

	@Inject
	private FacesContext facescontext;

	@Inject @Generic
	private Crud<User> dao;

	@Inject
	private User user;

	private String fbEmail,fbToken;
	
	public String doRegister(){	
		
		fbEmail = facescontext.getExternalContext().getRequestParameterMap().get("fbUser");	

		fbToken = facescontext.getExternalContext().getRequestParameterMap().get("fbToken");
		
		System.out.println("[doRegister]");
		
		System.out.println(fbEmail);
		
		System.out.println(fbToken);

		//dao.saveOrUpdate(user);

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

