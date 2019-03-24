package br.com.codecode.workix.beans;

import br.com.codecode.workix.jsf.util.helper.MessagesHelper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

/**
 * This ManagedBean controls Search on HeaderPage
 *
 * @author felipe
 * @version 1.1
 * @see BaseMB
 * @since 1.0
 */
@Model
public class SearchMB extends BaseMB {

    @Inject
    private MessagesHelper messagesHelper;

    private String query;

    @PostConstruct
    @Override
    protected void init() {
    }

    public void doFind() {
        if (!query.equals("")) {
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
