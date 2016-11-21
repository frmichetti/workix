package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Company extends Person {

	private static final long serialVersionUID = 47663377480544994L;
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@NotEmpty
	@Expose	
	@Column(nullable = false,unique=true)
	private String cnpj;
		
	@Expose
	@Column(nullable = false)
	private String segment;	
	
	public Company(){}
	
	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}	
	
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
	
	public void setName(String name) {
		this.name = name;
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
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [name=" + super.name + ", segment=" + segment + "]";
	}

	
}