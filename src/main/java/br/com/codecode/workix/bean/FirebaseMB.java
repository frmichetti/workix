package br.com.codecode.workix.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class FirebaseMB implements Serializable {

	private String name,email,uid,photo;

	private String idToken;
	
	@Inject
	private FacesContext context; 

	private static final long serialVersionUID = -6683482350467577281L;	

	public FirebaseMB() {
		System.out.println("[CDI] " + getClass().getSimpleName());
	}
	
	@PostConstruct
	private void init(){}

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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIdToken() {
		System.out.println("TOKEN " + idToken);
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
		System.out.println("TOKEN " + idToken);
	}


}
