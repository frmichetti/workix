package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.interfaces.Persistable;
import br.com.codecode.workix.model.jpa.MyEntity;

/**
 * Markup Interface <br>
 * Abstract BaseCrud Interface With Minimal Functions
 * @author felipe
 * @category Persistence
 * @param <T>
 * 
 */
public abstract interface BaseCrud<T extends Persistable & Serializable>  {
	
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
	 * Localize Entity by {@link MyEntity #getId()}
	 * @param id
	 * @return Fetch Entity 
	 * @throws NotImplementedYetException 
	 */	
	public T findById(long id) throws NotImplementedYetException;
	
	/**
	 * Localize Entity by {@link MyEntity #getId()} and Delete
	 * @param id
	 * @throws NotImplementedYetException 
	 *   
	 */	
	public void deleteById(long id) throws NotImplementedYetException;
	
	/**
	 * List Registers of an {@link Entity} between Start and End Index
	 * @param start
	 * @param end
	 * @return List<T> of Results 
	 * @throws NotImplementedYetException 
	 */
	public List<T> listAll(int start, int end) throws NotImplementedYetException;
}
