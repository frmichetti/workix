package br.com.codecode.workix.jpa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * SocialMedia JPA Embeddable
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Serializable
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class SocialMedia implements Serializable {

   
    private static final long serialVersionUID = -3082998497652120101L;        

    private String media;

    private String url;    

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public SocialMedia(){}

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New SocialMedia
     */
    private SocialMedia(Builder builder) {
	this.media = builder.getMedia();
	this.url = builder.getUrl();
    }


    /**
     * Creates builder to build {@link SocialMedia}.
     * @return created builder
     */    
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }


    /**
     * @return the media
     */
    @NotEmpty
    @Column    
    public String getMedia() {
	return media;
    }

    /**
     * @return the url
     */
    @NotEmpty
    @Column  
    public String getUrl() {
	return url;
    }


    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
	this.media = media;
    }


    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
	this.url = url;
    }


    /**
     * Builder to build {@link SocialMedia}.
     */    
    public static final class Builder extends SocialMedia implements Buildable<SocialMedia> {

	/**
	 * @serialField Default Auto Generated Serial
	 */
	private static final long serialVersionUID = -4455052272130426281L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * @return a new SocialMedia
	 */
	@Override
	public SocialMedia build() {
	    return new SocialMedia(this);
	}

	public Builder withMedia(String media) {
	    super.media = media;
	    return this;
	}

	public Builder withUrl(String url) {
	    super.url = url;
	    return this;
	}
    }



}
