package br.com.codecode.workix.cdi.dao.implementation.mockup;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.cdi.producer.EntityManagerProducer;
import br.com.codecode.workix.jsf.util.MessagesHelper;

/**
 * BaseClass for Mockup Implementation
 * @author felipe
 * @category Mockup
 *
 */
public class BaseDaoMockup implements Serializable {

	private static final long serialVersionUID = -4533114503790241039L;
	
	protected static final String TITLE = "MOCKUP";
	
	@Inject
	protected MessagesHelper messagesHelper;
	
	/**
	 * CDI Injection Point for {@link EntityManager}
	 * @see EntityManagerProducer
	 * Possible values {@link @Default} {@link @Production} {@link @Development} {@link @OpenShift}
	 */
	@Inject @Default
	protected EntityManager em;

}
