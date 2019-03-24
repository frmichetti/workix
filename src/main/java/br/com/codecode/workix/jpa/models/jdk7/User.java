package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.interfaces.Notificable;

/**
 * User JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @see Notificable
 * @since 1.0
 */
public class User extends MyEntity implements Notificable {

    private static final long serialVersionUID = -610648880358327958L;

    private boolean active;

    private String email, firebaseUUID, firebaseMessageToken;

    private long id;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public User() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New User
     * @see Buildable
     */
    public User(Builder builder) {
        this.active = builder.isActive();
        this.email = builder.getEmail();
        this.firebaseUUID = builder.getFirebaseUUID();
        this.firebaseMessageToken = builder.getFirebaseMessageToken();
    }


    /**
     * Creates builder to build {@link User}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getFirebaseMessageToken() {
        return firebaseMessageToken;
    }

    @Override
    public void setFirebaseMessageToken(String firebaseMessageToken) {
        this.firebaseMessageToken = firebaseMessageToken;
    }

    @Override
    public String getFirebaseUUID() {
        return firebaseUUID;
    }

    @Override
    public void setFirebaseUUID(String firebaseUUID) {
        this.firebaseUUID = firebaseUUID;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Builder NestedClass for {@link User}
     *
     * @author felipe
     * @version 1.0
     * @see User
     * @see Buildable
     * @since 1.0
     */
    public final static class Builder extends User implements Buildable<User> {

        private static final long serialVersionUID = -7766145008890656904L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * Return a New User
         */
        @Override
        public User build() {
            return new User(this);
        }

        /**
         * @param active the active to set
         * @return Builder
         */
        public Builder withActive(boolean active) {
            this.setActive(active);
            return this;
        }

        /**
         * @param email the email to set
         * @return Builder
         */
        public Builder withEmail(String email) {
            this.setEmail(email);
            return this;
        }

        /**
         * @param firebaseMessageToken the firebaseMessageToken to set
         * @return Builder
         */
        public Builder withFirebaseMessageToken(String firebaseMessageToken) {
            this.setFirebaseMessageToken(firebaseMessageToken);
            return this;
        }

        /**
         * @param firebaseUUID the firebaseUUID to set
         * @return Builder
         */
        public Builder withFirebaseUUID(String firebaseUUID) {
            this.setFirebaseUUID(firebaseUUID);
            return this;
        }

    }

}