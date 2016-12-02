package br.com.codecode.workix.core.models.jdk7.actions;

/**
 * Markup Interface for Subscriber Implementation
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see EntityActions
 */
public interface SubscriberActions extends EntityActions {

    String getEmail();

    void setEmail(String email);
}
