package br.com.codecode.workix.cdi.producer;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import br.com.codecode.workix.cdi.qualifier.Factory;

/**
 * Managed Executor Service Producer<br>
 * Use for Asynchronous Tasks
 * @see Produces
 * @see ManagedExecutorService
 * @author felipe
 *
 */
@ApplicationScoped
public class ManagedExecutorServiceProducer {

	@Resource(name = "java:comp/DefaultManagedExecutorService")
	private ManagedExecutorService managedExecutorService;
	
	/**
	 * Produce ManagedExecutorService for CDI Injection Points 
	 * @return ManagedExecutorService Instance
	 */
	@Produces
	@Dependent
	@Factory
	public ManagedExecutorService getManagedExecutorService(){
		return managedExecutorService;
	}
}
