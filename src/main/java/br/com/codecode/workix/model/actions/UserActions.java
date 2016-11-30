package br.com.codecode.workix.model.actions;

/**
 * Markup Interface for User Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface UserActions extends EntityActions {

    boolean isActive();

    void setActive(boolean active);

    String getEmail();

    void setEmail(String email);

    String getFirebaseMessageToken();

    void setFirebaseMessageToken(String firebaseMessageToken);

    String getFirebaseUUID();

    void setFirebaseUUID(String firebaseUUID);

}
