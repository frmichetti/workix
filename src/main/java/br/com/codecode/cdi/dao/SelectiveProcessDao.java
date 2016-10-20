package br.com.codecode.cdi.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.openjobs.model.scaffold.SelectiveProcess;

/**
 * DAO for SelectiveProcess
 */

public class SelectiveProcessDao extends BasicDao implements Crud<SelectiveProcess> {

	private static final long serialVersionUID = 5942334208981147237L;

	public void create(SelectiveProcess entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		SelectiveProcess entity = em.find(SelectiveProcess.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public SelectiveProcess findById(Long id) {
		return em.find(SelectiveProcess.class, id);
	}

	public SelectiveProcess update(SelectiveProcess entity) {
		return em.merge(entity);
	}

	public List<SelectiveProcess> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<SelectiveProcess> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SelectiveProcess s LEFT JOIN FETCH s.job LEFT JOIN FETCH s.employeer LEFT JOIN FETCH s.candidates ORDER BY s.id",
						SelectiveProcess.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
