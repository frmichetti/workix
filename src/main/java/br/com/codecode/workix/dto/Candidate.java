package br.com.codecode.workix.dto;


import java.util.Date;

public class Candidate extends Person {

    private static final long serialVersionUID = 531807027259604477L;

    private Date birthDate;

    private long id, cpf;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Candidate(){}

    public Date getBirthDate() {
        return birthDate;
    }

    public long getCpf() {
        return cpf;
    }

    @Override
    public long getId() {
        return this.id;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    private void init() {
        birthDate = new Date();
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Candidate [id=" +
                id +
                ", cpf=" +
                cpf +
                ", birthDate=" +
                birthDate +
                "]" +
                " User [" +
                super.getUser().getEmail() +
                "]";
    }

}