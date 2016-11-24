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

/**
 * Subscriber JPA {@link Entity}
 * @author felipe
 */
@Entity
public class Subscriber implements Persistable, Serializable{

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
		
		this.id = builder.id;

		this.email = builder.email;
	}

	@Override
	public long getId() {
		return id;
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Subscriber [email=" + email + "]";
	}

	/**
	 * Builder NestedClass for Subscriber 
	 * @author felipe
	 */
	public static class Builder implements Buildable<Subscriber> {

		private long id;
		
		private String email;
		
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

		public Builder setId(long id) {
			this.id = id;
			return this;
		}		

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}	

		@Override
		public Subscriber build() {

			return new Subscriber(this);
		}

	}

}
