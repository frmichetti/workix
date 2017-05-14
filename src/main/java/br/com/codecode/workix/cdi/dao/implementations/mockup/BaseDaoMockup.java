package br.com.codecode.workix.cdi.dao.implementations.mockup;

import br.com.codecode.workix.cdi.producers.EntityManagerProducer;
import br.com.codecode.workix.cdi.qualifiers.*;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * BaseClass for Mockup Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see Serializable
 */
@Mockup
public class BaseDaoMockup implements Serializable {

   
    private static final long serialVersionUID = -4533114503790241039L;

    protected static final String TITLE = "MOCKUP";

    protected static final String SAVEMESSAGE = " Salvo com Sucesso!";

    protected static final String UPDATEMESSAGE = " Atualizado com Sucesso!";

    @Inject
    protected MessagesHelper messagesHelper;

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
