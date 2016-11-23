package br.com.codecode.workix.cdi.event;

import java.time.Instant;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSProducer;

import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.JobTopic;
import br.com.codecode.workix.model.jpa.Job;

/**
 * CDI Observer Class for {@link Jobs}
 * @author felipe
 *
 */
public class JobsObserver {	

	@Inject @Factory
	private JMSProducer jmsProducer; 

	@Inject @Factory @JobTopic
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

		jmsProducer.send(destination, job.uniqueId());	




	}

}


