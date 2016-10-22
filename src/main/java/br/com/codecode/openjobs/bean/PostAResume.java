package br.com.codecode.openjobs.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.openjobs.model.scaffold.Candidate;
import br.com.codecode.openjobs.model.scaffold.Resume;

@Model
public class PostAResume {

	@Inject
	private Crud<Resume> dao;
	
	@Inject
	private Crud<Candidate> candidateDao;
	
	private Resume currentResume;
	
	private List<Candidate> candidates;
	
	public PostAResume() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init(){
		
		currentResume = new Resume();
		
		candidates = candidateDao.listAll(0, 100);
		
		debug();
		
	}

	private void debug() {
		currentResume.setContent("STUB CONTENT HERE");
		currentResume.setObjective("STUB OBJECTIVE");
		currentResume.setEducations("STUB EDUCATIONS HERE");
		currentResume.setExperiences("STUB EXPERIENCES HERE");
		currentResume.setOwner(candidates.get(candidates.size()-1));
		
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
	
	@Transactional
	public void commit(){		

		dao.create(currentResume);		

	}
	
	
}
