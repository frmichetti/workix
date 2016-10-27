package br.com.codecode.workix.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.model.scaffold.Resume;

@Mockup
public class ResumeDaoMockup extends BasicDaoMockup implements Crud<Resume> {

	private static final long serialVersionUID = -7123666749649316280L;
	
	@Inject
	private Event<Resume> alertNewResume;

	@Override
	public void create(Resume entity) {
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getObjective() + " Salvo com Sucesso!"));
		
		alertNewResume.fire(entity);
		
	}

	@Override
	public Resume update(Resume entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resume findById(Long id) {
		return em.find(Resume.class, id);
	}

	@Override
	public List<Resume> listAll(Integer start, Integer end) {
		TypedQuery<Resume> findAllQuery = em.createQuery(
				"SELECT DISTINCT r FROM Resume r ORDER BY r.id", Resume.class);
		if (start != null) {
			findAllQuery.setFirstResult(start);
		}
		if (end != null) {
			findAllQuery.setMaxResults(end);
		}
		return findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM openjobs_Resumes").getSingleResult();
	}

}
