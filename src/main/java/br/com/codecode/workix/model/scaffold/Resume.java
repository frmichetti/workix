package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;

@Entity
@Table(name="workix_Resumes")
@XmlRootElement
public class Resume extends Loggable implements BasicEntity {

	private static final long serialVersionUID = 7569771700044121495L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@NotNull
	@Expose
	@OneToOne(fetch=FetchType.EAGER,optional=false)
	private Candidate owner;
	
	@NotEmpty
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
	 * OneToMany //TODO -> Json
	 */
	private String experiences;
	

	@Expose
	@Lob
	@Column
	/**
	 * OneToMany //TODO -> Json
	 */
	private String educations;	

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
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