package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Testimonial extends MyEntity {
    
    /**
     * 
     */
    private static final long serialVersionUID = 9143527358797800527L;
    
    private long id;
    
    private String text;
    
    private String name;
        
    
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
