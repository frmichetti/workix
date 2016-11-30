package br.com.codecode.workix.interfaces;

/**
 * Markup Interface for Notificable Objects
 * 
 * @author felipe
 * @since 1.1
 * @version 1.1
 */
public interface Notificable {

    String getEmail();

    String getFirebaseMessageToken();

    String getFirebaseUUID();

    void setEmail(String email);

    void setFirebaseMessageToken(String firebaseMessageToken);

    void setFirebaseUUID(String firebaseUUID);

}
