package br.com.codecode.workix.cdi.dao;

import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.interfaces.Persistable;

import java.io.Serializable;
import java.util.List;

/**
 * Markup Interface <br>
 * Abstract BaseCrud Interface With Minimal Functions
 *
 * @param <T> Any Entity witch implements Persistable and Serializable
 * @author felipe
 * @see Persistable
 * @see Serializable
 */
public interface BaseCrud<T extends Persistable & Serializable> {

    /**
     * Create Current Entity in Database
     *
     * @param entity Save/Persist a Entity in Database
     * @throws NotImplementedYetException if Methods is Not Implemented Yet
     */
    void save(T entity);

    /**
     * Update Entity in Database
     *
     * @param entity Update/Merge a Entity in Database
     * @return Updated Entity
     * @throws NotImplementedYetException if Methods is Not Implemented Yet
     */
    T update(T entity);

    /**
     * Localize Entity by Id
     *
     * @param id Fetch for Entity by id Field
     * @return Fetched Entity
     * @throws NotImplementedYetException if Methods is Not Implemented Yet
     */
    T findById(long id) throws NotImplementedYetException;

    /**
     * Localize Entity by Id and Delete
     *
     * @param id Fetch for Entity by id Field and Delete
     * @throws NotImplementedYetException if Methods is Not Implemented Yet
     */
    void deleteById(long id) throws NotImplementedYetException;

    /**
     * List Registers of an Entity between Start and End Index
     *
     * @param start Start Position
     * @param end   End Delimiter
     * @return List of Results
     * @throws NotImplementedYetException if Methods is Not Implemented Yet
     */
    List<T> listAll(int start, int end);
}
