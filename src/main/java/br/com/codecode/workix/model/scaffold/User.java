package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.Loggable;
import br.com.codecode.workix.model.interfaces.BaseEntity;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends Loggable implements BaseEntity{

	private static final long serialVersionUID = -610648880358327958L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;	

	@Expose
	@Column
	private boolean active;

	@Expose
	@NotEmpty
	@Email	
	@Column(nullable = false,unique=true)
	private String email;

	@Expose
	@NotEmpty	
	@Column
	private String firebaseUUID;

	@Expose
	@Column
	private String firebaseMessageToken;

	public User(){}

	@Override
	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
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

	public String getUniqueID(){
		return super.getUuid();
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + "]";
	}




}