package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.qualifiers.Factory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * This ManagedBean Shares info in index.xhtml Execute with
 * {@link ApplicationScoped}
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 * @see Serializable
 */
@Named
@ApplicationScoped
public class ApplicationMB extends BaseMB implements Serializable {

   
    private static final long serialVersionUID = -4759086144184129975L;

    private String appName, slogan;

    private int year;

    @Inject
    @Factory
    @Default
    private FacesContext context;

    @PostConstruct
    @Override
    protected void init() {

	ExternalContext exContext = context.getExternalContext();

	appName = exContext.getInitParameter("appName");

	slogan = exContext.getInitParameter("slogan");

	year = LocalDate.now().getYear();

    }

    public String getAppName() {
	return appName;
    }

    public String getSlogan() {
	return slogan;
    }

    public int getYear() {
	return year;
    }

}
