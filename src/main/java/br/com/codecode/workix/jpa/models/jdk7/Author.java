package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

import java.util.ArrayList;
import java.util.List;

/**
 * Author JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @since 1.0
 */
public class Author extends MyEntity {

    private static final long serialVersionUID = 4441917823240375511L;

    private String aboutText;

    private long id;

    private List<SocialMedia> medias;

    private String name;

    private String picture;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Author() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Author
     * @see Buildable
     */
    private Author(Builder builder) {
        this.id = builder.getId();
        this.aboutText = builder.getAboutText();
        this.medias = builder.getMedias();
        this.name = builder.getName();
        this.picture = builder.getPicture();
    }

    /**
     * Creates builder to build {@link Author}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Add Social Media
     *
     * @param socialMedia Url for Social Media
     */
    public void addSocialMedia(SocialMedia socialMedia) {
        if (medias == null) {
            medias = new ArrayList<>();
        }

        medias.add(socialMedia);
    }

    /**
     * @return the aboutText
     */
    public String getAboutText() {
        return aboutText;
    }

    /**
     * @param aboutText the aboutText to set
     */
    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }

    /**
     * @return the id
     */
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the medias
     */
    public List<SocialMedia> getMedias() {
        return medias;
    }

    /**
     * @param medias the medias to set
     */
    public void setMedias(List<SocialMedia> medias) {
        this.medias = medias;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Remove Social Media
     *
     * @param socialMedia Url for Social Media
     */
    public void removeSocialMedia(SocialMedia socialMedia) {
        if (medias == null) {
            medias = new ArrayList<>();
        }
        medias.remove(socialMedia);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).toString();
    }

    /**
     * Builder to build {@link Author}.
     */
    public static final class Builder extends Author implements Buildable<Author> {

        private static final long serialVersionUID = -8399508111893300657L;

        private Builder() {
        }

        public Author build() {
            return new Author(this);
        }

        public Builder withAboutText(String aboutText) {
            super.aboutText = aboutText;
            return this;
        }

        public Builder withMedias(List<SocialMedia> medias) {
            super.medias = medias;
            return this;
        }

        public Builder withName(String name) {
            super.name = name;
            return this;
        }

        public Builder withPicture(String picture) {
            super.picture = picture;
            return this;
        }
    }

}