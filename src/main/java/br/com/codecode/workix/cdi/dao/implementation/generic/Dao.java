package br.com.codecode.workix.cdi.dao.implementation.generic;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.producer.DaoProducer;
import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;
/**
 * Generic Dao Implementation
 * @see DaoProducer
 * @author felipe
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class Dao<T extends BasicEntity> implements Crud<T>, Serializable {

	private static final long serialVersionUID = 8476110516365062871L;

	private Class<T> clazz;

	private EntityManager em;

	private Dao(){}

	public Dao(Class<T> clazz, EntityManager em) {
		this();
		this.clazz = clazz;
		this.em = em;

		System.out.println("[CDI] - Dao(" + clazz.getSimpleName() + ")");
		System.out.println("Entity Manager Hash -> " + em.hashCode());
	}

	@Override
	public void save(T obj) {
		em.persist(obj);
	}


	@Override
	public T update(T obj) {
		return em.merge(obj);
	}

	@Override
	public T findById(Long id) {
		return em.find(clazz,id);
	}

	@Override
	public T saveOrUpdate(T entity) {

		if(entity.getId() == null){
			em.persist(entity);
		}else{
			em.merge(entity);			
		}

		return entity;
	}

	@Override
	public void deleteById(Long id) {
		em.remove(findById(id));
	}

	@Override
	public T findByUuid(String uuid) {

		String jpql = "SELECT x FROM " + clazz.getSimpleName() + "x WHERE x.uuid = :uuid";

		return em.createQuery(jpql,clazz).
				setParameter("uuid",uuid).getSingleResult() ;


	}


	@Override
	public List<T> listAll(Integer start, Integer end) {

		TypedQuery<?> findAllQuery = em.createQuery(
				"SELECT DISTINCT x FROM " + clazz.getSimpleName() + " x ORDER BY x.id",
				clazz);

		if (start != null) {
			findAllQuery.setFirstResult(start);
		}

		if (end != null) {
			findAllQuery.setMaxResults(end);
		}

		return (List<T>) findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + clazz.getSimpleName()).getSingleResult();
	}






}