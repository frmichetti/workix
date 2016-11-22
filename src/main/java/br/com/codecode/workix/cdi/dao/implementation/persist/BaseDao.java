package br.com.codecode.workix.cdi.dao.implementation.persist;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.cdi.producer.EntityManagerProducer;

/**
 * Only for Share Entity Manager
 * @author felipe
 *
 */
public abstract class BaseDao implements Serializable{

	private static final long serialVersionUID = 3943660229318614845L;
	
	/**
	 * CDI Injection Point for {@link EntityManager}
	 * @see EntityManagerProducer
	 * Possible values {@link @Default} {@link @Production} {@link @Development} {@link @OpenShift}
	 */
	@Inject @Default
	protected EntityManager em;
	
}
