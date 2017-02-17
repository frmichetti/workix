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

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;

/**
 * Author JPA with Inherited Fields and Methods
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
public class Author extends MyEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 4441917823240375511L;

    private long id;

    private String aboutText;

    private List<SocialMedia> medias;

    private String name;

    private String picture;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Author(){}

    /**
     * @return the aboutText
     */
    @NotEmpty
    @Column
    public String getAboutText() {
	return aboutText;
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
    @CollectionTable(name = "Author_Medias", joinColumns = @JoinColumn(name = "id"))
    public List<SocialMedia> getMedias() {
	return medias;
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
     * @return the name
     */
    @NotEmpty
    @Column
    public String getName() {
	return name;
    }

    /**
     * @return the picture
     */
    @Column
    public String getPicture() {
	return picture;
    }

    /**
     * @param aboutText
     *            the aboutText to set
     */
    public void setAboutText(String aboutText) {
	this.aboutText = aboutText;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

    /**
     * @param medias
     *            the medias to set
     */
    public void setMedias(List<SocialMedia> medias) {
	this.medias = medias;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @param picture
     *            the picture to set
     */
    public void setPicture(String picture) {
	this.picture = picture;
    }

}
