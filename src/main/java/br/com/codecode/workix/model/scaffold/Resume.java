package br.com.codecode.workix.model.scaffold;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.interfaces.Persistable;

@Entity
public class Resume extends MyEntity implements Persistable {

	private static final long serialVersionUID = 7569771700044121495L;

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
	 * OneToMany 
	 */
	@ElementCollection(fetch=FetchType.EAGER)	
	@CollectionTable(name = "Resume_Experiences", 
	joinColumns=@JoinColumn(name="id"))
	private Set<Experience> experiences;

	/**
	 * OneToMany 
	 */
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Resume_Educations", 
	joinColumns=@JoinColumn(name="id"))
	private Set<Education> educations;	

	/**
	 * OneToMany 
	 */
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Resume_Skills", 
	joinColumns=@JoinColumn(name="id"))
	private Set<Skill> skills;	

	public Resume() {
		configure();
	}

	private void configure() {
		educations = new HashSet<Education>();
		experiences = new HashSet<Experience>();
		skills = new HashSet<Skill>();		
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (getId() ^ (getId() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resume other = (Resume) obj;
		if (getId() != other.getId())
			return false;
		return true;
	}

}