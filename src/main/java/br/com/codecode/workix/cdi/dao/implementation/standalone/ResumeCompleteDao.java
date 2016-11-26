package br.com.codecode.workix.cdi.dao.implementation.standalone;

import br.com.codecode.workix.cdi.dao.implementation.persist.BaseDao;
import br.com.codecode.workix.model.jpa.Candidate;
import br.com.codecode.workix.model.jpa.Resume;
/**
 * Stand Alone DAO for Resume
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class ResumeCompleteDao extends BaseDao {

	private static final long serialVersionUID = -5431107883362073057L;

	public Resume findResumebyOwner(Candidate candidate){

		String jpql = "select r from Resume r where r.candidate = :candidate";

		Resume resume = em.createQuery(jpql,Resume.class).
				setParameter("candidate",candidate).getSingleResult() ;

		return resume;
	}

}
