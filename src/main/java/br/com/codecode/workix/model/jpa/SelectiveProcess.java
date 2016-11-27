package br.com.codecode.workix.model.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;

/**
 * Selective Process JPA with Inherited Fields and Methods 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Observable
 * @see Observer
 * @see Traceable
 * @see Persistable
 * @see Serializable
 */
public class SelectiveProcess extends Observable implements Observer, Traceable, Persistable, Serializable {

	private static final long serialVersionUID = -5336099006523168288L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@XmlTransient
	@Version
	@Column
	private int version;

	@XmlTransient
	@Column(nullable = false)
	private String uuid;

	@XmlTransient	
	@Column	
	private Timestamp createdAt;

	@XmlTransient	
	@Column		
	private Timestamp updatedAt;

	@NotNull
	@ManyToOne(optional=false)
	private Job job;	

	@NotNull
	@JoinTable(name="Selective_Process_Candidates",
	joinColumns=@JoinColumn(name="sp_id"),
			inverseJoinColumns=@JoinColumn(name="candidate_id"))
	@OneToMany(fetch = FetchType.EAGER)	
	private Set<Candidate> candidates;

	@Column
	private boolean active;	

	@Column
	private Timestamp disabledAt;

	@Min(1)
	@Column(nullable = false)
	private int maxCandidates;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public SelectiveProcess(){}

	/**
	 * Initialize Fields for CDI Injection
	 */
	@PostConstruct
	private void init(){		
		this.addObserver(this);
		active = true;
		candidates = new HashSet<>();		
	}

	@Override
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	protected int getVersion() {
		return this.version;
	}

	protected void setVersion(final int version) {
		this.version = version;
	}	
	
	public Job getJob() {
		return this.job;
	}

	public void setJob(final Job job) {
		this.job = job;
	}

	public Set<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
		notifyChanges();
	}

	public boolean isActive() {
		return active;
	}

	protected void setActive(boolean active) {

		if(!active){
			disabledAt = Timestamp.from(Instant.now());
		}

		this.active = active;

		notifyChanges();
	}

	public int getMaxCandidates() {
		return maxCandidates;
	}

	public void setMaxCandidates(int maxCandidates) {
		this.maxCandidates = maxCandidates;
	}

	private boolean isElegible(){
		System.out.println("Process is Elegible " + (candidates.size() < maxCandidates));
		System.out.println("Candidates --> [" + candidates.size() + "/" + maxCandidates+ "]");
		return (candidates.size() < maxCandidates);
	}

	public boolean isInProcess(Candidate candidate){
		System.out.println(candidate.getName() + " are in this process ? " + (candidates.contains(candidate)) );
		return (candidates.contains(candidate));
	}

	private void countCandidates(Set<Candidate> collection){		
		maxCandidates = collection.size();	
	}

	public int countCandidates(){
		return maxCandidates - candidates.size();
	}

	public boolean registerCandidate(Candidate candidate){

		boolean b = false;

		if((isActive()) && (isElegible()) && (!isInProcess(candidate))){

			candidates.add(candidate);			

			System.out.println(candidate.getName() + " Registered with Success");

			b = true;

		}else{

			System.out.println(candidate.getName() + " Cannot Registered");

			b = false;
		}

		notifyChanges(candidates);

		return b;

	}

	private void notifyChanges(){		
		notifyObservers();
		setChanged();
	}

	private void notifyChanges(Object object){		
		notifyObservers(object);
		setChanged();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable observable, Object object) {	

		if(observable instanceof SelectiveProcess){			

			if(active = isElegible()){

				if(object instanceof Collection<?>){								

					countCandidates((Set<Candidate>) object);

				}

			}else{				
				if (disabledAt != null)
					System.out.println("Max candidates Reached - Disabled Process at " + disabledAt);
			}

		}
	}

	@PrePersist
	@Override
	public void prepareToPersist(){
		Traceable.super.prepareToPersist();	
	}	

	@Override
	public void generateUUID(){
		uuid = UUID.randomUUID().toString();
	}

	@Override
	public void insertTimeStamp(){
		createdAt = Timestamp.from(Instant.now());
	}

	@PreUpdate
	@Override
	public void updateTimeStamp(){
		updatedAt = Timestamp.from(Instant.now());
	}

}