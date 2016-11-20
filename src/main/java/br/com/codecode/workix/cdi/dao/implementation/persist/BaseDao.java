package br.com.codecode.workix.cdi.dao.implementation.persist;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Only for Share Entity Manager
 * @author felipe
 *
 */
public abstract class BaseDao implements Serializable{

	private static final long serialVersionUID = 3943660229318614845L;
	
	@Inject @Default
	protected EntityManager em;
	
}
