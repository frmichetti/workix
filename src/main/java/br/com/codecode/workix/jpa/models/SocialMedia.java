package br.com.codecode.workix.jpa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;

@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class SocialMedia implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3082998497652120101L;        

    private String media;
    
    private String url;


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



}
