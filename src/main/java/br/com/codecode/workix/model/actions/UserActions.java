package br.com.codecode.workix.model.actions;

/**
 * Markup Interface for User Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface UserActions extends EntityActions {

    String getEmail();

    String getFirebaseMessageToken();

    String getFirebaseUUID();

    boolean isActive();

    void setActive(boolean active);

    void setEmail(String email);

    void setFirebaseMessageToken(String firebaseMessageToken);

    void setFirebaseUUID(String firebaseUUID);

}
