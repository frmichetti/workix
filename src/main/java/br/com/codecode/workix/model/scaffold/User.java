package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;

@Entity
@Table(name="workix_Users")
@XmlRootElement
public class User extends Loggable implements BasicEntity{

	private static final long serialVersionUID = -610648880358327958L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;	
	
	@Expose
	@Column
	private boolean active;
	
	@NotEmpty
	@Email
	@Expose
	@Column(nullable = false,unique=true)
	private String email;

	@NotEmpty
	@Expose
	@Column
	private String firebaseUUID;

	@Expose
	@Column
	private String firebaseMessageToken;
	
	public User(){}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}	
	
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirebaseUUID() {
		return firebaseUUID;
	}

	public void setFirebaseUUID(String firebaseUUID) {
		this.firebaseUUID = firebaseUUID;
	}

	public String getFirebaseMessageToken() {
		return firebaseMessageToken;
	}

	public void setFirebaseMessageToken(String firebaseMessageToken) {
		this.firebaseMessageToken = firebaseMessageToken;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "User [email=" + email + "]";
	}
	
	public String getUniqueID(){
		return super.getUuid();
	}
	
	

	
	
	
}