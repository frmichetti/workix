package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public class Dao<T> implements Serializable {

	private static final long serialVersionUID = 8476110516365062871L;

	private final Class<T> clazz;

	@PersistenceContext(unitName="DefaultPU")
	private EntityManager em;

	public Dao(Class<T> clazz, EntityManager em) {
		this.clazz = clazz;
		this.em = em;
	}

	public void save(T obj) {
		em.persist(obj);
	}

	public void remove(T obj) {
		em.remove(obj);
	}

	public void update(T obj) {
		em.merge(obj);
	}

	public List<T> listAll() {
		CriteriaQuery query = em.getCriteriaBuilder().createQuery(clazz);
		query.from(clazz);
		return em.createQuery(query).getResultList();
	}

	public T findById(Long id) {
		return em.find(clazz,id);
	}
}
