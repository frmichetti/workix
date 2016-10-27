package br.com.codecode.workix.cdi.event;

import java.time.Instant;

import javax.annotation.Resource;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

import br.com.codecode.workix.model.scaffold.Job;

public class JobsObserver {	

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext jmsContext;

	@Resource(mappedName="java:/jms/topics/jobsTopic")
	private Destination destination;

	public void alert(@Observes Job job){

		System.out.println("[CDI - Alert for New Job]");

		System.out.println(job.uniqueId());

		System.out.println(Instant.now());		

		System.out.println("[-----------------------]");
		
		if(job.getCategory() != null){
			switch (job.getCategory()) {

			case MANAGEMENT: {
				System.out.println("SEND Notification for Management Job");
			}
			break;
			
			case OPERATOR: {
				System.out.println("SEND Notification for Operator Job");
			}
			break;
			
			default:{
				System.out.println("SEND Notification for Default Job");
			}
				break;
				
			}
		}		

		jmsContext.createProducer().send(destination, job.uniqueId());	


	}

}


