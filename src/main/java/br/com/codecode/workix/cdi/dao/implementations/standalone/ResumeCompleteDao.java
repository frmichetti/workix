package br.com.codecode.workix.cdi.dao.implementations.standalone;

import br.com.codecode.workix.cdi.dao.implementations.persist.BaseDao;
import br.com.codecode.workix.jpa.models.jdk7.Candidate;
import br.com.codecode.workix.jpa.models.jdk7.Resume;

/**
 * Stand Alone DAO for Resume
 *
 * @author felipe
 * @version 1.0
 * @see BaseDao
 * @since 1.0
 */
public class ResumeCompleteDao extends BaseDao {


    private static final long serialVersionUID = -5431107883362073057L;

    public Resume findResumebyOwner(Candidate candidate) {

        String jpql = "select r from Resume r where r.candidate = :candidate";

        Resume resume = em.createQuery(jpql, Resume.class).setParameter("candidate", candidate).getSingleResult();

        return resume;
    }

}
