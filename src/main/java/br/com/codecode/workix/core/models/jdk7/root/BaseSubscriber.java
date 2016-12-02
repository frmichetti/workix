package br.com.codecode.workix.core.models.jdk7.root;

import br.com.codecode.workix.core.models.jdk7.actions.SubscriberActions;

/**
 * Root Abstract Class Subscriber<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #id}</li>
 * <li>{@link #email}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see SubscriberActions
 */
public abstract class BaseSubscriber extends BaseEntity implements SubscriberActions{
    
    /**
     * Email Field
     */
    protected String email;   

}
