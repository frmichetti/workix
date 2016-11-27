package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User JPA {@link Entity}
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see MyEntity 
 */
@Entity
abstract class User extends MyEntity {

	private static final long serialVersionUID = -610648880358327958L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@Column
	private boolean active;

	@NotEmpty
	@Email
	@Column(nullable = false,unique=true)
	private String email;

	@Column
	private String firebaseUUID;

	@Column
	private String firebaseMessageToken;

	/**
	 * @return the id
	 */
	public final long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the active
	 */
	public final boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public final void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firebaseUUID
	 */
	public final String getFirebaseUUID() {
		return firebaseUUID;
	}

	/**
	 * @param firebaseUUID the firebaseUUID to set
	 */
	public final void setFirebaseUUID(String firebaseUUID) {
		this.firebaseUUID = firebaseUUID;
	}

	/**
	 * @return the firebaseMessageToken
	 */
	public final String getFirebaseMessageToken() {
		return firebaseMessageToken;
	}

	/**
	 * @param firebaseMessageToken the firebaseMessageToken to set
	 */
	public final void setFirebaseMessageToken(String firebaseMessageToken) {
		this.firebaseMessageToken = firebaseMessageToken;
	}		
	
}