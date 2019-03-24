package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

/**
 * Testimonial JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @since 1.0
 */
public class Testimonial extends MyEntity {

    private static final long serialVersionUID = 9143527358797800527L;

    private Author author;

    private long id;

    private String picture;

    private String signature;

    private String text;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Testimonial() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Testimonial
     * @see Buildable
     */
    private Testimonial(Builder builder) {
        this.author = builder.getAuthor();
        this.picture = builder.getPicture();
        this.signature = builder.getSignature();
        this.text = builder.getText();
    }


    /**
     * Creates builder to build {@link Testimonial}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }


    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return the id
     */
    @Override
    public long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature the signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Builder to build {@link Testimonial}.
     */
    public static final class Builder extends Testimonial implements Buildable<Testimonial> {

        private static final long serialVersionUID = 136923846936951445L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * Return a New Testimonial
         */
        @Override
        public Testimonial build() {
            return new Testimonial(this);
        }

        public Builder withAuthor(Author author) {
            super.author = author;
            return this;
        }

        public Builder withPicture(String picture) {
            super.picture = picture;
            return this;
        }

        public Builder withSignature(String signature) {
            super.signature = signature;
            return this;
        }

        public Builder withText(String text) {
            super.text = text;
            return this;
        }
    }

}
