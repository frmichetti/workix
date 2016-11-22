package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.BaseEntity;
import br.com.codecode.workix.model.interfaces.Persistable;

@Entity
public class User extends BaseEntity implements Persistable{

	private static final long serialVersionUID = -610648880358327958L;
	
	@Column
	private boolean active;
	
	@Email
	@Column(nullable = false,unique=true)
	private String email;

	@NotEmpty
	@Column
	private String firebaseUUID;

	@NotEmpty
	@Column
	private String firebaseMessageToken;

	public User(){}	

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

	public String getUniqueID(){
		return super.getUuid();
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (getId() ^ (getId() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (getId() != other.getId())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + "]";
	}

}