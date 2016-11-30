package br.com.codecode.workix.model.actions;

/**
 * Markup Interface for Subscriber Implementation
 * 
 * @author felipe
 * @since 1.1
 * @version 1.1
 */
public interface SubscriberActions extends EntityActions {

    String getEmail();

    void setEmail(String email);
}
