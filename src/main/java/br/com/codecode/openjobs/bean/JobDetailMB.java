package br.com.codecode.openjobs.bean;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.cdi.qualifier.Mockup;
import br.com.codecode.jsf.util.MessagesHelper;
import br.com.codecode.openjobs.model.scaffold.Job;

@Model
public class JobDetailMB {
	
	@Inject @Mockup
	private Crud<Job> dao;
	
	private Long id = 0L;
	
	private Job currentJob ;
	
	@Inject
	private MessagesHelper messagesHelper;
	
	public JobDetailMB(){}

	public void init(){
		
		System.out.println("JOB ID RECEIVED -> " + id);
		
		if(id > 0){
			currentJob = dao.findById(id);	
		}		
		
		if (currentJob == null){
			currentJob = new Job();
			currentJob.setId(0L);
			currentJob.setTitle("Não Encontrado");			
		
		}
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Job getCurrentJob() {
		return currentJob;
	}
	
	
	public void signup(){
		messagesHelper.addFlash(new FacesMessage("Você foi inscrito com Sucesso !"));
		
	}
	
	
	

}
