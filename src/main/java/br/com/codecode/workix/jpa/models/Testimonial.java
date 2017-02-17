package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;

/**
 * Testimonial JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Testimonial extends MyEntity {
    
    /**
     * @serialField
     */
    private static final long serialVersionUID = 9143527358797800527L;
    
    private long id;
    
    private String text;
    
    private Author author;
    
    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Testimonial(){}
    
    
    /**
     * @return the author
     */
    @NotNull
    @OneToOne
    public Author getAuthor() {
        return author;
    }


    
    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }


    private String signature;
    
    private String picture;

    
    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return this.id;
    }

    
    /**
     * @return the text
     */
    @NotEmpty
    @Lob
    @Column
    public String getText() {
        return text;
    }

    
    /**
     * @return the signature
     */
    @NotEmpty
    @Column
    public String getSignature() {
        return signature;
    }

    
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    
    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    
    /**
     * @param signature the signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @NotEmpty
    @Column
    public String getPicture() {
	return picture;
    }


    public void setPicture(String picture) {
	this.picture = picture;
    }


}
