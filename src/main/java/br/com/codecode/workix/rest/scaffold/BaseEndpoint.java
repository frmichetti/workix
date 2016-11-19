package br.com.codecode.workix.rest.scaffold;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
/**
 * Only for Share EntityManager
 * @author felipe
 *
 */
public abstract class BaseEndpoint {

	@Inject @Default
	protected EntityManager em;	

}
