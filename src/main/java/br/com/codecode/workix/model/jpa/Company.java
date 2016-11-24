package br.com.codecode.workix.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.codecode.workix.model.base.BaseCompany;

/**
 * Company JPA {@link Entity}
 * @see Person
 * @author felipe
 * @see Person
 * @see BaseCompany
 */
@Entity
public class Company extends Person implements BaseCompany {

	private static final long serialVersionUID = 47663377480544994L;
	
	@Column(nullable = false, unique = true)
	private long cnpj;

	@Column(nullable = false)
	private String segment;	

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Company(){}

	@Override
	public long getCnpj() {
		return cnpj;
	}

	@Override
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String getSegment() {
		return segment;
	}

	@Override
	public void setSegment(String companySegment) {
		this.segment = companySegment;
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
		Company other = (Company) obj;
		if (getId() != other.getId())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [name=" + getName() + ", segment=" + segment + "]";
	}


}