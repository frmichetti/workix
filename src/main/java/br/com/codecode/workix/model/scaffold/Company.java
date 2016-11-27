package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Company JPA {@link Entity}
 * @see Person
 * @author felipe
 * @since 1.1
 * @version 1.1
 */
@Entity
abstract class Company extends Person {

	private static final long serialVersionUID = 47663377480544994L;
	
	@Column(nullable = false, unique = true)
	private long cnpj;

	@Column(nullable = false)
	private String segment;

	/**
	 * @return the cnpj
	 */
	public final long getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public final void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the segment
	 */
	public final String getSegment() {
		return segment;
	}

	/**
	 * @param segment the segment to set
	 */
	public final void setSegment(String segment) {
		this.segment = segment;
	}			

}