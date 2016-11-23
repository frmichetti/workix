package br.com.codecode.workix.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.jpa.Candidate;
import br.com.codecode.workix.model.jpa.Resume;

@Model
public class PostAResume {

	@Inject @Generic
	private Crud<Resume> dao;
	
	@Inject @Generic
	private Crud<Candidate> candidateDao;
	
	private Resume currentResume;
	
	private List<Candidate> candidates;
	
	public PostAResume(){}
	
	@PostConstruct
	private void init(){
		
		currentResume = new Resume();
		
		try {
			candidates = candidateDao.listAll(0, 100);
		} catch (NotImplementedYetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		debug();
		
	}

	private void debug() {
		currentResume.setContent("STUB CONTENT HERE");
		currentResume.setObjective("STUB OBJECTIVE");		
		currentResume.setCandidate(candidates.get(candidates.size()-1));
		
	}

	public Resume getCurrentResume() {
		return currentResume;
	}

	public void setCurrentResume(Resume currentResume) {
		this.currentResume = currentResume;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}
		
	public void commit(){		

		try {
			dao.save(currentResume);
		} catch (NotImplementedYetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	
	
}
