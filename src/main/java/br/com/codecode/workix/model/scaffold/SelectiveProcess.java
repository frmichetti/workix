package br.com.codecode.workix.model.scaffold;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Selective Process JPA {@link Entity}
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see MyEntity
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name="Selective_Process")
@Entity
abstract class SelectiveProcess extends MyEntity {

	private static final long serialVersionUID = -5336099006523168288L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;	

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
	 * @return the id
	 */
	public final long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the job
	 */
	public final Job getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public final void setJob(Job job) {
		this.job = job;
	}

	/**
	 * @return the candidates
	 */
	public final Set<Candidate> getCandidates() {
		return candidates;
	}

	/**
	 * @param candidates the candidates to set
	 */
	public final void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	/**
	 * @return the active
	 */
	public final boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public final void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the disabledAt
	 */
	public final Timestamp getDisabledAt() {
		return disabledAt;
	}

	/**
	 * @param disabledAt the disabledAt to set
	 */
	public final void setDisabledAt(Timestamp disabledAt) {
		this.disabledAt = disabledAt;
	}

	/**
	 * @return the maxCandidates
	 */
	public final int getMaxCandidates() {
		return maxCandidates;
	}

	/**
	 * @param maxCandidates the maxCandidates to set
	 */
	public final void setMaxCandidates(int maxCandidates) {
		this.maxCandidates = maxCandidates;
	}	
	
}