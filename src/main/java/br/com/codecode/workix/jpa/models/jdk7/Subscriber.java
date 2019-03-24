package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

/**
 * Subscriber JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @since 1.0
 */
public class Subscriber extends MyEntity {

    private static final long serialVersionUID = 6675137603968146834L;

    private String email;

    private long id;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    Subscriber() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate New Subscriber
     * @see Buildable
     */
    Subscriber(Builder builder) {
        this.setEmail(builder.getEmail());
    }

    /**
     * Creates builder to build {@link Subscriber}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * @return the email
     */
    String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    void setEmail(String email) {
        this.email = email;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Builder NestedClass for {@link Subscriber}
     *
     * @author felipe
     * @version 1.0
     * @see Buildable
     * @see Subscriber
     * @since 1.0
     */
    public final static class Builder extends Subscriber implements Buildable<Subscriber> {

        private static final long serialVersionUID = -7750971468814207111L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * @return a new Subscriber
         */
        @Override
        public Subscriber build() {

            return new Subscriber(this);
        }

        /**
         * @param email the email to set
         * @return Builder
         */
        public Builder withEmail(String email) {
            this.setEmail(email);
            return this;
        }

    }

}
