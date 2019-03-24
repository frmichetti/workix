package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

import java.util.HashSet;
import java.util.Set;

/**
 * Resume JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 */
public class Resume extends MyEntity {
   
    private static final long serialVersionUID = 7569771700044121495L;

    /**
     * Owner of Resume<br>
     * One {@link Resume} To One {@link Candidate}
     */
    private Candidate candidate;

    /**
     * One {@link Resume} To Many {@link Education}
     */
    private Set<Education> educations;

    /**
     * One {@link Resume} To Many {@link Experience}
     */
    private Set<Experience> experiences;

    private long id;

    private String objective, content;

    /**
     * One {@link Resume} To Many {@link Skill}
     */    
    private Set<Skill> skills;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Resume() {}

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Resume
     */
    private Resume(Builder builder) {	
	this.candidate = builder.getCandidate();
	this.objective = builder.getObjective();
	this.content = builder.getContent();
	this.experiences = builder.getExperiences();
	this.educations = builder.getEducations();
	this.skills = builder.getSkills();
    }

    /**
     * Creates builder to build {@link Resume}.
     * @return created builder
     */
    public static Builder builder() {
	return new Builder();
    }

    public void addEducation(Education education) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations.add(education);
    }

    public void addExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.add(experience);
    }

    public void addSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.add(skill);

    }

    public Candidate getCandidate() {
	return candidate;
    }

    public String getContent() {
	return content;
    }

    public Set<Education> getEducations() {
	return educations;
    }

    public Set<Experience> getExperiences() {
	return experiences;
    }

    @Override
    public long getId() {
	return this.id;
    }

    public String getObjective() {
	return objective;
    }

    public Set<Skill> getSkills() {
	return skills;
    }

    public void removeEducation(Education education) {
	this.educations.remove(education);
    }

    public void removeExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.remove(experience);
    }

    public void removeSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.remove(skill);
    }

    public void setCandidate(Candidate candidate) {
	this.candidate = candidate;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public void setEducations(Set<Education> educations) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations = educations;
    }

    public void setExperiences(Set<Experience> experiences) {
	this.experiences = experiences;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

    public void setObjective(String objective) {
	this.objective = objective;
    }

    public void setSkills(Set<Skill> skills) {
	this.skills = skills;
    }

    /**
     * Builder to build {@link Resume}.
     */    
    public static final class Builder extends Resume implements Buildable<Resume>{

	private static final long serialVersionUID = -5218494421810694002L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * @return a new Resume
	 */
	@Override
	public Resume build() {
	    return new Resume(this);
	}

	public Builder withCandidate(Candidate candidate) {
	    super.candidate = candidate;
	    return this;
	}

	public Builder withContent(String content) {
	    super.content = content;
	    return this;
	}

	public Builder withEducations(Set<Education> educations) {
	    super.educations = educations;
	    return this;
	}

	public Builder withExperiences(Set<Experience> experiences) {
	    super.experiences = experiences;
	    return this;
	}	

	public Builder withObjective(String objective) {
	    super.objective = objective;
	    return this;
	}

	public Builder withSkills(Set<Skill> skills) {
	    super.skills = skills;
	    return this;
	}
    }

}