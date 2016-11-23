package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.util.List;

import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.MyEntity;
import br.com.codecode.workix.model.interfaces.Persistable;

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
	 * @return
	 * @throws NotImplementedYetException 
	 */	
	public T findById(long id) throws NotImplementedYetException;
	
	/**
	 * Localize Entity by {@link MyEntity #getId()} and Delete
	 * @param id
	 * @return
	 * @throws NotImplementedYetException 
	 */	
	public void deleteById(long id) throws NotImplementedYetException;
	
	/**
	 * List Registers of Entity between Start and End Index
	 * @param start
	 * @param end
	 * @return List<T>
	 * @throws NotImplementedYetException 
	 */
	public List<T> listAll(int start, int end) throws NotImplementedYetException;
}
