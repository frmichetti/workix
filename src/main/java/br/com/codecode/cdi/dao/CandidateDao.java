package br.com.codecode.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.cdi.qualifier.Persist;
import br.com.codecode.openjobs.model.scaffold.Candidate;

/**
 * DAO for Candidate
 */
@Persist
public class CandidateDao extends BasicDao implements Crud<Candidate> {

	private static final long serialVersionUID = -4430675125218575581L;
	
	
	@Override
	public void create(Candidate entity) {
		em.persist(entity);
	}

	@Override
	public void deleteById(Long id) {
		Candidate entity = em.find(Candidate.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public Candidate findById(Long id) {
		return em.find(Candidate.class, id);
	}

	@Override
	public Candidate update(Candidate entity) {
		return em.merge(entity);
	}
	
	@Override
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

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM Candidate").getSingleResult();
	}

	
}
