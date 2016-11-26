package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.codecode.workix.jsf.util.MessagesHelper;

/**
 * This ManagedBean controls Search on HeaderPage
 *
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Model
public class SearchMB extends BaseMB {

	private static final long serialVersionUID = -7685004015144213436L;

	@Inject
	private MessagesHelper messagesHelper;

	private String query;	
	
	@PostConstruct
	@Override
	protected void init(){}
	
	public void doFind(){
		if (!query.equals("")){
			messagesHelper.addFlash(new FacesMessage("Looking for " + query));
		}
	}
	

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
