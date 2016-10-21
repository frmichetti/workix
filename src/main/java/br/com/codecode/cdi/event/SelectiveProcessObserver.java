package br.com.codecode.cdi.event;

import java.time.Instant;

import javax.annotation.Resource;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

import br.com.codecode.openjobs.model.scaffold.SelectiveProcess;

public class SelectiveProcessObserver {
	
	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext jmsContext;

	@Resource(mappedName="java:/jms/topics/selectiveProcessesTopic")
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

		jmsContext.createProducer().send(destination, process.getId());	

	}

}
