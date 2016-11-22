package br.com.codecode.workix.bean;

import java.io.IOException;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.jsf.util.MessagesHelper;
import br.com.codecode.workix.model.scaffold.Job;

@Model
public class JobDetailMB {

	@Inject @Generic
	private Crud<Job> dao;

	private Long id;

	private Job currentJob ;

	@Inject @Factory
	private FacesContext facesContext;

	private String prefix, sufix;

	@Inject
	private MessagesHelper messagesHelper;

	public JobDetailMB(){}


	/**
	 * Must be Called by f:viewAction After f:viewParam {@link page} 
	 */
	public void init(){

		prefix = facesContext.getExternalContext().getRequestContextPath();

		sufix = "?faces-redirect=true";

		System.out.println("JOB ID RECEIVED -> " + id);

		if(id == null || id ==0){
			goToErrorPage();
		}

		if(id > 0){

			try {

				currentJob = dao.findById(id);

			} catch (NotImplementedYetException e) {

				e.printStackTrace();

				goToErrorPage();

			}catch (Exception e) {
				
				e.printStackTrace();

				goToErrorPage();
			}

		}		

		if (currentJob == null){
			goToErrorPage();			
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

	private String goToErrorPage(){	

		try {

			facesContext.getExternalContext().redirect(prefix + "/404.xhtml" + sufix);

		} catch (IOException e) {

			e.printStackTrace();
		}
		return prefix + "/404.xhtml" + sufix;
	}




}
