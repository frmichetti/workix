package br.com.codecode.workix.cdi.producer;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.cdi.dao.implementation.generic.Dao;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.cdi.qualifier.Test;
import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;

/**
 * Factory for Generic {@link Dao} Injection
 * 
 * @author felipe
 *
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class DaoProducer {	
	
	/**
	 * MAY Change for {@link @Production} or {@link @Test} 
	 * Default is Test
	 */
	@Inject @Test
	private EntityManager em;	
			
	@Produces
	@Dependent
	@Generic
	public <T extends BasicEntity> Dao<T> getDao(InjectionPoint injectionPoint) {		

		ParameterizedType type = (ParameterizedType) injectionPoint.getType();

		Class clazz = (Class) type.getActualTypeArguments()[0];

		return new Dao<>(clazz,em);
	}
}
