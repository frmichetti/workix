/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.openjobs.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.openjobs.model.scaffold.User;

@Model
public class UserMB implements Serializable {

	private static final long serialVersionUID = -5397549790844672393L;	
	
	@Inject
	private Crud<User> userDao;
	
	private User activeObject;

	public UserMB(){}
	
	public User getActiveObject() {
		return activeObject;
	}

	public void setActiveObject(User user) {
		this.activeObject = user;
	}
	
	
	@PostConstruct
	private void doInit() {		
		activeObject = new User();
	}
	
	
	public void save(){
		userDao.create(activeObject);
	}
	

}
