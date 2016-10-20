/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.security;

import java.io.Serializable;
import java.security.Principal;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;


@Named
@ManagedBean
@SessionScoped
public class CurrentUserMB implements Serializable {

	private static final long serialVersionUID = 5093336500246912818L;

	@Inject
	private HttpServletRequest request;

	@Inject
	private SecurityDao securityDao;

	private JAASUser user;

	public CurrentUserMB() {
		System.out.println("----Security Bean------");
		System.out.println("[Creating Instance of " + this.getClass().getSimpleName() + "]");
		System.out.println("--> " + this.hashCode() + " <--");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("----Security Bean------");
		super.finalize();
	}

	public JAASUser get(){
		return this.user;
	}

	public boolean hasRole(String name){
		return request.isUserInRole(name);
	}

	@PostConstruct
	private void loadSystemUser(){

		Principal principal = request.getUserPrincipal();

		if(principal!=null){		
			this.user = securityDao.loadUserByUsername(principal.getName());			
		}
	}

}
