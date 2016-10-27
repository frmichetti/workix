package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;

@Entity
@Table(name="openjobs_Companies")
@XmlRootElement
public class Company extends Loggable implements BasicEntity {

	private static final long serialVersionUID = 47663377480544994L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@NotEmpty
	@Expose
	@Column(nullable = false)
	private String name;
	
	@Expose
	@Column(nullable = false)
	private String segment;
	
	@Expose
	@NotEmpty
	@Column(nullable = false,unique=true)
	private String cnpj;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Company)) {
			return false;
		}
		Company other = (Company) obj;
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
		return "Company [name=" + name + ", segment=" + segment + "]";
	}

	
}