package br.com.codecode.workix.cdi.event;

import java.time.Instant;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSProducer;

import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.SelectiveProcessTopic;
import br.com.codecode.workix.model.scaffold.SelectiveProcess;

/**
 * CDI Observer Class for {@link SelectiveProcess}
 * @author felipe
 *
 */
public class SelectiveProcessObserver {	

	@Inject @Factory
	private JMSProducer jmsProducer;

	@Inject @Factory @SelectiveProcessTopic
	private Destination destination;

	public void alert(@Observes SelectiveProcess process){

		System.out.println("[CDI - Alert for Selective Processes]");

		System.out.println(process.getId());
		
		System.out.println(Instant.now());		

		System.out.println("[-----------------------]");
		
		if(process.isActive()){
			System.out.println("Process is Active");
		}else{
			System.out.println("Process is no More Elegible");
			System.out.println("Process is Disabled from Database");
		}

		jmsProducer.send(destination, process.getId());	

	}

}
