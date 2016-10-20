package br.com.codecode.cdi.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.akijob.model.scaffold.Job;

/**
 * DAO for Job
 */

public class JobDao extends BasicDao implements Crud<Job>{

	private static final long serialVersionUID = 4029639665489024760L;
	
	public void create(Job entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Job entity = em.find(Job.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Job findById(Long id) {
		return em.find(Job.class, id);
	}

	public Job update(Job entity) {
		return em.merge(entity);
	}

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
}
