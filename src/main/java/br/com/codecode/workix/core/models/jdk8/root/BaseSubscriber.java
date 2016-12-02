package br.com.codecode.workix.core.models.jdk8.root;

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
 */
public abstract class BaseSubscriber extends BaseEntity{
    
    /**
     * Email Field
     */
    protected String email;   

}
