package br.com.codecode.workix.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.model.enums.Estate;
import br.com.codecode.workix.model.interfaces.Buildable;

/**
 * Locale JPA {@link Embeddable}  
 * @author felipe
 * @category JPA
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Locale implements Serializable {

	private static final long serialVersionUID = -607806075186010186L;

	@Column
	private long zipCode;

	@Column
	private String city;

	@Column
	private String neighborhood;

	@Column
	private String street;

	@Column
	private String number;

	@Enumerated(EnumType.STRING)
	@Column
	private Estate estate;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Locale(){}

	/**
	 * Public Constructor for {@link Builder} Compatibility
	 * @see Buildable
	 * @param builder
	 * @category Builder
	 */
	public Locale(@NotNull Builder builder) {

		this.zipCode = builder.zipCode;

		this.city = builder.city;

		this.neighborhood = builder.neighborhood;

		this.street = builder.street;

		this.number = builder.number;

		this.estate = builder.state;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Estate getEstate() {
		return estate;
	}

	public void setEstate(Estate estate) {
		this.estate = estate;
	}

	@Override
	public String toString() {
		return "Locale [zipCode=" + zipCode + ", street=" + street + ", number=" + number + "]";
	}	

	/**
	 * Builder NestedClass for {@link Skill} 
	 * @category Builder
	 * @author felipe
	 *
	 */
	public static class Builder implements Buildable<Locale> {	

		private Estate state;

		private String number;

		private String street;

		private String neighborhood;

		private String city;

		private long zipCode;

		/**
		 * Disabled Empty Constructor
		 */
		private Builder(){}		

		/**
		 * Constructor with Required Fields
		 * @param zipCode
		 * @param number
		 */
		public Builder(long zipCode,String number) {
			this();
			this.zipCode = zipCode;
			this.number = number;			
		}

		/**
		 * Constructor with All Fields
		 * @param zipCode
		 * @param state
		 * @param city
		 * @param neighborhood
		 * @param street
		 * @param number
		 */
		public Builder(long zipCode, Estate state, String city, String neighborhood,String street,String number) {
			this(zipCode,number);
			this.state = state;			
			this.street = street;
			this.neighborhood = neighborhood;
			this.city = city;
		}		

		public Builder setState(Estate state) {
			this.state = state;
			return this;
		}

		public Builder setNumber(String number) {
			this.number = number;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setNeighborhood(String neighborhood) {
			this.neighborhood = neighborhood;
			return this;
		}

		public Builder setCity(String city) {
			this.city = city;
			return this;
		}

		public Builder setZipCode(long zipCode) {
			this.zipCode = zipCode;
			return this;
		}

		@Override
		public Locale build()
		{
			return new Locale(this);
		}

	}	

}
