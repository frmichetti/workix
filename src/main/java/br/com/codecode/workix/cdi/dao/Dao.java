package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;

public class Dao<T extends BasicEntity> implements Crud<T>, Serializable {

	private static final long serialVersionUID = 8476110516365062871L;

	private Class<T> clazz;

	private EntityManager em;

	private Dao(){}

	public Dao(Class<T> clazz, EntityManager em) {
		this();
		this.clazz = clazz;
		this.em = em;

		System.out.println("Dao.Dao(" + clazz.getSimpleName() + ")");
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
	public List<T> listAll(Integer start, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigInteger countRegisters() {
		// TODO Auto-generated method stub
		return null;
	}




}
