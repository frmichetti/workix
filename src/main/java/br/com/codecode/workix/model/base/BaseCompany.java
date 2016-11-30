package br.com.codecode.workix.model.base;

/**
 * Root Abstract Class Company<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cnpj}</li>
 * <li>{@link #segment}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see BasePerson
 */
public abstract class BaseCompany extends BasePerson {

    private long cnpj;

    private String segment;

    /**
     * Empty Default Constructor
     */
    public BaseCompany() {
    }

    /**
     * @return the cnpj
     */
    public long getCnpj() {
	return cnpj;
    }

    /**
     * @param cnpj
     *            the cnpj to set
     */
    public void setCnpj(long cnpj) {
	this.cnpj = cnpj;
    }

    /**
     * @return the segment
     */
    public String getSegment() {
	return segment;
    }

    /**
     * @param segment
     *            the segment to set
     */
    public void setSegment(String segment) {
	this.segment = segment;
    }

}
