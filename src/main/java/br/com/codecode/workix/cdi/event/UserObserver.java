package br.com.codecode.workix.cdi.event;

import java.time.Instant;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSProducer;

import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.UserTopic;
import br.com.codecode.workix.model.jpa.User;

/**
 * CDI Observer Class for User
 * @see Observes
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class UserObserver {	

	@Inject @Factory
	private JMSProducer jmsProducer; 

	@Inject @Factory @UserTopic
	private Destination destination;

	/**
	 * Execute an Action on Event as FiredUp
	 * @param user Observer for User Events
	 */
	public void alert(@Observes User user){

		System.out.println("[CDI - Alert for new User]");

		System.out.println(user.getEmail());		
		
		System.out.println(Instant.now());

		System.out.println("[-----------------------]");

		jmsProducer.send(destination, user.getUniqueID());
			
	}

}
