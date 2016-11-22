package br.com.codecode.workix.cdi.dao.implementation.mockup;

import java.math.BigInteger;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.scaffold.Job;

/**
 * Mockup Class for Demonstration Only
 * @author felipe
 * @category Mockup
 */
@Mockup
public class JobDaoMockup extends BaseDaoMockup implements Crud<Job> {

	private static final long serialVersionUID = -7524434066008227524L;

	@Override
	public void save(Job entity) {
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getTitle() + SAVEMESSAGE));		

	}

	@Override
	public Job update(Job entity) {
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getTitle() + UPDATEMESSAGE));		
		return entity;
	}

	@Override
	public void deleteById(long id) throws NotImplementedYetException  {
		throw new NotImplementedYetException();

	}

	@Override
	public Job findById(long id) {
		return em.find(Job.class, id);
	}

	@Override
	public List<Job> listAll(int start, int end) {
		TypedQuery<Job> findAllQuery = em.createQuery(
				"SELECT DISTINCT j FROM Job j ORDER BY j.id", Job.class);

		findAllQuery.setFirstResult(start);

		findAllQuery.setMaxResults(end);

		return findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + Job.class.getSimpleName()).getSingleResult();
	}

	@Override
	public Job findByUuid(String uuid) throws NotImplementedYetException {
		throw new NotImplementedYetException();
	}

}
