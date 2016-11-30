/**
 * 
 */
package br.com.codecode.workix.model.base;

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
 * @since 1.0
 * @version 1.1
 * @see BaseEntity
 */
public abstract class BaseUser extends BaseEntity {

    protected boolean active;

    protected String email;

    protected String firebaseUUID;

    protected String firebaseMessageToken;

}
