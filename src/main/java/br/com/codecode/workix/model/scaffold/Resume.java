package br.com.codecode.workix.model.scaffold;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Resume JPA {@link Entity}
 * @author felipe
 * @see MyEntity
 * @since 1.1
 * @version 1.1
 */
@Entity
abstract class Resume extends MyEntity {

	private static final long serialVersionUID = 7569771700044121495L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	/**
	 * Owner of Resume<br> 
	 * One {@link Resume} To One {@link Candidate}
	 */
	@NotNull	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private Candidate candidate;

	@NotEmpty	
	@Column
	private String objective;

	@Lob
	@Column
	private String content;	

	/**
	 * One {@link Resume} To Many {@link Experience} 
	 */
	@ElementCollection(fetch=FetchType.EAGER)	
	@CollectionTable(name = "Resume_Experiences", 
	joinColumns=@JoinColumn(name="id"))
	private Set<Experience> experiences;

	/**
	 * One {@link Resume} To Many {@link Education} 
	 */
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Resume_Educations", 
	joinColumns=@JoinColumn(name="id"))
	private Set<Education> educations;	

	/**
	 * One {@link Resume} To Many {@link Skill} 
	 */
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Resume_Skills", 
	joinColumns=@JoinColumn(name="id"))
	private Set<Skill> skills;

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
	 * @return the candidate
	 */
	public final Candidate getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate the candidate to set
	 */
	public final void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	/**
	 * @return the objective
	 */
	public final String getObjective() {
		return objective;
	}

	/**
	 * @param objective the objective to set
	 */
	public final void setObjective(String objective) {
		this.objective = objective;
	}

	/**
	 * @return the content
	 */
	public final String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public final void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the experiences
	 */
	public final Set<Experience> getExperiences() {
		return experiences;
	}

	/**
	 * @param experiences the experiences to set
	 */
	public final void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	/**
	 * @return the educations
	 */
	public final Set<Education> getEducations() {
		return educations;
	}

	/**
	 * @param educations the educations to set
	 */
	public final void setEducations(Set<Education> educations) {
		this.educations = educations;
	}

	/**
	 * @return the skills
	 */
	public final Set<Skill> getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public final void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}	
	
	
	
}