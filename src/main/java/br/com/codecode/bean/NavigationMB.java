package br.com.codecode.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ApplicationScoped
@ManagedBean
@Named
public class NavigationMB {
	
	private String prefix;
	
	private String sufix; 	
	
	public NavigationMB() {
		prefix = "/jobs";
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
