package br.com.codecode.workix.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.qualifier.Persist;
import br.com.codecode.workix.model.scaffold.User;

/**
 * DAO for Job
 */
@Stateless
@Persist
public class UserDao extends BaseDao implements Crud<User>{

	private static final long serialVersionUID = 4029639665489024760L;
	
	@Inject
	private Event<User> alertNewUser;
	
	@Override
	public void create(User entity) {
		
		em.persist(entity);
		
		alertNewUser.fire(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		User entity = em.find(User.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public User update(User entity) {
		return em.merge(entity);
	}

	@Override
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

	@Override
	public BigInteger countRegisters() {		
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + User.class.getSimpleName()).getSingleResult();
	}
	
	@Override
	public User saveOrUpdate(User entity) {

		if (entity == null){
			throw new IllegalArgumentException("One valid Entity is required to persist");		

		}

		if(entity.getId() == null){

			em.persist(entity);

		}else

		{
			em.merge(entity);

		}

		return entity;

	}
	
	
}
