package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

/**
 * Comment JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.0
 * @see MyEntity
 * @since 1.1
 */
public class Comment extends MyEntity {

    private static final long serialVersionUID = 7358996279677908814L;

    private Blog blog;

    private String email;

    private long id;

    private String name;

    private String text;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    Comment() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Comment
     * @see Buildable
     */
    private Comment(Builder builder) {
        this.email = builder.getEmail();
        this.name = builder.getName();
        this.text = builder.getText();
        this.blog = builder.getBlog();
    }

    /**
     * Creates builder to build {@link Comment}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }


    /**
     * @return the blog
     */
    Blog getBlog() {
        return blog;
    }

    /**
     * @param blog the blog to set
     */
    public void setBlog(Blog blog) {
        this.blog = blog;
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
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the text
     */
    String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Builder to build {@link Comment}.
     */

    public static final class Builder extends Comment implements Buildable<Comment> {

        private static final long serialVersionUID = 5724281033461828110L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * @return a new Comment
         */
        @Override
        public Comment build() {
            return new Comment(this);
        }

        public Builder withBlog(Blog blog) {
            super.blog = blog;
            return this;
        }

        public Builder withEmail(String email) {
            super.email = email;
            return this;
        }

        public Builder withName(String name) {
            super.name = name;
            return this;
        }

        public Builder withText(String text) {
            super.text = text;
            return this;
        }
    }

}
