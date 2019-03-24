package br.com.codecode.workix.jpa.models.jdk7;

import java.util.Calendar;

/**
 * Candidate JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see Person
 * @see Person
 * @since 1.0
 */
public class Candidate extends Person {

    private static final long serialVersionUID = 531807027259604477L;

    private Calendar birthDate;

    private long id, cpf;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Candidate() {
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    private void init() {
        birthDate = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Candidate [id=")
                .append(id)
                .append(", cpf=")
                .append(cpf)
                .append(", birthDate=")
                .append(birthDate)
                .append("]")
                .append(" User [")
                .append(super.getUser().getEmail())
                .append("]")
                .toString();
    }


}