package br.com.codecode.workix.core.models.jdk8.root;

import br.com.codecode.workix.core.models.jdk8.actions.ContactActions;

/**
 * Root Abstract Class Contact<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #mobilePhone}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see ContactActions
 */
public abstract class BaseContact implements ContactActions {

    /**
     * Mobile Phone Field
     */
    protected long mobilePhone;
    
}