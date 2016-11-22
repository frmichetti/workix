package br.com.codecode.workix.cdi.dao.implementation.generic;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.producer.GenericDaoProducer;
import br.com.codecode.workix.model.interfaces.Persistable;

/**
 * Generic Dao Implementation
 * @see GenericDaoProducer
 * @author felipe
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class Dao<T extends Persistable & Serializable> implements Crud<T>, Serializable {

	private static final long serialVersionUID = 8476110516365062871L;

	private Class<T> clazz;

	private EntityManager em;

	/**
	 * STUB Constructor
	 */
	private Dao(){}

	/**
	 * {@link EntityManager} Must be in the construction Method
	 * else Causes NullPointerException on {@link InjectionPoint} 
	 * @param clazz
	 * @param em
	 */
	public Dao(Class<T> clazz, EntityManager em) {
		this();
		this.clazz = clazz;
		this.em = em;
	}

	/**
	 * For Debug only
	 */
	@PostConstruct
	private void init(){

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
	public T findById(long id) {
		return em.find(clazz,id);
	}

	@Override
	public void deleteById(long id) {
		em.remove(findById(id));
	}

	@Override
	public T findByUuid(String uuid) {

		String jpql = "SELECT x FROM " + clazz.getSimpleName() + "x WHERE x.uuid = :uuid";

		return em.createQuery(jpql,clazz).
				setParameter("uuid",uuid).getSingleResult() ;

	}


	@Override
	public List<T> listAll(int start, int end) {

		TypedQuery<?> findAllQuery = em.createQuery(
				"SELECT DISTINCT x FROM " + clazz.getSimpleName() + " x ORDER BY x.id",
				clazz);

		findAllQuery.setFirstResult(start);

		findAllQuery.setMaxResults(end);

		return (List<T>) findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + 
				clazz.getSimpleName()).getSingleResult();
	}

}
