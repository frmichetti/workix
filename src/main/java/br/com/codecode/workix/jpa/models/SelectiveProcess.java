package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.*;

/**
 * Selective Process JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see Observable
 * @see Observer
 * @see Traceable
 * @see Persistable
 * @see Serializable
 * @since 1.0
 */
@Entity
@Table(name = "selective_processes")
@XmlRootElement
@XmlAccessorType()
@Persist
public class SelectiveProcess extends Observable implements Observer, Traceable, Persistable, Serializable {

    private static final long serialVersionUID = -5336099006523168288L;

    @Column
    private boolean active;

    @JoinTable(name = "selective_processes_candidates",
            joinColumns = @JoinColumn(name = "sp_id"), inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Candidate> candidates;

    @Temporal(TemporalType.DATE)
    @Column
    private Date disabledAt;

    @Temporal(TemporalType.DATE)
    @Column
    private Date expire;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long id;

    @ManyToOne(optional = false)
    private Job job;

    @Column(nullable = false)
    private int maxCandidates;

    @Temporal(TemporalType.DATE)
    @Column
    private Date start;

    @XmlTransient
    @Version
    @Column
    private int version;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public SelectiveProcess() {
    }

    public int countCandidates() {
        return maxCandidates - candidates.size();
    }

    private void countCandidates(Set<Candidate> collection) {
        maxCandidates = collection.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof SelectiveProcess)) {
            return false;
        }
        SelectiveProcess other = (SelectiveProcess) obj;
        return id == other.id;
    }

    @Override
    public void generateUUID() {
        String uuid = UUID.randomUUID().toString();
    }

    public Set<Candidate> getCandidates() {
        return this.candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
        notifyChanges();
    }

    /**
     * @return the expire
     */
    public Date getExpire() {
        return expire;
    }

    /**
     * @param expire the expire to set
     */
    public void setExpire(Date expire) {
        this.expire = expire;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(final Job job) {
        this.job = job;
    }

    public int getMaxCandidates() {
        return maxCandidates;
    }

    public void setMaxCandidates(int maxCandidates) {
        this.maxCandidates = maxCandidates;
    }

    /**
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Date start) {
        this.start = start;
    }

    protected int getVersion() {
        return this.version;
    }

    protected void setVersion(final int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    @PostConstruct
    private void init() {
        this.addObserver(this);
        active = true;
        candidates = new HashSet<>();
    }

    @Override
    public void insertTimeStamp() {
        Date createdAt = new Date();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {

        if (!active) {
            disabledAt = new Date();
        }

        this.active = active;

        notifyChanges();
    }

    private boolean isElegible() {
        System.out.println("Process is Elegible " + (candidates.size() < maxCandidates));
        System.out.println("Candidates --> [" + candidates.size() + "/" + maxCandidates + "]");
        return (candidates.size() < maxCandidates);
    }

    private boolean isInProcess(Candidate candidate) {
        System.out.println(candidate.getName() + " are in this process ? " + (candidates.contains(candidate)));
        return (candidates.contains(candidate));
    }

    private void notifyChanges() {
        notifyObservers();
        setChanged();
    }

    private void notifyChanges(Object object) {
        notifyObservers(object);
        setChanged();
    }

    @PrePersist
    @Override
    public void prepareToPersist() {
        Traceable.super.prepareToPersist();
    }

    public boolean registerCandidate(Candidate candidate) {

        boolean b = false;

        if ((isActive()) && (isElegible()) && (!isInProcess(candidate))) {

            candidates.add(candidate);

            System.out.println(candidate.getName() + " Registered with Success");

            b = true;

        } else {

            System.out.println(candidate.getName() + " Cannot Registered");

            b = false;
        }

        notifyChanges(candidates);

        return b;

    }

    @Override
    public void update(Observable observable, Object object) {

        if (observable instanceof SelectiveProcess) {

            if (active = isElegible()) {

                if (object instanceof Collection<?>) {

                    countCandidates((Set<Candidate>) object);

                }

            } else {
                if (disabledAt != null)
                    System.out.println("Max candidates Reached - Disabled Process at " + disabledAt);
            }

        }
    }

    @PreUpdate
    @Override
    public void updateTimeStamp() {
        Date updatedAt = new Date();
    }

}