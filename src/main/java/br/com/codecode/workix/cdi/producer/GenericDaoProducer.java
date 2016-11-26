package br.com.codecode.workix.cdi.producer;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.cdi.dao.implementation.generic.Dao;
import br.com.codecode.workix.cdi.qualifier.Development;
import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.cdi.qualifier.OpenShift;
import br.com.codecode.workix.cdi.qualifier.Production;
import br.com.codecode.workix.model.interfaces.Persistable;

/**
 * Factory for Generic {@link Dao} Injection
 * @see Produces
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@SuppressWarnings({"unchecked","rawtypes"})
@ApplicationScoped
public class GenericDaoProducer {	
	
	/**
	 * MAY Change for {@link Production} or {@link Development} or {@link OpenShift} 
	 * Default is AutoDiscover
	 */
	@Inject @Factory @Default
	private EntityManager em;	
	
	/**
	 * Produces a Dao based on param from {@link InjectionPoint}
	 * @param injectionPoint Injection Point Received by CDI
	 * @param <T> ParameterizedType Received on InjectionPoint
	 * @return Dao Implementation for Received Clazz
	 */
	@Produces
	@Dependent	
	@Generic
	public <T extends Persistable & Serializable> Dao<T> getDao(InjectionPoint injectionPoint) {		

		ParameterizedType type = (ParameterizedType) injectionPoint.getType();

		Class clazz = (Class) type.getActualTypeArguments()[0];

		return new Dao<>(clazz,em);
	}
}
