/**
 * 
 */
package br.com.codecode.workix.model.root;

/**
 * Root Abstract Class User<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #active}</li>
 * <li>{@link #email}</li>
 * <li>{@link #firebaseUUID}</li>
 * <li>{@link #firebaseMessageToken}</li> 
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootUser extends RootEntity {
	
	protected boolean active;
	
	protected String email;

	protected String firebaseUUID;

	protected String firebaseMessageToken;
	
}
