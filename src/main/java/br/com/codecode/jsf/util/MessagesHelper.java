/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.jsf.util;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@RequestScoped
public class MessagesHelper {

    @Inject
    private FacesContext facesContext;
    
    public void addFlash(FacesMessage facesMessage){
    	
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        
        facesContext.addMessage(null, facesMessage);
        
    }
}
