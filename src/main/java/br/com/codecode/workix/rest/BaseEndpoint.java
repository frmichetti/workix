package br.com.codecode.workix.rest;

import br.com.codecode.workix.cdi.qualifiers.Factory;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Only for Share EntityManager
 *
 * @author felipe
 * @version 1.1
 * @since 1.0
 */
public abstract class BaseEndpoint {

    @Inject
    @Factory
    @Default
    protected EntityManager em;

}
