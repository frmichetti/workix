package br.com.codecode.workix.interfaces;

/**
 * Markup Interface for Notificable Objects
 * 
 * @author felipe
 * @since 1.1
 * @version 1.1
 */
public interface Notificable {

    /**
     * @return the Email
     */
    String getEmail();

    /**
     * @return the Firebase Message Token
     */
    String getFirebaseMessageToken();

    /**
     * @return the Firebase UUID
     */
    String getFirebaseUUID();

    /**
     * @param email define the Email
     */
    void setEmail(String email);

    /**
     * @param firebaseMessageToken define the Firebase Message Token
     */
    void setFirebaseMessageToken(String firebaseMessageToken);

    /**
     * @param firebaseUUID define the Firebase UUID
     */
    void setFirebaseUUID(String firebaseUUID);

}
