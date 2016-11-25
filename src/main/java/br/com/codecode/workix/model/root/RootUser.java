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
 * @see RootEntity
 */
public abstract class RootUser extends RootEntity {
	
	private boolean active;
	
	private String email;

	private String firebaseUUID;

	private String firebaseMessageToken;
	
	/**
	 * Empty Default Constructor
	 */
	public RootUser(){}

	/**
	 * @return the active
	 */
	public final boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public final void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firebaseUUID
	 */
	public final String getFirebaseUUID() {
		return firebaseUUID;
	}

	/**
	 * @param firebaseUUID the firebaseUUID to set
	 */
	public final void setFirebaseUUID(String firebaseUUID) {
		this.firebaseUUID = firebaseUUID;
	}

	/**
	 * @return the firebaseMessageToken
	 */
	public final String getFirebaseMessageToken() {
		return firebaseMessageToken;
	}

	/**
	 * @param firebaseMessageToken the firebaseMessageToken to set
	 */
	public final void setFirebaseMessageToken(String firebaseMessageToken) {
		this.firebaseMessageToken = firebaseMessageToken;
	}	
	
}
