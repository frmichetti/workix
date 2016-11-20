package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named
public class NavigationMB {

	@Inject
	private FacesContext facesContext;

	private String prefix;

	private String sufix; 	

	public NavigationMB(){}

	@PostConstruct
	private void init(){
		prefix = facesContext.getExternalContext().getRequestContextPath();
		sufix = "?faces-redirect=true";
	}

	public String goToIndex(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/index.xhtml" + sufix;
	}

	public String goToJobs(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/jobs2.xhtml?page=1" + sufix.replace("?", "&");
	}

	public String goToPostAJob(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/post-a-job.xhtml" + sufix;
	}

	public String goToCandidates(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/candidates2.xhtml?page=1" + sufix.replace("?", "&");
	}


	public String goToPostAResume(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/post-a-resume.xhtml" + sufix;
	}


	public String goToAboutUs(){
		System.out.println("Redirect to -> " + prefix + "/index.xhtml" + sufix );
		return prefix + "/about.xhtml" + sufix;
	}
	
	public String goToGooglePlayStore(){		
		return "https://play.google.com/store/apps/details?id=br.com.frmichetti.openjobs.android";
	}
	
	public String goToYoutube(){
		return "https://www.youtube.com/embed/VqHbQ-WwMfk";
	}

}
