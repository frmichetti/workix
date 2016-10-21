package br.com.codecode.cdi.event;

import java.time.Instant;

import javax.annotation.Resource;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

import br.com.codecode.openjobs.model.scaffold.User;


public class UserObserver {	

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext jmsContext;

	@Resource(mappedName="java:/jms/topics/usersTopic")
	private Destination destination;

	public void alert(@Observes User user){

		System.out.println("[CDI - Alert for new User]");

		System.out.println(user.getEmail());		
		
		System.out.println(Instant.now());

		System.out.println("[-----------------------]");

		jmsContext.createProducer().send(destination, user.getUuid());
			
	}

}
