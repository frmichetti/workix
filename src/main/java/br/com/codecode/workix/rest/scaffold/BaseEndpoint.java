package br.com.codecode.workix.rest.scaffold;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.cdi.qualifier.Factory;

/**
 * Only for Share EntityManager
 * @author felipe
 *
 */
public abstract class BaseEndpoint {

	@Inject @Factory @Default
	protected EntityManager em;	

}
