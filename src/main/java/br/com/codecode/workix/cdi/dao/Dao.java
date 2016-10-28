package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public class Dao<T> implements Serializable {

	private static final long serialVersionUID = 8476110516365062871L;

	private final Class<T> classe;
	
	  @PersistenceContext
	  private EntityManager em;
	 
	  public Dao(Class<T> classe) {
	    this.classe = classe;
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
	    CriteriaQuery query = em.getCriteriaBuilder().createQuery(classe);
	    query.from(classe);
	    return em.createQuery(query).getResultList();
	  }
	 
	  public T findById(Long id) {
	    return em.find(classe,id);
	  }
	}
