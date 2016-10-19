package br.com.codecode.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.codecode.model.scaffold.Candidate;

/**
 * DAO for Candidate
 */
@Stateless
public class CandidateDao {
	@PersistenceContext(unitName = "JPU")
	private EntityManager em;

	public void create(Candidate entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Candidate entity = em.find(Candidate.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Candidate findById(Long id) {
		return em.find(Candidate.class, id);
	}

	public Candidate update(Candidate entity) {
		return em.merge(entity);
	}

	public List<Candidate> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Candidate> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Candidate c ORDER BY c.id",
				Candidate.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
