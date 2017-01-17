package br.com.codecode.workix.core.models.compat;

import java.util.Calendar;
import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Candidate Class for Compatibility
 * <br>Without Annotations.
 *
 * @author felipe
 * @version 1.1
 * @see Person
 * @since 1.1
 */
public class Candidate extends Person {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The birth date. */
    private Calendar birthDate;

    /** The cpf. */
    private long id, cpf;

    @Generated("SparkTools")
    private Candidate(Builder builder) {
	this.birthDate = builder.birthDate;
	this.id = builder.id;
	this.cpf = builder.cpf;
    }

    /**
     * Public Default Constructor for JPA Compatibility Only.
     */
    public Candidate() {
    }

    /**
     * Gets the birth date.
     *
     * @return the birth date
     */
    public Calendar getBirthDate() {
	return birthDate;
    }

    /**
     * Gets the cpf.
     *
     * @return the cpf
     */
    public long getCpf() {
	return cpf;
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
     * Initialize Fields.
     */
    protected void init() {
	birthDate = Calendar.getInstance();
    }

    /**
     * Sets the birth date.
     *
     * @param birthDate the new birth date
     */
    public void setBirthDate(Calendar birthDate) {
	this.birthDate = birthDate;
    }

    /**
     * Sets the cpf.
     *
     * @param cpf the new cpf
     */
    public void setCpf(long cpf) {
	this.cpf = cpf;
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
     * Creates builder to build {@link Candidate}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Candidate}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private Calendar birthDate;

	private long id;

	private long cpf;

	private Builder() {
	}

	public Builder withBirthDate(Calendar birthDate) {

	    this.birthDate = birthDate;
	    return this;
	}

	public Builder withId(long id) {

	    this.id = id;
	    return this;
	}

	public Builder withCpf(long cpf) {

	    this.cpf = cpf;
	    return this;
	}

	public Candidate build() {

	    return new Candidate(this);
	}
    }

}