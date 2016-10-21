package br.com.codecode.cdi.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.com.codecode.openjobs.model.scaffold.User;

/**
 * DAO for Job
 */
@Stateless
public class UserDao extends BasicDao implements Crud<User>{

	private static final long serialVersionUID = 4029639665489024760L;
	
	@Inject
	private Event<User> alertNewUser;
	
	public void create(User entity) {
		
		em.persist(entity);
		
		alertNewUser.fire(entity);
		
	}

	public void deleteById(Long id) {
		User entity = em.find(User.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public User findById(Long id) {
		return em.find(User.class, id);
	}

	public User update(User entity) {
		return em.merge(entity);
	}

	public List<User> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<User> findAllQuery = em.createQuery(
				"SELECT DISTINCT u FROM User u ORDER BY u.id", User.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
