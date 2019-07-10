package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.cdi.qualifiers.Persist;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Candidate JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 * @see Person
 * @author felipe
 * @see Person
 * @since 1.0
 * @version 1.1
 */
@Entity
@Table(name = "T_CANDIDATES")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Candidate extends Person {

    private static final long serialVersionUID = 531807027259604477L;

    private Date birthDate;

    private long id, cpf;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Candidate(){}

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    @Column(nullable = false, unique = true)
    public long getCpf() {
        return cpf;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANDIDATE_SEQUENCE")
    @SequenceGenerator(name="CANDIDATE_SEQUENCE", sequenceName="CANDIDATE_SEQUENCE")
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
        return this.id;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    @PostConstruct
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