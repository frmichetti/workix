package br.com.codecode.workix.cdi.producers;

import br.com.codecode.workix.cdi.qualifiers.Factory;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

/**
 * Managed Executor Service Producer<br>
 * Use for Asynchronous Tasks
 *
 * @author felipe
 * @version 1.0
 * @see Produces
 * @see ManagedExecutorService
 * @since 1.0
 */
@ApplicationScoped
public class ManagedExecutorServiceProducer {

    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService managedExecutorService;

    /**
     * Produce ManagedExecutorService for CDI Injection Points
     *
     * @return ManagedExecutorService Instance
     */
    @Produces
    @Dependent
    @Factory
    public ManagedExecutorService getManagedExecutorService() {
        return managedExecutorService;
    }
}
