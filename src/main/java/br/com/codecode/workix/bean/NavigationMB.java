package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.codecode.workix.cdi.qualifier.Factory;

/**
 * This ManagedBean Shares info for navigation
 * Execute with {@link ApplicationScoped}
 * @author felipe
 *
 */
@Named
@ApplicationScoped
public class NavigationMB extends BaseMB {

	private static final long serialVersionUID = -8996534359439775766L;

	@Inject @Factory @Default
	private FacesContext facesContext;

	private String prefix, sufix;

	@PostConstruct
	private void init(){
		prefix = facesContext.getExternalContext().getRequestContextPath();
		sufix = "?faces-redirect=true";
	}

	public String goToIndex(){		
		return prefix + "/index.xhtml" + sufix;
	}

	public String goToJobs(){		
		return prefix + "/jobs2.xhtml?page=1" + sufix.replace("?", "&");
	}

	public String goToPostAJob(){		
		return prefix + "/post-a-job.xhtml" + sufix;
	}

	public String goToCandidates(){		
		return prefix + "/candidates2.xhtml?page=1" + sufix.replace("?", "&");
	}


	public String goToPostAResume(){		
		return prefix + "/post-a-resume.xhtml" + sufix;
	}


	public String goToAboutUs(){		
		return prefix + "/about.xhtml" + sufix;
	}
	
	public String goToGooglePlayStore(){		
		return "https://play.google.com/store/apps/details?id=br.com.frmichetti.openjobs.android";
	}
	
	public String goToYoutube(){
		return "https://www.youtube.com/embed/VqHbQ-WwMfk";
	}

}
