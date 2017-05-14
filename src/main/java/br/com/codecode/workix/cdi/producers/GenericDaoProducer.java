package br.com.codecode.workix.cdi.producers;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.cdi.dao.implementations.generic.Dao;
import br.com.codecode.workix.cdi.qualifiers.*;
import br.com.codecode.workix.cdi.qualifiers.PostgreSQL;
import br.com.codecode.workix.interfaces.Persistable;

/**
 * Factory for Generic {@link Dao} Injection
 * 
 * @see Produces
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@ApplicationScoped
public class GenericDaoProducer {

    /**
     * MAY Change for {@link Production} or {@link PostgreSQL} or
     * {@link MySQL} Default is AutoDiscover
     */
    @Inject
    @Factory
    @Default
    private EntityManager em;

    /**
     * Produces a Dao based on param from {@link InjectionPoint}
     * 
     * @param injectionPoint
     *            Injection Point Received by CDI
     * @param <T>
     *            ParameterizedType Received on InjectionPoint
     * @return Dao Implementation for Received Clazz
     */
    @Produces
    @Dependent
    @Generic
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends Persistable & Serializable> Dao<T> getDao(InjectionPoint injectionPoint) {

	ParameterizedType type = (ParameterizedType) injectionPoint.getType();

	Class clazz = (Class) type.getActualTypeArguments()[0];

	return new Dao<>(clazz, em);
    }
}
