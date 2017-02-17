package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;

/**
 * Comment JPA with Inherited Fields and Methods
 * 
 * @see MyEntity
 * @author felipe
 * 
 * @since 1.0
 * @version 1.0
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Comment extends MyEntity {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7358996279677908814L;
    
    private String email;
    
    private long id; 
    
    private String name;
    
    private Blog blog;    
    
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

}
