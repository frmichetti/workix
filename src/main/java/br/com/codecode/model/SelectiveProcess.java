package br.com.codecode.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import br.com.codecode.model.Employeer;
import br.com.codecode.model.Candidate;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
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

	@Column(nullable = false, updatable = false)
	private Date start;

	@Column(nullable = false)
	private Date expire;

	@ManyToOne
	private Employeer employeer;

	@OneToMany
	private Set<Candidate> candidates = new HashSet<Candidate>();

	@Column
	private boolean active;

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

	public String getUuid() {
		return uuid;
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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public Employeer getEmployeer() {
		return this.employeer;
	}

	public void setEmployeer(final Employeer employeer) {
		this.employeer = employeer;
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

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (uuid != null && !uuid.trim().isEmpty())
			result += "uuid: " + uuid;
		result += ", active: " + active;
		return result;
	}
}