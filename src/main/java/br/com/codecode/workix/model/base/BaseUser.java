package br.com.codecode.workix.model.base;

/**
 * Markup Interface for User Implementation
 * @author felipe
 *
 */
public interface BaseUser extends BaseEntity {
	
	boolean isActive();
	
	void setActive(boolean active);
	
	String getEmail();
	
	void setEmail(String email);
	
	String getFirebaseMessageToken();
	
	void setFirebaseMessageToken(String firebaseMessageToken);
	
	String getFirebaseUUID();
	
	void setFirebaseUUID(String firebaseUUID);
	
}
