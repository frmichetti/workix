/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.security;

import java.io.Serializable;
import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.codecode.workix.interfaces.Debugable;
import br.com.codecode.workix.security.model.JAASUser;

/**
 * This Class Verify for {@link JAASUser} is Signed In Session
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Serializable
 * @see Debugable
 */
@Named
@SessionScoped
public class CurrentUserMB implements Serializable, Debugable {

    private static final long serialVersionUID = 5093336500246912818L;

    @Inject
    private HttpServletRequest request;

    @Inject
    private SecurityDao securityDao;

    private JAASUser user;

    @PostConstruct
    private void init() {

	System.out.println("----Security Bean------");

	Debugable.super.onStart();

	loadSystemUser();
    }

    @Override
    protected void finalize() throws Throwable {
	System.out.println("----Security Bean------");
	super.finalize();
    }

    public JAASUser get() {
	return this.user;
    }

    public boolean hasRole(String name) {
	return request.isUserInRole(name);
    }

    private void loadSystemUser() {

	Principal principal = request.getUserPrincipal();

	if (principal != null) {
	    this.user = securityDao.loadUserByUsername(principal.getName());
	}
    }

}
