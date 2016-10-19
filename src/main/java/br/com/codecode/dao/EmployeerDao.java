package br.com.codecode.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.codecode.model.scaffold.Employeer;

/**
 * DAO for Employeer
 */
@Stateless
public class EmployeerDao {
	@PersistenceContext(unitName = "JPU")
	private EntityManager em;

	public void create(Employeer entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Employeer entity = em.find(Employeer.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Employeer findById(Long id) {
		return em.find(Employeer.class, id);
	}

	public Employeer update(Employeer entity) {
		return em.merge(entity);
	}

	public List<Employeer> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Employeer> findAllQuery = em.createQuery(
				"SELECT DISTINCT e FROM Employeer e ORDER BY e.id",
				Employeer.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
