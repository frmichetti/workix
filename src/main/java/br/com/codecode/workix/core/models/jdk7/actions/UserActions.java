package br.com.codecode.workix.core.models.jdk7.actions;

/**
 * Markup Interface for User Implementation
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see EntityActions
 */
public interface UserActions extends EntityActions {

    boolean isActive();

    void setActive(boolean active);

}
