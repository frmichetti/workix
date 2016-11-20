package br.com.codecode.workix.cdi.dao.implementation.mockup;

import java.math.BigInteger;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.model.scaffold.Job;

@Mockup
public class JobDaoMockup extends BaseDaoMockup implements Crud<Job> {

	private static final long serialVersionUID = -7524434066008227524L;

	@Override
	public void save(Job entity) {
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getTitle() + " Salvo com Sucesso!"));		
		
	}

	@Override
	public Job update(Job entity) {
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getTitle() + " Atualizado com Sucesso!"));		
		return entity;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Job findById(Long id) {
		return em.find(Job.class, id);
	}

	@Override
	public List<Job> listAll(Integer start, Integer end) {
		TypedQuery<Job> findAllQuery = em.createQuery(
				"SELECT DISTINCT j FROM Job j ORDER BY j.id", Job.class);
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
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + Job.class.getSimpleName()).getSingleResult();
	}

	@Override
	public Job saveOrUpdate(Job entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Job findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
