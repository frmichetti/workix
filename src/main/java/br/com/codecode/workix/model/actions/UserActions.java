package br.com.codecode.workix.model.actions;

/**
 * Markup Interface for User Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public interface UserActions extends EntityActions {

    boolean isActive();

    void setActive(boolean active);

}
