package br.com.codecode.cdi.event;

import javax.annotation.Resource;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

import br.com.codecode.akijob.model.scaffold.Job;

public class JobsObserver {	

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext jmsContext;

	@Resource(mappedName="java:/jms/topics/jobsTopic")
	private Destination destination;

	public void alert(@Observes Job job){

		System.out.println("[Alert for New Job]");

		System.out.println(job.getUuid());
		

		System.out.println("[-----------------------]");

		jmsContext.createProducer().send(destination, job.getUuid());	

	}

}
