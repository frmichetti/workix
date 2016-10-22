package br.com.codecode.openjobs.model.scaffold;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

@Entity
@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@XmlTransient
	@JsonIgnore
	@Version
	@Column(name = "version")
	private int version;

	@Expose
	@Column(nullable = false)
	private String email;

	@Expose
	@Column
	private String firebaseUUID;

	@Expose
	@Column
	private String firebaseMessageToken;

	@Expose
	@Column
	private String uuid;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	private int getVersion() {
		return this.version;
	}

	private void setVersion(final int version) {
		this.version = version;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
		String result = getClass().getSimpleName() + " ";
		if (email != null && !email.trim().isEmpty())
			result += "email: " + email;
		if (firebaseUUID != null && !firebaseUUID.trim().isEmpty())
			result += ", firebaseUUID: " + firebaseUUID;
		if (firebaseMessageToken != null
				&& !firebaseMessageToken.trim().isEmpty())
			result += ", firebaseMessageToken: " + firebaseMessageToken;
		if (uuid != null && !uuid.trim().isEmpty())
			result += ", uuid: " + uuid;
		return result;
	}
	
	
}