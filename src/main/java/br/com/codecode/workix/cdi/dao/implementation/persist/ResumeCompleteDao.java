package br.com.codecode.workix.cdi.dao.implementation.persist;

import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Resume;

public class ResumeCompleteDao extends BaseDao {

	private static final long serialVersionUID = -5431107883362073057L;

	public Resume findResumebyOwner(Candidate candidate){

		String jpql = "select r from Resume r where r.candidate = :candidate";

		Resume resume = em.createQuery(jpql,Resume.class).
				setParameter("candidate",candidate).getSingleResult() ;

		return resume;
	}

}
