package br.com.codecode.workix.core.models.jdk7.root;

import br.com.codecode.workix.core.models.jdk7.actions.ContactActions;

/**
 * Root Abstract Class Contact<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #mobilePhone}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see ContactActions
 */
public abstract class BaseContact implements ContactActions {

    /**
     * Mobile Phone Field
     */
    protected long mobilePhone;
    
}
