package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

import javax.annotation.Generated;

/**
 * Comment JPA with Inherited Fields and Methods
 * 
 * @see MyEntity
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Comment extends MyEntity {
    
    /**
     * @serialField
     */
    private static final long serialVersionUID = 7358996279677908814L;
    
    private Blog blog; 
    
    private String email;    
    
    private long id;
    
    private String name;
    
    private String text;
   
    public Comment(){}

    private Comment(Builder builder) {
	this.id = builder.getId();
	this.email = builder.getEmail();
	this.name = builder.getName();
	this.text = builder.getText();
	this.blog = builder.getBlog();
    }

    /**
     * Creates builder to build {@link Comment}.
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
     * @return the email
     */
    @NotEmpty
    @Email
    @Column
    public String getEmail() {
        return email;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {	
	return id;
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
     * @return the text
     */
    @NotEmpty
    @Column
    @Lob
    public String getText() {
        return text;
    }
    
    /**
     * @param blog the blog to set
     */
    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setId(long id) {
	this.id = id;	
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
	
	/**
	 * @serialField
	 */
	private static final long serialVersionUID = 5724281033461828110L;

	private Builder(){}

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

	public Builder withId(long id) {
	    super.id = id;
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
