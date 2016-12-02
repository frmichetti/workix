package br.com.codecode.workix.core.models.jdk8.root;

import br.com.codecode.workix.core.models.jdk8.actions.SubscriberActions;

/**
 * Root Abstract Class Subscriber<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #id}</li>
 * <li>{@link #email}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseEntity
 * @see SubscriberActions
 */
public abstract class BaseSubscriber extends BaseEntity implements SubscriberActions{
    
    /**
     * Email Field
     */
    protected String email;   

}
