package br.com.codecode.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.com.codecode.openjobs.model.scaffold.Resume;

/**
 * DAO for Resume
 */
@Stateless
public class ResumeDao extends BasicDao implements Crud<Resume>{

	private static final long serialVersionUID = 4029639665489024760L;
	
	@Inject
	private Event<Resume> alertNewResume;
	
	@Override
	public void create(Resume entity) {
		
		em.persist(entity);
		
		alertNewResume.fire(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		Resume entity = em.find(Resume.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public Resume findById(Long id) {
		return em.find(Resume.class, id);
	}

	@Override
	public Resume update(Resume entity) {
		return em.merge(entity);
	}

	@Override
	public List<Resume> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Resume> findAllQuery = em.createQuery(
				"SELECT DISTINCT r FROM Resume r ORDER BY r.id", Resume.class);
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
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM Resume").getSingleResult();
	}
}
