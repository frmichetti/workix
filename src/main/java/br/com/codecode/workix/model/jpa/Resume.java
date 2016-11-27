package br.com.codecode.workix.model.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.base.BaseCandidate;
import br.com.codecode.workix.model.base.BaseEducation;
import br.com.codecode.workix.model.base.BaseExperience;
import br.com.codecode.workix.model.base.BaseResume;
import br.com.codecode.workix.model.base.BaseSkill;

/**
 * Resume JPA with Inherited Fields and Methods 
 * @author felipe 
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 * @see BaseResume
 */
public class Resume extends MyEntity implements BaseResume {

	private static final long serialVersionUID = 7569771700044121495L;
	
	/**
	 * Owner of Resume<br> 
	 * One {@link Resume} To One {@link Candidate}
	 */
	@NotNull	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private BaseCandidate candidate;

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
	private Set<BaseExperience> experiences;

	/**
	 * One {@link Resume} To Many {@link Education} 
	 */
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Resume_Educations", 
	joinColumns=@JoinColumn(name="id"))
	private Set<BaseEducation> educations;	

	/**
	 * One {@link Resume} To Many {@link Skill} 
	 */
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Resume_Skills", 
	joinColumns=@JoinColumn(name="id"))
	private Set<BaseSkill> skills;	

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Resume(){}

	/**
	 * Initialize Fields for CDI Injection
	 */
	@PostConstruct
	private void init() {
		educations = new HashSet<BaseEducation>();
		experiences = new HashSet<BaseExperience>();
		skills = new HashSet<BaseSkill>();		
	}

	@Override
	public BaseCandidate getCandidate() {
		return candidate;
	}

	@Override
	public void setCandidate(BaseCandidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String getObjective() {
		return objective;
	}

	@Override
	public void setObjective(String objective) {
		this.objective = objective;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public Set<BaseExperience> getExperiences() {
		return experiences;
	}

	@Override
	public void setExperiences(Set<BaseExperience> experiences) {
		this.experiences = experiences;
	}

	@Override
	public void addExperience(BaseExperience experience){
		if(experiences == null)
			experiences = new HashSet<>(); 
		else
			this.experiences.add(experience);
	}

	@Override
	public void removeExperience(BaseExperience experience){
		if(experiences == null)
			experiences = new HashSet<>(); 
		else
			this.experiences.remove(experience);
	}

	@Override
	public Set<BaseEducation> getEducations() {
		return educations;
	}

	@Override
	public void setEducations(Set<BaseEducation> educations) {
		if(educations == null)
			educations = new HashSet<>(); 
		else
			this.educations = educations;
	}

	@Override
	public void addEducation(BaseEducation education){
		if(educations == null)
			educations = new HashSet<>(); 
		else
			this.educations.add(education);
	}

	@Override
	public void removeEducation(BaseEducation education){
		this.educations.remove(education);
	}	

	@Override
	public Set<BaseSkill> getSkills() {
		return skills;
	}

	@Override
	public void setSkills(Set<BaseSkill> skills) {
		this.skills = skills;
	}

	@Override
	public void addSkill(BaseSkill skill){
		if(skills == null)
			skills = new HashSet<>(); 
		else
			this.skills.add(skill);

	}

	@Override
	public void removeSkill(BaseSkill skill){
		if(skills == null)
			skills = new HashSet<>(); 
		else
			this.skills.remove(skill);
	}	

}