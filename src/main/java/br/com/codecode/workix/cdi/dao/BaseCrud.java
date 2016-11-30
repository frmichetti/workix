package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import br.com.codecode.workix.exceptions.NotImplementedYetException;
import br.com.codecode.workix.interfaces.Persistable;

/**
 * Markup Interface <br>
 * Abstract BaseCrud Interface With Minimal Functions
 * 
 * @author felipe
 * @param <T>
 *            Any Entity witch implements Persistable and Serializable
 */
public abstract interface BaseCrud<T extends Persistable & Serializable> {

    /**
     * Create Current Entity in Database
     * 
     * @param entity
     *            Save/Persist a Entity in Database
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    public void save(T entity) throws NotImplementedYetException;

    /**
     * Update Entity in Database
     * 
     * @param entity
     *            Update/Merge a Entity in Database
     * @return Updated Entity
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    public T update(T entity) throws NotImplementedYetException;

    /**
     * Localize Entity by {@link #getId()}
     * 
     * @param id
     *            Fetch for Entity by id Field
     * @return Fetched Entity
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    public T findById(long id) throws NotImplementedYetException;

    /**
     * Localize Entity by {@link #getId()} and Delete
     * 
     * @param id
     *            Fetch for Entity by id Field and Delete
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    public void deleteById(long id) throws NotImplementedYetException;

    /**
     * List Registers of an {@link Entity} between Start and End Index
     * 
     * @param start
     *            Start Position
     * @param end
     *            End Delimiter
     * @return List of Results
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    public List<T> listAll(int start, int end) throws NotImplementedYetException;
}
