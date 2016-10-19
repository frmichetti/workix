package br.com.codecode.model.scaffold;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class SelectiveProcess implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private String uuid;

	@ManyToOne
	private Job job;	

	@OneToMany
	private Set<Candidate> candidates = new HashSet<Candidate>();

	@Column
	private boolean active;
	
	@Lob
	@Column	
	private String requirement;

	@Column(nullable = false)
	private int maxCandidates;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
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

	

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public int getMaxCandidates() {
		return maxCandidates;
	}

	public void setMaxCandidates(int maxCandidates) {
		this.maxCandidates = maxCandidates;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (uuid != null && !uuid.trim().isEmpty())
			result += "uuid: " + uuid;
		result += ", active: " + active;
		if (requirement != null && !requirement.trim().isEmpty())
			result += ", requirement: " + requirement;
		result += ", maxCandidates: " + maxCandidates;
		return result;
	}
}