/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.security.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Only for JAAS security
 * 
 * @since 1.0
 * @version 1.1
 * @see Serializable
 */
@Entity
@Table(name = "JAAS_Role")
public class JAASRole implements Serializable {

    /**
     * Builder to build {@link JAASRole}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private String name;

	private Builder() {
	}

	public JAASRole build() {
	    return new JAASRole(this);
	}

	public Builder withName(String name) {
	    this.name = name;
	    return this;
	}

	public Builder withSerialVersionUID(long serialVersionUID) {
	    return this;
	}
    }

    private static final long serialVersionUID = -3259219990958750371L;

    @Id
    @Column(unique = true, nullable = false)
    private String name;

    @Generated("SparkTools")
    private JAASRole(Builder builder) {
	this.name = builder.name;
    }

    public JAASRole() {
    }

    /**
     * Creates builder to build {@link JAASRole}.
     * 
     * @return created builder
     */
    @Generated("SparkTools")
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
