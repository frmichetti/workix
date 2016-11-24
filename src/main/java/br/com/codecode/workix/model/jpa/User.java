package br.com.codecode.workix.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.interfaces.Buildable;
import br.com.codecode.workix.model.root.RootUser;

/**
 * User JPA {@link Entity}
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@Entity
public class User extends MyEntity {

	private static final long serialVersionUID = -610648880358327958L;

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
	 * Public Default Constructor for JPA Compatibility Only
	 */	
	public User(){}	

	/**
	 * Public Constructor for {@link Builder} Compatibility
	 * @see Buildable
	 * @param builder Builder for Generate a New User
	 */
	public User(@NotNull Builder builder){

		this.active = builder.isActive();

		this.email = builder.getEmail();

		this.firebaseUUID = builder.getFirebaseUUID();

		this.firebaseMessageToken = builder.getFirebaseMessageToken();
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

	/**
	 * Builder NestedClass for {@link User} 
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
	 */
	public final static class Builder extends RootUser implements Buildable<User> {	

		/**
		 * Disabled Empty Constructor
		 */
		private Builder(){}		
		
		/**
		 * Constructor with Required Fields
		 * @param active Active
		 * @param email Email
		 */
		public Builder(boolean active, String email) {
			this();
			this.active = active;
			this.email = email;
		}
		
		/**
		 * Constructor with All Fields
		 * @param active Active
		 * @param email Email
		 * @param firebaseUUID Firebase UUID
		 * @param firebaseMessageToken Firebase Message Token
		 */
		public Builder(boolean active, String email, String firebaseUUID, String firebaseMessageToken) {
			this(active,email);			
			this.firebaseUUID = firebaseUUID;
			this.firebaseMessageToken = firebaseMessageToken;
		}		
		
		/**
		 * @return the active
		 */
		public final boolean isActive() {
			return active;
		}

		/**
		 * @return the email
		 */
		public final String getEmail() {
			return email;
		}

		/**
		 * @return the firebaseUUID
		 */
		public final String getFirebaseUUID() {
			return firebaseUUID;
		}

		/**
		 * @return the firebaseMessageToken
		 */
		public final String getFirebaseMessageToken() {
			return firebaseMessageToken;
		}

		/**
		 * @param active the active to set
		 * @return Builder
		 */
		public Builder setActive(boolean active) {
			this.active = active;
			return this;
		}

		/**
		 * @param email the email to set
		 * @return Builder
		 */
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * @param firebaseUUID the firebaseUUID to set
		 * @return Builder
		 */
		public Builder setFirebaseUUID(String firebaseUUID) {
			this.firebaseUUID = firebaseUUID;
			return this;
		}

		/**
		 * @param firebaseMessageToken the firebaseMessageToken to set
		 * @return Builder
		 */
		public Builder setFirebaseMessageToken(String firebaseMessageToken) {
			this.firebaseMessageToken = firebaseMessageToken;
			return this;
		}

		/**
		 * Return a New User
		 */
		@Override
		public User build()
		{
			return new User(this);
		}

	}	

}