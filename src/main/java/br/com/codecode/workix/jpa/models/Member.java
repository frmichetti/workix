package br.com.codecode.workix.jpa.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Member JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @see MyEntity
 * @since 1.0
 * @version 1.1
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Member extends MyEntity {

    /**
     * @serialField Default Auto Generated Serial
     */
    private static final long serialVersionUID = -9177132485712227287L;

    private long id;

    private List<SocialMedia> medias;

    private String name;    

    private String occupation;

    private String picture;

    private String shortText;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Member(){}


    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Member
     */
    private Member(Builder builder) {	
	this.medias = builder.getMedias();
	this.name = builder.getName();
	this.occupation = builder.getOccupation();
	this.picture = builder.getPicture();
	this.shortText = builder.getShortText();
    }

    /**
     * Creates builder to build {@link Member}.
     * @return created builder
     */
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }

    /**
     * Add Social Media
     * @param socialMedia
     */
    public void addSocialMedia(SocialMedia socialMedia){
	if(medias == null){
	    medias = new ArrayList<>();
	}

	medias.add(socialMedia);
    }


    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return id;
    }


    /**
     * @return the medias
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Member_Medias", joinColumns = @JoinColumn(name = "id"))
    public List<SocialMedia> getMedias() {
	return medias;
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
     * @return the occupation
     */
    @NotEmpty
    @Column
    public String getOccupation() {
	return occupation;
    }


    /**
     * @return the picture
     */    
    @Column
    public String getPicture() {
	return picture;
    }

    /**
     * @return the shortText
     */
    @NotEmpty
    @Column
    public String getShortText() {
	return shortText;
    }

    /**
     * Remove Social Media
     * @param socialMedia
     */
    public void removeSocialMedia(SocialMedia socialMedia){
	if(medias == null){
	    medias = new ArrayList<>();
	}

	medias.remove(socialMedia);
    }


    /**
     * @param id the id to set
     */
    public void setId(long id) {
	this.id = id;
    }


    /**
     * @param medias the medias to set
     */
    public void setMedias(List<SocialMedia> medias) {
	this.medias = medias;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }


    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
	this.occupation = occupation;
    }


    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
	this.picture = picture;
    }

    /**
     * @param shortText the shortText to set
     */
    public void setShortText(String shortText) {
	this.shortText = shortText;
    }

    /**
     * Builder to build {@link Member}.
     */    
    public static final class Builder extends Member implements Buildable<Member> {

	/**
	 * @serialField Default Auto Generated Serial
	 */
	private static final long serialVersionUID = -7634080325625899123L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * @return a new Member
	 */
	public Member build() {
	    return new Member(this);
	}	

	public Builder withMedias(List<SocialMedia> medias) {
	    super.medias = medias;
	    return this;
	}

	public Builder withName(String name) {
	    super.name = name;
	    return this;
	}

	public Builder withOccupation(String occupation) {
	    super.occupation = occupation;
	    return this;
	}

	public Builder withPicture(String picture) {
	    super.picture = picture;
	    return this;
	}

	public Builder withShortText(String shortText) {
	    super.shortText = shortText;
	    return this;
	}
    }



}
