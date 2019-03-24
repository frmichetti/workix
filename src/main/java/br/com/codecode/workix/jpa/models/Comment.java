package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.jpa.models.jdk7.MyEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Comment JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.0
 * @see MyEntity
 * @since 1.1
 */
@Entity
@Table(name = "comments")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
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
    public Comment() {
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
    @XmlTransient

    public static Builder builder() {
        return new Builder();
    }


    /**
     * @return the blog
     */
    @ManyToOne
    public Blog getBlog() {
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
    @NotEmpty
    @Email
    @Column
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
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
    @NotEmpty
    @Column
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
     * @return the text
     */
    @NotEmpty
    @Column
    @Lob
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
