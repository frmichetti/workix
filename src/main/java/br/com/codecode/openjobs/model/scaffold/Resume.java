package br.com.codecode.openjobs.model.scaffold;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

@Entity
@XmlRootElement
public class Resume implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@XmlTransient
	@JsonIgnore
	@Version
	@Column(name = "version")
	private int version;
	
	@Expose
	@OneToOne(fetch=FetchType.EAGER)
	private Candidate owner;
	
	@Expose
	@Column
	private String objective;
	
	@Expose
	@Lob
	@Column
	private String content;	
	
	@Expose
	@Lob
	@Column
	/**
	 * OneToMany -> Json
	 */
	private String experiences;
	

	@Expose
	@Lob
	@Column
	/**
	 * OneToMany -> Json
	 */
	private String educations;	

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
	
	public Candidate getOwner() {
		return owner;
	}

	public void setOwner(Candidate owner) {
		this.owner = owner;
	}
	

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExperiences() {
		return experiences;
	}

	public void setExperiences(String experiences) {
		this.experiences = experiences;
	}

	public String getEducations() {
		return educations;
	}

	public void setEducations(String educations) {
		this.educations = educations;
	}
	
	
	
	



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Resume)) {
			return false;
		}
		Resume other = (Resume) obj;
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


}