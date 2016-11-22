package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import br.com.codecode.workix.exception.NotImplementedYetException;
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

	/**
	 * Create Current Entity in Database
	 * @param entity
	 * @throws NotImplementedYetException 
	 */
	public void save(T entity) throws NotImplementedYetException;

	/**
	 * Update Entity in Database
	 * @param entity
	 * @return Updated Entity
	 * @throws NotImplementedYetException 
	 */
	public T update(T entity) throws NotImplementedYetException;

	/**
	 * Save Or Update Currenty Entity Based on {@link BaseEntity #getId()}  
	 * @param entity
	 * @return
	 * @throws NotImplementedYetException , IllegalArgumentException
	 */
	default public T saveOrUpdate(T entity) throws IllegalArgumentException, NotImplementedYetException{
		
		if (entity == null){
			throw new IllegalArgumentException("Entity Passed to Persist is Null");		

		}

		if(entity.getId() == 0){
			
			save(entity);
			
		}else{
			
			update(entity);			
		}

		return entity;
	}	

	/**
	 * Localize Entity by {@link BaseEntity #getId()}
	 * @param id
	 * @return
	 * @throws NotImplementedYetException 
	 */
	public T findById(long id) throws NotImplementedYetException;

	public void deleteById(long id) throws NotImplementedYetException;

	/**
	 * Fetch for {@link Persistable} Entities with {@link BaseEntity #getUuid()}
	 * @param uuid
	 * @return <T>
	 * @throws NotImplementedYetException 
	 */
	public T findByUuid(String uuid) throws NotImplementedYetException;

	/**
	 * List Registers of Entity between Start and End Index
	 * @param start
	 * @param end
	 * @return List<T>
	 * @throws NotImplementedYetException 
	 */
	public List<T> listAll(int start, int end) throws NotImplementedYetException;

	/**
	 * Count Registers on Database
	 * @return Total Rows of Entity
	 * @throws NotImplementedYetException 
	 */
	public BigInteger countRegisters() throws NotImplementedYetException;
}
