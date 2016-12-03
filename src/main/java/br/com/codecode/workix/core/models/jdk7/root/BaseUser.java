/**
 * 
 */
package br.com.codecode.workix.core.models.jdk7.root;

import br.com.codecode.workix.core.models.jdk7.actions.UserActions;

/**
 * Root Abstract Class User<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #active}</li>
 * <li>{@link #email}</li>
 * <li>{@link #firebaseUUID}</li>
 * <li>{@link #firebaseMessageToken}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see BaseEntity
 * @see UserActions
 */
public abstract class BaseUser extends BaseEntity implements UserActions {
   
    /**
     * Active Field
     */
    protected boolean active;

    /**
     * Email Field
     */
    protected String email;

    /**
     * Firebase UUID Field
     */
    protected String firebaseUUID;

    /**
     * Firebase Message Token Field
     */
    protected String firebaseMessageToken;  
    
    

}
