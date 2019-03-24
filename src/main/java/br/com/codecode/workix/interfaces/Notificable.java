package br.com.codecode.workix.interfaces;

/**
 * Markup Interface for Notificable Objects
 *
 * @author felipe
 * @version 1.1
 * @since 1.1
 */
public interface Notificable {

    /**
     * @return the Email
     */
    String getEmail();

    /**
     * @param email define the Email
     */
    void setEmail(String email);

    /**
     * @return the Firebase Message Token
     */
    String getFirebaseMessageToken();

    /**
     * @param firebaseMessageToken define the Firebase Message Token
     */
    void setFirebaseMessageToken(String firebaseMessageToken);

    /**
     * @return the Firebase UUID
     */
    String getFirebaseUUID();

    /**
     * @param firebaseUUID define the Firebase UUID
     */
    void setFirebaseUUID(String firebaseUUID);

}
