package br.com.codecode.workix.jaas.model;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.Generated;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.jaas.PassGenerator;

/**
 * Only for JAAS security
 * 
 * @since 1.0
 * @version 1.1
 * @see Persistable
 * @see Serializable
 */
/*@Entity
@Table(name = "JAAS_User")*/
public class JAASUser extends JAASBase {

    /**
     * Builder to build {@link JAASUser}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private String login;

	private String password;

	private Set<JAASRole> roles;

	private PassGenerator passGenerator;

	private Builder() {
	}

	public JAASUser build() {
	    return new JAASUser(this);
	}

	public Builder withLogin(String login) {
	    this.login = login;
	    return this;
	}

	public Builder withPassGenerator(PassGenerator passGenerator) {
	    this.passGenerator = passGenerator;
	    return this;
	}

	public Builder withPassword(String password) {
	    this.password = password;
	    return this;
	}

	public Builder withRoles(Set<JAASRole> roles) {
	    this.roles = roles;
	    return this;
	}
    }

    private static final long serialVersionUID = -1917498851904653016L;

    @Column
    private String login;

    @Column
    private String password;

    @JoinTable(name = "JAAS_Roles", joinColumns = @JoinColumn(name = "id"),
	inverseJoinColumns = @JoinColumn(name = "role_name"))
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<JAASRole> roles;

    @Inject
    private transient PassGenerator passGenerator;

    @Generated("SparkTools")
    private JAASUser(Builder builder) {
	this.login = builder.login;
	this.password = builder.password;
	this.roles = builder.roles;
	this.passGenerator = builder.passGenerator;
    }

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public JAASUser() {
    }

    /**
     * Creates builder to build {@link JAASUser}.
     * 
     * @return created builder
     */
    @Generated("SparkTools")
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }

    @PrePersist
    @PreUpdate
    private void encode() {
	this.password = passGenerator.generate(this.password);
    }

    public String getLogin() {
	return login;
    }

    public String getPassword() {
	return password;
    }

    public Set<JAASRole> getRoles() {
	return roles;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setRoles(Set<JAASRole> roles) {
	this.roles = roles;
    }

    @Override
    public String toString() {
	return new StringBuilder().append("JAASUser [login=").append(login).append(", roles=").append(roles).append("]")
		.toString();
    }

}
