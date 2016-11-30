package br.com.codecode.workix.cdi.dao.implementations.persist;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.cdi.producers.EntityManagerProducer;
import br.com.codecode.workix.cdi.qualifiers.Development;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.OpenShift;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.cdi.qualifiers.Production;

/**
 * Only for Share Entity Manager
 * 
 * @author felipe
 * @see Serializable
 * @since 1.0
 * @version 1.0
 */
@Persist
public abstract class BaseDao implements Serializable {

    private static final long serialVersionUID = 3943660229318614845L;

    /**
     * CDI Injection Point for {@link EntityManager}
     * 
     * @see EntityManagerProducer Possible values {@link Default}
     *      {@link Production} {@link Development} {@link OpenShift}
     */
    @Inject
    @Factory
    @Default
    protected EntityManager em;

}
