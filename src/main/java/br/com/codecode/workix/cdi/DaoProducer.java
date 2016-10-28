package br.com.codecode.workix.cdi;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import br.com.codecode.workix.cdi.dao.Dao;

public class DaoProducer {

	@Produces
	public Dao create(InjectionPoint injectionPoint) {
		ParameterizedType type = (ParameterizedType) injectionPoint.getType();
		Class classe = (Class) type.getActualTypeArguments()[0];
		return new Dao(classe);
	}

}
