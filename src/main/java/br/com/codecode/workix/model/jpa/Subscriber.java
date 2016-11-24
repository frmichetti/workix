package br.com.codecode.workix.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.interfaces.Buildable;
import br.com.codecode.workix.model.interfaces.Persistable;
import br.com.codecode.workix.model.root.RootSubscriber;

/**
 * Subscriber JPA {@link Entity}
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see RootSubscriber
 * @see Persistable
 * @see Serializable
 */
@Entity
public class Subscriber extends RootSubscriber implements Persistable, Serializable{

	private static final long serialVersionUID = 6675137603968146834L;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Subscriber(){}	

	/**
	 * Public Constructor for {@link Builder} Compatibility
	 * @see Buildable
	 * @param builder Builder for Generate New Subscriber
	 */
	public Subscriber(@NotNull Builder builder){
		
		this.id = builder.getId();

		this.email = builder.getEmail();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	@Override
	public long getId() {
		return id;
	}
	
	@NotEmpty
	@Email	
	@Column(nullable = false,unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Subscriber [email=" + email + "]";
	}

	/**
	 * Builder NestedClass for Subscriber 
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
	 */
	public final static class Builder extends RootSubscriber implements Buildable<Subscriber> {
		
		/**
		 * Disabled Empty Constructor
		 */
		private Builder(){}

		/**
		 * Constructor with Required Fields
		 * @param email Email
		 */
		public Builder(String email) {
			this();
			this.email = email;
		}	
		
		/**
		 * Constructor with All Fields
		 * @param id Id
		 * @param email Email
		 */
		public Builder(long id, String email) {
			super();
			this.id = id;
			this.email = email;
		}
		
		/**
		 * @return the id
		 */
		public final long getId() {
			return id;
		}				

		/**
		 * @return the email
		 */
		public final String getEmail() {
			return email;
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
		 * @param id the id to set
		 * @return Builder
		 */
		public Builder setId(long id) {
			this.id = id;
			return this;
		}

		/**
		 * @return A new Subscriber
		 */
		@Override
		public Subscriber build() {

			return new Subscriber(this);
		}

	}

}
