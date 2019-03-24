package br.com.codecode.workix.cdi.dao.implementations.generic;

import br.com.codecode.workix.cdi.dao.BaseCrud;
import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.producers.GenericDaoProducer;
import br.com.codecode.workix.interfaces.Persistable;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * Generic DAO Implementation
 *
 * @param <T> Any Entity witch implements Persistable and Serializable
 * @author felipe
 * @version 1.0
 * @see GenericDaoProducer
 * @see BaseCrud
 * @see Crud
 * @see Serializable
 * @since 1.0
 */
public class Dao<T extends Persistable & Serializable> implements Crud<T>, Serializable {


    private static final long serialVersionUID = 8476110516365062871L;

    private Class<T> clazz;

    private EntityManager em;

    /**
     * STUB Constructor
     */
    private Dao() {
    }

    /**
     * {@link EntityManager} Must be in the construction Method else Causes
     * NullPointerException on {@link InjectionPoint}
     *
     * @param clazz Type of Class for Injection
     * @param em    Entity Manager used in DB Transactions
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
    private void init() {

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
        return em.find(clazz, id);
    }

    @Override
    public void deleteById(long id) {
        em.remove(findById(id));
    }

    @Override
    public T findByUuid(String uuid) {

        String jpql = "SELECT x FROM " + clazz.getSimpleName() + "x WHERE x.uuid = :uuid";

        return em.createQuery(jpql, clazz).setParameter("uuid", uuid).getSingleResult();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> listAll(int start, int end) {

        TypedQuery<?> findAllQuery = em
                .createQuery("SELECT DISTINCT x FROM " + clazz.getSimpleName() + " x ORDER BY x.id", clazz);

        findAllQuery.setFirstResult(start);

        findAllQuery.setMaxResults(end);

        return (List<T>) findAllQuery.getResultList();
    }

    @Override
    public BigInteger countRegisters() {
        return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + clazz.getSimpleName()).getSingleResult();
    }

}
