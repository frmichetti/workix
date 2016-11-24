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
 * @see Persistable
 * @see Serializable
 */
@Entity
public class Subscriber implements Persistable, Serializable {

	private static final long serialVersionUID = 6675137603968146834L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@NotEmpty
	@Email	
	@Column(nullable = false,unique = true)
	private String email;

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
	
	/**
	 * @return the id
	 */
	@Override
	public long getId() {
		return this.id;
	}	

	/**
	 * @param id the id to set
	 */
	@Override
	public final void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * Builder NestedClass for Subscriber 
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
	 * @see Buildable
	 * @see RootSubscriber
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
			this.setEmail(email);
		}	

		/**
		 * Constructor with All Fields
		 * @param id Id
		 * @param email Email
		 */
		public Builder(long id, String email) {
			super();
			this.setId(id);
			this.setEmail(email);
		}		

		/**
		 * @param email the email to set
		 * @return Builder
		 */
		public Builder withEmail(String email) {
			this.setEmail(email);
			return this;
		}	

		/**
		 * @param id the id to set
		 * @return Builder
		 */
		public Builder withId(long id) {
			this.setId(id);
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
