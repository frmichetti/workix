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
     * @serialField
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
    
    

}
