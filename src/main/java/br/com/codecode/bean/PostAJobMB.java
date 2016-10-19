package br.com.codecode.bean;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.codecode.dao.JobDao;
import br.com.codecode.model.scaffold.Job;

@Model
public class PostAJobMB {
	
	@Inject
	private JobDao dao;
	
	private Job currentJob;
	
	public PostAJobMB() {
		
	}
	
	@PostConstruct
	private void init(){
		currentJob = new Job();
		debug();
	}

	private void debug() {
		if (currentJob != null){
			currentJob.setId(null);
			currentJob.setTitle("Title Here");
			currentJob.setCity("City Here");
			currentJob.setDescription("Resume Here");
			
			
		}
		
	}

	public Job getCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(Job currentJob) {
		this.currentJob = currentJob;
	}
	
	@Transactional
	public void commit(){
		
		
		
		dao.create(currentJob);
		
		
	}
	
	

}
