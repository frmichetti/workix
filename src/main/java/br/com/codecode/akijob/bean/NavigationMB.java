package br.com.codecode.akijob.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@ManagedBean
@Named
public class NavigationMB {
	
	@Inject
	private FacesContext facesContext;
	
	private String prefix;
	
	private String sufix; 	
	
	public NavigationMB() {
		prefix = facesContext.getExternalContext().getContextName();
		sufix = "?faces-redirect=true";
	}
	
	public String goToIndex(){
		return prefix + "/index.xhtml" + sufix;
	}
	
	public String goToJobs(){
		return prefix + "/jobs.xhtml" + sufix;
	}
	
	public String goToPostAJob(){
		return prefix + "/post-a-job.xhtml" + sufix;
	}
	
	public String goToCandidates(){
		return prefix + "/candidates.xhtml" + sufix;
	}
	
	
	public String goToPostAResume(){
		return prefix + "/post-a-resume.xhtml" + sufix;
	}

	
	public String goToAboutUs(){
		return prefix + "/about.xhtml" + sufix;
	}

}
