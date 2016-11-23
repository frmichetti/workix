package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Company extends Person {

	private static final long serialVersionUID = 47663377480544994L;

	@NotEmpty	
	@Column(nullable = false,unique = true)
	private String cnpj;

	@Column(nullable = false)
	private String segment;	

	public Company(){}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getSegment() {
		return segment;
	}


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