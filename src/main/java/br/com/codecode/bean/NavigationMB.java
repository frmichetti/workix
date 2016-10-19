package br.com.codecode.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ApplicationScoped
@ManagedBean
@Named
public class NavigationMB {
	
	private String context; 
	
	
	public NavigationMB() {
		context = "/jobs";
	}
	
	public String goToIndex(){
		return context + "/index.xhtml";
	}
	
	public String goToJobs(){
		return context + "/jobs.xhtml";
	}
	
	public String goToPostAJob(){
		return context + "/post-a-job.xhtml";
	}
	
	public String goToCandidates(){
		return context + "/candidates.xhtml";
	}
	
	
	public String goToPostAResume(){
		return context + "/post-a-resume.xhtml";
	}

}
