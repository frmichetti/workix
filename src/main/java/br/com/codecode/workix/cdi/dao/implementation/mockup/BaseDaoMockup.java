package br.com.codecode.workix.cdi.dao.implementation.mockup;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.cdi.producer.EntityManagerProducer;
import br.com.codecode.workix.cdi.qualifier.Development;
import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.cdi.qualifier.OpenShift;
import br.com.codecode.workix.cdi.qualifier.Production;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;

/**
 * BaseClass for Mockup Implementation
 * @author felipe 
 * @since 1.0
 * @version 1.0
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
	 * @see EntityManagerProducer
	 * Possible values {@link Default} {@link Production} {@link Development} {@link OpenShift}
	 */
	@Inject @Factory @Default
	protected EntityManager em;

}
