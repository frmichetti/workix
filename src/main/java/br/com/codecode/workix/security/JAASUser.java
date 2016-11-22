package br.com.codecode.workix.security;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Only for JAAS security
 * 
 * @since 1.0
 * @version
 */
@XmlRootElement
@Table(name="JAAS_User")
@Entity
public class JAASUser implements Serializable {

	private static final long serialVersionUID = -1917498851904653016L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column
	private String login;

	@Column
	private String password;

	@JoinTable(name="JAAS_Roles")
	@ManyToMany(fetch=FetchType.EAGER,targetEntity=JAASUser.class)		
	private Set<JAASRole> roles;

	public JAASUser(){}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<JAASRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<JAASRole> roles) {
		this.roles = roles;
	}

	@PrePersist
	@PreUpdate
	private void encode() {
		this.password = PassGenerator.generate(this.password);
	}

	@Override
	public String toString() {
		return login;
	}

}
