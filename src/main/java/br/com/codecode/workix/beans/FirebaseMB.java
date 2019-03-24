package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.qualifiers.Factory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Firebase ManagedBean
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 * @see Serializable
 */
@Named
@SessionScoped
public class FirebaseMB extends BaseMB implements Serializable {

   
    private static final long serialVersionUID = -893904762220030419L;

    private String name, email, uid, photo, idToken;

    @Inject
    @Factory
    @Default
    private FacesContext context;

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
