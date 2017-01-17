package br.com.codecode.workix.cdi.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;

import br.com.codecode.workix.cdi.qualifiers.Factory;

/**
 * JMS Context Producer
 * 
 * @see Produces
 * @see JMSContext
 * @see JMSProducer
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@ApplicationScoped
public class JmsContextProducer {

    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    private JMSContext jmsContext;

    /**
     * Produces JMSProducer for CDI Injection Points
     * 
     * @return JMSProducer Instance
     */
    @Produces
    @Dependent
    @Factory
    public JMSProducer getJMSProducer() {
	return jmsContext.createProducer();
    }

}
