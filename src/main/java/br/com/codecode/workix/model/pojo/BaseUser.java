package br.com.codecode.workix.model.pojo;

/**
 * Markup Entity for User
 * @author felipe
 *
 */
public abstract interface BaseUser extends BaseEntity {
	
	boolean isActive();
	
	void setActive(boolean active);
	
	String getEmail();
	
	void setEmail(String email);
	
	String getFirebaseMessageToken();
	
	void setFirebaseMessageToken(String firebaseMessageToken);
	
	String getFirebaseUUID();
	
	void setFirebaseUUID(String firebaseUUID);
	
}
