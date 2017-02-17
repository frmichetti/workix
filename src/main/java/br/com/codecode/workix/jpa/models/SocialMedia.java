package br.com.codecode.workix.jpa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;

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

    /**
     * @serialField
     */
    private static final long serialVersionUID = -3082998497652120101L;        

    private String media;

    private String url;    

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public SocialMedia(){}

    private SocialMedia(Builder builder) {
	this.media = builder.media;
	this.url = builder.url;
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
     * Creates builder to build {@link SocialMedia}.
     * @return created builder
     */    
    public static Builder builder() {
	return new Builder();
    }


    /**
     * Builder to build {@link SocialMedia}.
     */    
    public static final class Builder {

	private String media;

	private String url;

	private Builder() {
	}

	public Builder withMedia(String media) {
	    this.media = media;
	    return this;
	}

	public Builder withUrl(String url) {
	    this.url = url;
	    return this;
	}

	public SocialMedia build() {
	    return new SocialMedia(this);
	}
    }



}
