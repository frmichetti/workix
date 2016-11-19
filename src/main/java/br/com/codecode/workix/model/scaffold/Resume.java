package br.com.codecode.workix.model.scaffold;

import java.util.HashSet;
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.Loggable;
import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume extends Loggable implements BasicEntity {

	private static final long serialVersionUID = 7569771700044121495L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@Expose
	@NotNull	
	@OneToOne(fetch=FetchType.EAGER,optional=false)
	private Candidate candidate;
	
	@Expose
	@NotEmpty	
	@Column
	private String objective;
	
	@Expose
	@Lob
	@Column
	private String content;	
	
	/**
	 * OneToMany 
	 */
	@Expose	
	@ElementCollection(fetch=FetchType.EAGER)	
	@CollectionTable(name = "Resume_experiences",joinColumns=@JoinColumn(name="id"))
	private Set<Experience> experiences;
	
	/**
	 * OneToMany 
	 */
	@Expose	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Resume_educations",joinColumns=@JoinColumn(name="id"))
	private Set<Education> educations;	
	
	/**
	 * OneToMany 
	 */
	@Expose	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Resume_skills",joinColumns=@JoinColumn(name="id"))
	private Set<Skill> skills;	
	
	public Resume() {
		configure();
	}

	private void configure() {
		educations = new HashSet<>();
		experiences = new HashSet<>();
		skills = new HashSet<>();		
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}	
	
	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
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

	public Set<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}
	
	public void addExperience(Experience experience){
		this.experiences.add(experience);
	}
	
	public void removeExperience(Experience experience){
		this.experiences.remove(experience);
	}

	public Set<Education> getEducations() {
		return educations;
	}

	public void setEducations(Set<Education> educations) {
		this.educations = educations;
	}
	
	public void addEducation(Education education){
		this.educations.add(education);
	}
	
	public void removeEducation(Education education){
		this.educations.remove(education);
	}	

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	
	public void addSkill(Skill skill){
		this.skills.add(skill);
	}
	
	public void removeSkill(Skill skill){
		this.skills.remove(skill);
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