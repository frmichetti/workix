/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.jpa.User;
/**
 * User ManagedBean
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Model
public class UserMB extends BaseMB {		
	
	@Inject @Generic
	private Crud<User> userDao;
	
	@Inject
	private User user;	
	
	@PostConstruct
	@Override
	protected void init(){}	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
	public void save(){
		
		try {
			
			userDao.save(user);
			
		} catch (NotImplementedYetException e) {
			
			e.printStackTrace();
		}
	}

	
	

}
