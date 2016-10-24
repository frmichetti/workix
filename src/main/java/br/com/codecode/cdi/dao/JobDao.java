package br.com.codecode.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.cdi.qualifier.Persist;
import br.com.codecode.openjobs.model.scaffold.Job;

/**
 * DAO for Job
 */
@Persist
public class JobDao extends BasicDao implements Crud<Job>{

	private static final long serialVersionUID = 4029639665489024760L;
	
	@Override
	public void create(Job entity) {
		em.persist(entity);
	}

	@Override
	public void deleteById(Long id) {
		Job entity = em.find(Job.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public Job findById(Long id) {
		return em.find(Job.class, id);
	}

	@Override
	public Job update(Job entity) {
		return em.merge(entity);
	}

	@Override
	public List<Job> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Job> findAllQuery = em.createQuery(
				"SELECT DISTINCT j FROM Job j ORDER BY j.id", Job.class);
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
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM Job").getSingleResult();
	}
}
