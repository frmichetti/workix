package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;

/**
 * Selective Process JPA with Inherited Fields and Methods
 * <br>Without Annotations
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Observable
 * @see Observer
 * @see Serializable
 */

public class SelectiveProcess extends Observable implements Observer, Serializable {

    private static final long serialVersionUID = -5336099006523168288L;

    private long id;

    private int version;

    private String uuid;

    private LocalDateTime createdAt;
  
    private LocalDateTime updatedAt;

    private Job job;

    private Set<Candidate> candidates;

    private boolean active;

    private LocalDateTime disabledAt;

    private int maxCandidates;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public SelectiveProcess() {
    }

    private void countCandidates(Set<Candidate> collection) {
	maxCandidates = collection.size();
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

    private boolean isElegible() {
	System.out.println("Process is Elegible " + (candidates.size() < maxCandidates));
	System.out.println("Candidates --> [" + candidates.size() + "/" + maxCandidates + "]");
	return (candidates.size() < maxCandidates);
    }

    private void notifyChanges() {
	notifyObservers();
	setChanged();
    }

    private void notifyChanges(Object object) {
	notifyObservers(object);
	setChanged();
    }

    protected int getVersion() {
	return this.version;
    }

    protected void setActive(boolean active) {

	if (!active) {
	    disabledAt = LocalDateTime.now();
	}

	this.active = active;

	notifyChanges();
    }

    protected void setVersion(final int version) {
	this.version = version;
    }

    public int countCandidates() {
	return maxCandidates - candidates.size();
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
	if (id != other.id) {
	    return false;
	}
	return true;
    }
    
    public void generateUUID() {
	uuid = UUID.randomUUID().toString();
    }

    public Set<Candidate> getCandidates() {
	return this.candidates;
    }

    public long getId() {
	return this.id;
    }

    public Job getJob() {
	return this.job;
    }

    public int getMaxCandidates() {
	return maxCandidates;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
    }

    public void insertTimeStamp() {
	createdAt = LocalDateTime.now();
    }

    public boolean isActive() {
	return active;
    }

    public boolean isInProcess(Candidate candidate) {
	System.out.println(candidate.getName() + " are in this process ? " + (candidates.contains(candidate)));
	return (candidates.contains(candidate));
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

    public void setCandidates(Set<Candidate> candidates) {
	this.candidates = candidates;
	notifyChanges();
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setJob(final Job job) {
	this.job = job;
    }

    public void setMaxCandidates(int maxCandidates) {
	this.maxCandidates = maxCandidates;
    }

    @SuppressWarnings("unchecked")
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

    public void updateTimeStamp() {
	updatedAt = LocalDateTime.now();
    }

}