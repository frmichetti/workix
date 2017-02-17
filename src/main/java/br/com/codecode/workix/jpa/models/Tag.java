package br.com.codecode.workix.jpa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Tag JPA Embeddable
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
public class Tag implements Serializable{

    /**
     * @serialField
     */
    private static final long serialVersionUID = 323076947054044016L;

    private String name;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Tag(){}    
    
    private Tag(Builder builder) {
	this.name = builder.name;
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
     * Builder NestedClass for {@link Tag}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Tag
     * @see Buildable
     */   
    public static final class Builder extends Tag implements Buildable<Tag> {

	/**
	 * @serialField
	 */
	private static final long serialVersionUID = -5775038446937981944L;
	
	private String name;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	public Builder withName(String name) {
	    this.name = name;
	    return this;
	}

	@Override
	public Tag build() {
	    return new Tag(this);
	}
    }

}
