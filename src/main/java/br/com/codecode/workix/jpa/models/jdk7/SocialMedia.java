package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

import java.io.Serializable;

/**
 * SocialMedia JPA Embeddable
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.0
 */
public class SocialMedia implements Serializable {

    private static final long serialVersionUID = -3082998497652120101L;

    private String media;

    private String url;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public SocialMedia() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New SocialMedia
     * @see Buildable
     */
    private SocialMedia(Builder builder) {
        this.media = builder.getMedia();
        this.url = builder.getUrl();
    }


    /**
     * Creates builder to build {@link SocialMedia}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }


    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Builder to build {@link SocialMedia}.
     */
    public static final class Builder extends SocialMedia implements Buildable<SocialMedia> {

        private static final long serialVersionUID = -4455052272130426281L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * @return a new SocialMedia
         */
        @Override
        public SocialMedia build() {
            return new SocialMedia(this);
        }

        public Builder withMedia(String media) {
            super.media = media;
            return this;
        }

        public Builder withUrl(String url) {
            super.url = url;
            return this;
        }
    }


}
