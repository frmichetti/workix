package br.com.codecode.workix.model.base;

import java.util.Calendar;

/**
 * Root Abstract Class Candidate<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cpf}</li>
 * <li>{@link #birthDate}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see BasePerson
 */
public abstract class BaseCandidate extends BasePerson {

    private long cpf;

    private Calendar birthDate;

    /**
     * Empty Default Construtor
     */
    public BaseCandidate() {
    }

    /**
     * @return the cpf
     */
    public long getCpf() {
	return cpf;
    }

    /**
     * @param cpf
     *            the cpf to set
     */
    public void setCpf(long cpf) {
	this.cpf = cpf;
    }

    /**
     * @return the birthDate
     */
    public Calendar getBirthDate() {
	return birthDate;
    }

    /**
     * @param birthDate
     *            the birthDate to set
     */
    public void setBirthDate(Calendar birthDate) {
	this.birthDate = birthDate;
    }

}
