package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;


@Entity
@Table(name="openjobs_SelectiveProcesses")
@XmlRootElement
public class SelectiveProcess extends Observable implements Observer, BasicEntity, Serializable{

	private static final long serialVersionUID = -5336099006523168288L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@JsonIgnore
	@Version
	@Column
	private int version;
	
	@Expose
	@Column(nullable = false)
	private String uuid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date updatedAt;

	@Expose
	@NotEmpty
	@ManyToOne(optional=false)
	private Job job;	

	@Expose
	@Min(1)
	@OneToMany
	private Set<Candidate> candidates;

	@Expose
	@Column
	private boolean active;	

	@JsonIgnore
	private Instant disabledAt;

	@Expose
	@Min(1)
	@Column(nullable = false)
	private int maxCandidates;

	public SelectiveProcess() {
		configure();		
	}
	
	private void configure(){		
		this.addObserver(this);
		active = true;
		candidates = new HashSet<>();		
	}

	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}

	
	private int getVersion() {
		return this.version;
	}
	
	
	private void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SelectiveProcess)) {
			return false;
		}
		SelectiveProcess other = (SelectiveProcess) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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

	public void setCandidates(final Set<Candidate> candidates) {
		this.candidates = candidates;
		notifyChanges();
	}

	public boolean isActive() {
		return active;
	}

	private void setActive(boolean active) {

		if(!active){
			disabledAt = Instant.now();
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

	@JsonIgnore
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

	@Override
	public String toString() {
		return "SelectiveProcess [active=" + active + ", maxCandidates=" + maxCandidates + "]";
	}

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
	private void prepareToPersist(){
		insertTimeStamp();
		generateUUID();		
	}	
	
	private void insertTimeStamp() {
		createdAt = new Date();
		
	}

	@PreUpdate
	private void updateTimeStamp() {
		updatedAt = new Date();
		
	}
	
	private void generateUUID() {
		uuid = UUID.randomUUID().toString();		
	}


}