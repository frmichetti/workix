package br.com.codecode.akijob.bean;

import javax.annotation.PostConstruct;
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

	}

	@PostConstruct
	private void init(){
		prefix = "/" + facesContext.getExternalContext().getContextName();
		sufix = "?faces-redirect=true";
	}

	public String goToIndex(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/index.xhtml" + sufix;
	}

	public String goToJobs(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/jobs.xhtml" + sufix;
	}

	public String goToPostAJob(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/post-a-job.xhtml" + sufix;
	}

	public String goToCandidates(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/candidates.xhtml" + sufix;
	}


	public String goToPostAResume(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/post-a-resume.xhtml" + sufix;
	}


	public String goToAboutUs(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/about.xhtml" + sufix;
	}

}
