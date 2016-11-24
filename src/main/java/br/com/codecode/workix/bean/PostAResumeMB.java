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

/**
 * This ManagedBean controls post-a-resume.xhtml
 * @author felipe
 *
 */
@Model
public class PostAResumeMB extends BaseMB {

	private static final long serialVersionUID = 5277171937444867580L;

	@Inject @Generic
	private Crud<Resume> dao;
	
	@Inject @Generic
	private Crud<Candidate> candidateDao;
	
	@Inject
	private Resume currentResume;
	
	private List<Candidate> candidates;
		
	@PostConstruct
	private void init(){
				
		try {
			candidates = candidateDao.listAll(0, 100);
		} catch (NotImplementedYetException e) {
		
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
		
			e.printStackTrace();
		}		

	}
	
	
}
