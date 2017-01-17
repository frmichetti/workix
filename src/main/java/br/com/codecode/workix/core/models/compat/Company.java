package br.com.codecode.workix.core.models.compat;

import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Company Class for Compatibility
 * <br>Without Annotations .
 *
 * @author felipe
 * @version 1.1
 * @see Person
 * @since 1.1
 */
public class Company extends Person {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The cnpj. */
    private long id, cnpj;

    /** The segment. */
    private String segment;

    @Generated("SparkTools")
    private Company(Builder builder) {
	this.id = builder.id;
	this.cnpj = builder.cnpj;
	this.segment = builder.segment;
    }

    /**
     * Public Default Constructor.
     */
    public Company(){}

    /**
     * Gets the cnpj.
     *
     * @return the cnpj
     */
    public long getCnpj() {
	return cnpj;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
	return this.id;
    }

    /**
     * Gets the segment.
     *
     * @return the segment
     */
    public String getSegment() {
	return segment;
    }

    /**
     * Sets the cnpj.
     *
     * @param cnpj the new cnpj
     */
    public void setCnpj(long cnpj) {
	this.cnpj = cnpj;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
	this.id = id;
    }

    /**
     * Sets the segment.
     *
     * @param companySegment the new segment
     */
    public void setSegment(String companySegment) {
	this.segment = companySegment;
    }

    /**
     * Creates builder to build {@link Company}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Company}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private long id;

	private long cnpj;

	private String segment;

	private Builder() {
	}

	public Builder withId(long id) {

	    this.id = id;
	    return this;
	}

	public Builder withCnpj(long cnpj) {

	    this.cnpj = cnpj;
	    return this;
	}

	public Builder withSegment(String segment) {

	    this.segment = segment;
	    return this;
	}

	public Company build() {

	    return new Company(this);
	}
    }

}