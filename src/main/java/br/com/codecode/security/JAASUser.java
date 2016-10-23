package br.com.codecode.security;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Only for JAAS security
 * 
 * @since 1.0
 * @version
 */
@Entity
@XmlRootElement
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

	@ManyToMany
	private List<JAASRole> roles;

	public JAASUser() {
		// TODO Auto-generated constructor stub
	}

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

	public List<JAASRole> getRoles() {
		return roles;
	}

	public void setRoles(List<JAASRole> roles) {
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
