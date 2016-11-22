package br.com.codecode.workix.cdi.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;

import br.com.codecode.workix.cdi.qualifier.Factory;

/**
 * JMS Context Producer
 * @author felipe
 *
 */
@ApplicationScoped
public class JmsContextProducer {	

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")	
	private JMSContext jmsContext;

	/**
	 * Produce {@link JMSProducer} for CDI Injection Points 
	 * @return {@link JMSProducer} Instance
	 */
	@Produces
	@Dependent
	@Factory
	public JMSProducer getJMSProducer() {    	
		return jmsContext.createProducer();        
	}

}
