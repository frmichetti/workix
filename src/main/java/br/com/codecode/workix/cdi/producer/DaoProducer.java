package br.com.codecode.workix.cdi.producer;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.cdi.dao.Dao;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.cdi.qualifier.Production;

/**
 * Factory for Generic {@link Dao} Injection
 * 
 * @author felipe
 *
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class DaoProducer {	
	
	/**
	 * May Change for {@link @Production} or {@link @Test} 
	 * Default is Test
	 */
	@Inject @Production
	private EntityManager em;	
			
	@Produces
	@Dependent
	@Generic
	public <T> Dao<T> getDao(InjectionPoint injectionPoint) {		

		ParameterizedType type = (ParameterizedType) injectionPoint.getType();

		Class clazz = (Class) type.getActualTypeArguments()[0];

		return new Dao<>(clazz,em);
	}
}
