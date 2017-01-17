package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Selective Process Class for Compatibility
 * <br>Without Annotations.
 *
 * @author felipe
 * @version 1.1
 * @see Observable
 * @see Observer
 * @see Serializable
 * @since 1.1
 */
public class SelectiveProcess extends Observable implements Observer, Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The active. */
    private boolean active;

    /** The candidates. */
    private Set<Candidate> candidates;

    /** The created at. */
    private Calendar createdAt;

    /** The disabled at. */
    private Calendar disabledAt;

    /** The updated at. */
    private Calendar updatedAt;
    
    /** The start. */
    private Calendar start;
    
    /** The expire. */
    private Calendar expire;
    
    /** The id. */
    private long id;

    /** The job. */
    private Job job;

    /** The max candidates. */
    private int maxCandidates;    

    /** The uuid. */
    private String uuid;

    /** The version. */
    private int version;

    @Generated("SparkTools")
    private SelectiveProcess(Builder builder) {
	this.active = builder.active;
	this.candidates = builder.candidates;
	this.createdAt = builder.createdAt;
	this.disabledAt = builder.disabledAt;
	this.updatedAt = builder.updatedAt;
	this.start = builder.start;
	this.expire = builder.expire;
	this.id = builder.id;
	this.job = builder.job;
	this.maxCandidates = builder.maxCandidates;
	this.uuid = builder.uuid;
	this.version = builder.version;
    }

    /**
     * Public Default Constructor.
     */
    public SelectiveProcess(){}

    /**
     * Count candidates.
     *
     * @return the int
     */
    public int countCandidates() {
	return maxCandidates - candidates.size();
    }

    /**
     * Count candidates.
     *
     * @param collection the collection
     */
    private void countCandidates(Set<Candidate> collection) {
	maxCandidates = collection.size();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    /**
     * Generate UUID.
     */
    protected void generateUUID() {
	this.uuid = UUID.randomUUID().toString();
    }

    /**
     * Gets the candidates.
     *
     * @return the candidates
     */
    public Set<Candidate> getCandidates() {
	return this.candidates;
    }

    /**
     * Gets the created at.
     *
     * @return the created at
     */
    public Calendar getCreatedAt() {
	return createdAt;
    }

    /**
     * Gets the disabled at.
     *
     * @return the disabled at
     */
    public Calendar getDisabledAt() {
	return disabledAt;
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
     * Gets the job.
     *
     * @return the job
     */
    public Job getJob() {
	return this.job;
    }

    /**
     * Gets the max candidates.
     *
     * @return the max candidates
     */
    public int getMaxCandidates() {
	return maxCandidates;
    }

    /**
     * Gets the updated at.
     *
     * @return the updated at
     */
    public Calendar getUpdatedAt() {
	return updatedAt;
    }

    /**
     * Gets the uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
	return uuid;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
	return this.version;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
    }

    /**
     * Initialize Fields.
     */    
    protected void init() {
	this.addObserver(this);
	this.active = true;
	this.candidates = new HashSet<>();
    }

    /**
     * Insert time stamp.
     */
    protected void insertTimeStamp() {
	this.createdAt = Calendar.getInstance();
    }

    /**
     * Checks if is active.
     *
     * @return true, if is active
     */
    public boolean isActive() {
	return active;
    }

    /**
     * Checks if is elegible.
     *
     * @return true, if is elegible
     */
    private boolean isElegible() {
	System.out.println("Process is Elegible " + (candidates.size() < maxCandidates));
	System.out.println("Candidates --> [" + candidates.size() + "/" + maxCandidates + "]");
	return (candidates.size() < maxCandidates);
    }

    /**
     * Checks if is in process.
     *
     * @param candidate the candidate
     * @return true, if is in process
     */
    public boolean isInProcess(Candidate candidate) {
	System.out.println(candidate.getName() + " are in this process ? " + (candidates.contains(candidate)));
	return (candidates.contains(candidate));
    }

    /**
     * Notify changes.
     */
    private void notifyChanges() {
	notifyObservers();
	setChanged();
    }

    /**
     * Notify changes.
     *
     * @param object the object
     */
    private void notifyChanges(Object object) {
	notifyObservers(object);
	setChanged();
    }

    /**
     * Register candidate.
     *
     * @param candidate the candidate
     * @return true, if successful
     */
    public boolean registerCandidate(Candidate candidate) {

	boolean b = false;

	if ((isActive()) && (isElegible()) && (!isInProcess(candidate))) {

	    this.candidates.add(candidate);

	    System.out.println(candidate.getName() + " Registered with Success");

	    b = true;

	} else {

	    System.out.println(candidate.getName() + " Cannot Registered");

	    b = false;
	}

	notifyChanges(candidates);

	return b;

    }

    /**
     * Sets the active.
     *
     * @param active the new active
     */
    protected void setActive(boolean active) {

	if (!active) {
	    this.disabledAt = Calendar.getInstance();
	}

	this.active = active;

	notifyChanges();
    }

    /**
     * Sets the candidates.
     *
     * @param candidates the new candidates
     */
    public void setCandidates(Set<Candidate> candidates) {
	this.candidates = candidates;
	notifyChanges();
    }

    /**
     * Sets the created at.
     *
     * @param createdAt the new created at
     */
    protected void setCreatedAt(Calendar createdAt) {
	this.createdAt = createdAt;
    }

    /**
     * Sets the disabled at.
     *
     * @param disabledAt the new disabled at
     */
    protected void setDisabledAt(Calendar disabledAt) {
	this.disabledAt = disabledAt;
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
     * Sets the job.
     *
     * @param job the new job
     */
    public void setJob(final Job job) {
	this.job = job;
    }

    /**
     * Sets the max candidates.
     *
     * @param maxCandidates the new max candidates
     */
    public void setMaxCandidates(int maxCandidates) {
	this.maxCandidates = maxCandidates;
    }

    /**
     * Sets the updated at.
     *
     * @param updatedAt the new updated at
     */
    protected void setUpdatedAt(Calendar updatedAt) {
	this.updatedAt = updatedAt;
    }

    /**
     * Sets the uuid.
     *
     * @param uuid the new uuid
     */
    protected void setUuid(String uuid) {
	this.uuid = uuid;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    protected void setVersion(final int version) {
	this.version = version;
    }
    
    /**
     * Update time stamp.
     */
    protected void updateTimeStamp() {
	this.updatedAt = Calendar.getInstance();
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
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

    /**
     * Gets the expire.
     *
     * @return the expire
     */
    public Calendar getExpire() {
	return expire;
    }

    /**
     * Sets the expire.
     *
     * @param expire the new expire
     */
    public void setExpire(Calendar expire) {
	this.expire = expire;
    }

    /**
     * Gets the start.
     *
     * @return the start
     */
    public Calendar getStart() {
	return start;
    }

    /**
     * Sets the start.
     *
     * @param start the new start
     */
    public void setStart(Calendar start) {
	this.start = start;
    }

    /**
     * Creates builder to build {@link SelectiveProcess}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link SelectiveProcess}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private boolean active;

	private Set<Candidate> candidates;

	private Calendar createdAt;

	private Calendar disabledAt;

	private Calendar updatedAt;

	private Calendar start;

	private Calendar expire;

	private long id;

	private Job job;

	private int maxCandidates;

	private String uuid;

	private int version;

	private Builder() {
	}

	public Builder withActive(boolean active) {

	    this.active = active;
	    return this;
	}

	public Builder withCandidates(Set<Candidate> candidates) {

	    this.candidates = candidates;
	    return this;
	}

	public Builder withCreatedAt(Calendar createdAt) {

	    this.createdAt = createdAt;
	    return this;
	}

	public Builder withDisabledAt(Calendar disabledAt) {

	    this.disabledAt = disabledAt;
	    return this;
	}

	public Builder withUpdatedAt(Calendar updatedAt) {

	    this.updatedAt = updatedAt;
	    return this;
	}

	public Builder withStart(Calendar start) {

	    this.start = start;
	    return this;
	}

	public Builder withExpire(Calendar expire) {

	    this.expire = expire;
	    return this;
	}

	public Builder withId(long id) {

	    this.id = id;
	    return this;
	}

	public Builder withJob(Job job) {

	    this.job = job;
	    return this;
	}

	public Builder withMaxCandidates(int maxCandidates) {

	    this.maxCandidates = maxCandidates;
	    return this;
	}

	public Builder withUuid(String uuid) {

	    this.uuid = uuid;
	    return this;
	}

	public Builder withVersion(int version) {

	    this.version = version;
	    return this;
	}

	public SelectiveProcess build() {

	    return new SelectiveProcess(this);
	}
    }

    

}