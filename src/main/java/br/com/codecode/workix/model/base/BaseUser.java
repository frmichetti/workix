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
 * @version 1.0
 * @see BaseEntity
 */
public abstract class BaseUser extends BaseEntity {

    private boolean active;

    private String email;

    private String firebaseUUID;

    private String firebaseMessageToken;

    /**
     * Empty Default Constructor
     */
    public BaseUser() {
    }

    /**
     * @return the active
     */
    public boolean isActive() {
	return active;
    }

    /**
     * @param active
     *            the active to set
     */
    public void setActive(boolean active) {
	this.active = active;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * @return the firebaseUUID
     */
    public String getFirebaseUUID() {
	return firebaseUUID;
    }

    /**
     * @param firebaseUUID
     *            the firebaseUUID to set
     */
    public void setFirebaseUUID(String firebaseUUID) {
	this.firebaseUUID = firebaseUUID;
    }

    /**
     * @return the firebaseMessageToken
     */
    public String getFirebaseMessageToken() {
	return firebaseMessageToken;
    }

    /**
     * @param firebaseMessageToken
     *            the firebaseMessageToken to set
     */
    public void setFirebaseMessageToken(String firebaseMessageToken) {
	this.firebaseMessageToken = firebaseMessageToken;
    }

}
