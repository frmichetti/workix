package br.com.codecode.workix.cdi.dao.implementation.persist;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Resume;

public class ResumeCompleteDao implements Serializable {

	private static final long serialVersionUID = -5431107883362073057L;

	@PersistenceContext(unitName="DefaultPU")
	private EntityManager em;

	public Resume findResumebyOwner(Candidate candidate){

		String jpql = "select r from Resume r where r.candidate = :candidate";

		Resume resume = em.createQuery(jpql,Resume.class).
				setParameter("candidate",candidate).getSingleResult() ;

		return resume;
	}

}
