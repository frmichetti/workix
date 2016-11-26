/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.jsf.util.helper;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.producer.FacesContextProducer;
import br.com.codecode.workix.cdi.qualifier.Factory;

/**
 * JSF Messages Helper
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see FacesContextProducer
 */
@RequestScoped
public class MessagesHelper {

    @Inject @Factory @Default
    private FacesContext facesContext;
    
    public void addFlash(FacesMessage facesMessage){
    	
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        
        facesContext.addMessage(null, facesMessage);
        
    }
}
