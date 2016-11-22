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

	/**
	 * Create Current Entity in Database
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * Update Entity in Database
	 * @param entity
	 * @return
	 */
	public T update(T entity);

	/**
	 * Save Or Update Currenty Entity Based on {@link BaseEntity #getId()}  
	 * @param entity
	 * @return
	 */
	default public T saveOrUpdate(T entity) throws IllegalArgumentException{
		
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
	 */
	public T findById(long id);

	public void deleteById(long id);

	/**
	 * Fetch for {@link Persistable} Entities with {@link BaseEntity #getUuid()}
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
