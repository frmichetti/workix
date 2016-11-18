package br.com.codecode.workix.cdi.dao.implementation.mockup;

import java.math.BigInteger;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.model.scaffold.User;

@Mockup
public class UserDaoMockup extends BasicDaoMockup implements Crud<User> {

	private static final long serialVersionUID = 8746840143580709391L;
	
	@Inject
	private Event<User> alertNewUser;

	@Override
	public void save(User entity) {		

		alertNewUser.fire(entity);
		
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getEmail() + " Salvo com Sucesso!"));		
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> listAll(Integer start, Integer end) {
		
		TypedQuery<User> findAllQuery = em.createQuery(
				"SELECT DISTINCT u FROM User u ORDER BY u.id", User.class);
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
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + User.class.getSimpleName()).getSingleResult();
	}

	@Override
	public User saveOrUpdate(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
