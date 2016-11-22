/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * Faces Context Producer
 * @author felipe
 *
 */
@ApplicationScoped
public class FacesContextProducer {
	
	/**
	 * Produce FacesContext for CDI Injection Points 
	 * @return {@link FacesContext} Instance
	 */
	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {    	
		return FacesContext.getCurrentInstance();        
	}

}
