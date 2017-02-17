package br.com.codecode.workix.jpa.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.cdi.qualifiers.Persist;

@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Tag implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 323076947054044016L;

    private String name;

    public Tag(){}    
    
    private Tag(Builder builder) {
	this.name = builder.name;
    }


    /**
     * @return the name
     */
    public String getName() {
	return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }


    /**
     * Creates builder to build {@link Tag}.
     * @return created builder
     */    
    public static Builder builder() {
	return new Builder();
    }


    /**
     * Builder to build {@link Tag}.
     */    
    public static final class Builder {

	private String name;

	private Builder() {
	}

	public Builder withName(String name) {
	    this.name = name;
	    return this;
	}

	public Tag build() {
	    return new Tag(this);
	}
    }

}
