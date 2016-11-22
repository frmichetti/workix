package br.com.codecode.workix.cdi.producer;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.jms.Destination;

import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.JobTopic;
import br.com.codecode.workix.cdi.qualifier.SelectiveProcessTopic;
import br.com.codecode.workix.cdi.qualifier.UserTopic;

/**
 * 
 * @author felipe
 *
 */
@ApplicationScoped
public class JmsDestinationProducer {

	@Resource(mappedName="java:/jms/topics/jobsTopic")
	private Destination jobsTopic;
	
	@Resource(mappedName="java:/jms/topics/usersTopic")
	private Destination usersTopic;
	
	@Resource(mappedName="java:/jms/topics/selectiveProcessesTopic")
	private Destination selectiveProcessesTopic;
	
	/**
	 * Produce JMS {@link Destination} for CDI Injection Points 
	 * @return JMS {@link Destination} Instance
	 */
	@Produces
	@Dependent
	@Factory
	@JobTopic
	public Destination getJobDestination(){
		return jobsTopic;
	}
	
	/**
	 * Produce JMS {@link Destination} for CDI Injection Points 
	 * @return JMS {@link Destination} Instance
	 */
	@Produces
	@Dependent
	@Factory
	@UserTopic
	public Destination getUserDestination(){
		return usersTopic;
	}
	
	/**
	 * Produce JMS {@link Destination} for CDI Injection Points 
	 * @return JMS {@link Destination} Instance
	 */
	@Produces
	@Dependent
	@Factory
	@SelectiveProcessTopic
	public Destination getSelectiveProcessesDestination(){
		return selectiveProcessesTopic;
	}
	
	

}
