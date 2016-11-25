package br.com.codecode.workix.model.root;

/**
 * Root Abstract Class Company<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cnpj}</li>
 * <li>{@link #segment}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see RootPerson
 */
public abstract class RootCompany extends RootPerson {
	
	private long cnpj;
	
	private String segment;
	
	/**
	 * Empty Default Constructor
	 */
	public RootCompany(){}

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
