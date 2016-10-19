package br.com.codecode.bean;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.dao.JobDao;
import br.com.codecode.model.scaffold.Job;

@Model
public class JobDetailMB {
	
	@Inject
	private JobDao dao;
	
	private Long id = 0L;
	
	private Job currentJob ;
	
	public JobDetailMB() {
	
	}

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

	public void setId(Long jobId) {
		this.id = jobId;
	}

	public Job getCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(Job currentJob) {
		this.currentJob = currentJob;
	}
	
	
	
	

}
