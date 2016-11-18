package br.com.codecode.workix.bean;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.jsf.util.MessagesHelper;
import br.com.codecode.workix.model.scaffold.Job;

@Model
public class JobDetailMB {
	
	@Inject @Generic
	private Crud<Job> dao;
	
	private Long id;
	
	private Job currentJob ;
	
	@Inject
	private MessagesHelper messagesHelper;
	
	public JobDetailMB(){}

	public void init(){
		
		System.out.println("JOB ID RECEIVED -> " + id);
		
		if(id == null || id ==0){
			goToError();
		}
		
		if(id > 0){
			currentJob = dao.findById(id);	
		}		
		
		if (currentJob == null){
			goToError();			
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
	
	private String goToError() {
		return "404.xhtml?faces-redirect=true";
		
	}
	
	
	

}
