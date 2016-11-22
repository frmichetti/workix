package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import br.com.codecode.workix.model.BaseEntity;
import br.com.codecode.workix.model.interfaces.Persistable;
/**
 * Crud Interface for CDI Implementation Uses
 * @author felipe
 * @since 1.0
 * @category Persistence
 * @param <T>
 */
public interface Crud<T extends Persistable & Serializable> {

	public void save(T entity);
	
	public T update(T entity);
	
	public T saveOrUpdate(T entity);	

	public T findById(long id);
	
	public void deleteById(long id);
	
	/**
	 * Fetch for {@link Persistable} Entities with {@link BaseEntity#getUuid()}
	 * @param uuid
	 * @return <T>
	 */
	public T findByUuid(String uuid);
	
	/**
	 * List Registers of Entity between Start and End Index
	 * @param start
	 * @param end
	 * @return List<T>
	 */
	public List<T> listAll(int start, int end);
	
	/**
	 * Count Registers on Database
	 * @return Total Rows of Entity
	 */
	public BigInteger countRegisters();
}
