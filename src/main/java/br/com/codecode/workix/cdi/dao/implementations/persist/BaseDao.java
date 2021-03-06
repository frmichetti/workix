package br.com.codecode.workix.cdi.dao.implementations.persist;

import br.com.codecode.workix.cdi.producers.EntityManagerProducer;
import br.com.codecode.workix.cdi.qualifiers.*;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Only for Share Entity Manager
 * 
 * @author felipe
 * @see Serializable
 * @since 1.0
 * @version 1.0
 */
@Persist
public class BaseDao implements Serializable {

   
    private static final long serialVersionUID = 3943660229318614845L;

    /**
     * CDI Injection Point for {@link EntityManager}
     * 
     * @see EntityManagerProducer Possible values {@link Default}
     *      {@link Production} {@link PostgreSQL} {@link MySQL}
     */
    @Inject
    @Factory
    @Default
    protected EntityManager em;

}
