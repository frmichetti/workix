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
 * @version 1.0
 * @see Serializable
 * @since 1.0
 */
@Mockup
public class BaseDaoMockup implements Serializable {


    static final String TITLE = "MOCKUP";
    static final String SAVEMESSAGE = " Salvo com Sucesso!";
    static final String UPDATEMESSAGE = " Atualizado com Sucesso!";
    private static final long serialVersionUID = -4533114503790241039L;
    /**
     * CDI Injection Point for {@link EntityManager}
     *
     * @see EntityManagerProducer Possible values {@link Default}
     * {@link Production} {@link PostgreSQL} {@link MySQL}
     */
    @Inject
    @Factory
    @Default
    protected EntityManager em;
    @Inject
    MessagesHelper messagesHelper;

}
