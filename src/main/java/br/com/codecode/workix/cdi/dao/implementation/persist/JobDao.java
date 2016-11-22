package br.com.codecode.workix.cdi.dao.implementation.persist;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Persist;
import br.com.codecode.workix.model.scaffold.Job;

/**
 * DAO for Job
 */
@Persist
public class JobDao extends BaseDao implements Crud<Job>{

	private static final long serialVersionUID = 4029639665489024760L;

	@Override
	public void save(Job entity) {
		em.persist(entity);
	}

	@Override
	public void deleteById(long id) {
		Job entity = em.find(Job.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public Job findById(long id) {
		return em.find(Job.class, id);
	}

	@Override
	public Job update(Job entity) {
		return em.merge(entity);
	}

	@Override
	public List<Job> listAll(int startPosition, int maxResult) {
		TypedQuery<Job> findAllQuery = em.createQuery(
				"SELECT DISTINCT j FROM Job j ORDER BY j.id", Job.class);

		findAllQuery.setFirstResult(startPosition);

		findAllQuery.setMaxResults(maxResult);

		return findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + Job.class.getSimpleName()).getSingleResult();
	}	

	@Override
	public Job findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
