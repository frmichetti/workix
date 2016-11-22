package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.math.BigInteger;

import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.BaseEntity;
import br.com.codecode.workix.model.interfaces.Persistable;

/**
 * Concrete Crud Interface for CDI Implementation Uses
 * @author felipe
 * @since 1.0
 * @category Persistence
 * @param <T>
 */
public interface Crud<T extends Persistable & Serializable> extends BaseCrud<T>{

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
	 * Fetch for {@link Persistable} Entities with {@link BaseEntity #getUuid()}
	 * @param uuid
	 * @return <T>
	 * @throws NotImplementedYetException 
	 */
	public T findByUuid(String uuid) throws NotImplementedYetException;	

	/**
	 * Count Registers on Database
	 * @return Total Rows of Entity
	 * @throws NotImplementedYetException 
	 */
	public BigInteger countRegisters() throws NotImplementedYetException;
}
