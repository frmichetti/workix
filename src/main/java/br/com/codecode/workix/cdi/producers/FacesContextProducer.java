/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

import br.com.codecode.workix.cdi.qualifiers.Factory;

/**
 * Faces Context Producer
 * 
 * @see Produces
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@ApplicationScoped
public class FacesContextProducer {

    /**
     * Produce FacesContext for CDI Injection Points
     * 
     * @return {@link FacesContext} Instance
     */
    @Produces
    @RequestScoped
    @Factory
    @Default
    public FacesContext getFacesContext() {
	return FacesContext.getCurrentInstance();
    }

}
