package br.com.codecode.workix.core.models.compat;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Resume Class for Compatibility
 * <br>Without Annotations.
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @since 1.1
 */
public class Resume extends MyEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** Owner of Resume<br> One {@link Resume} To One {@link Candidate}. */
    private Candidate candidate;

    /** One {@link Resume} To Many {@link Education}. */

    private Set<Education> educations;

    /** One {@link Resume} To Many {@link Experience}. */
    private Set<Experience> experiences;

    /** The id. */
    private long id;

    /** The content. */
    private String objective, content;

    /** One {@link Resume} To Many {@link Skill}. */
    private Set<Skill> skills;

    @Generated("SparkTools")
    private Resume(Builder builder) {
	this.candidate = builder.candidate;
	this.educations = builder.educations;
	this.experiences = builder.experiences;
	this.id = builder.id;
	this.objective = builder.objective;
	this.content = builder.content;
	this.skills = builder.skills;
    }

    /**
     * Public Default Constructor.
     */
    public Resume(){}

    /**
     * Adds the education.
     *
     * @param education the education
     */
    public void addEducation(Education education) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations.add(education);
    }

    /**
     * Adds the experience.
     *
     * @param experience the experience
     */
    public void addExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.add(experience);
    }

    /**
     * Adds the skill.
     *
     * @param skill the skill
     */
    public void addSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.add(skill);

    }

    /**
     * Gets the candidate.
     *
     * @return the candidate
     */
    public Candidate getCandidate() {
	return candidate;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    public String getContent() {
	return content;
    }

    /**
     * Gets the educations.
     *
     * @return the educations
     */
    public Set<Education> getEducations() {
	return educations;
    }

    /**
     * Gets the experiences.
     *
     * @return the experiences
     */
    public Set<Experience> getExperiences() {
	return experiences;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
	return this.id;
    }

    /**
     * Gets the objective.
     *
     * @return the objective
     */
    public String getObjective() {
	return objective;
    }

    /**
     * Gets the skills.
     *
     * @return the skills
     */
    public Set<Skill> getSkills() {
	return skills;
    }

    /**
     * Initialize Fields.
     */
    protected void init() {
	educations = new HashSet<Education>();
	experiences = new HashSet<Experience>();
	skills = new HashSet<Skill>();
    }

    /**
     * Removes the education.
     *
     * @param education the education
     */
    public void removeEducation(Education education) {
	this.educations.remove(education);
    }

    /**
     * Removes the experience.
     *
     * @param experience the experience
     */
    public void removeExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.remove(experience);
    }

    /**
     * Removes the skill.
     *
     * @param skill the skill
     */
    public void removeSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.remove(skill);
    }

    /**
     * Sets the candidate.
     *
     * @param candidate the new candidate
     */
    public void setCandidate(Candidate candidate) {
	this.candidate = candidate;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(String content) {
	this.content = content;
    }

    /**
     * Sets the educations.
     *
     * @param educations the new educations
     */
    public void setEducations(Set<Education> educations) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations = educations;
    }

    /**
     * Sets the experiences.
     *
     * @param experiences the new experiences
     */
    public void setExperiences(Set<Experience> experiences) {
	this.experiences = experiences;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
	this.id = id;
    }

    /**
     * Sets the objective.
     *
     * @param objective the new objective
     */
    public void setObjective(String objective) {
	this.objective = objective;
    }

    /**
     * Sets the skills.
     *
     * @param skills the new skills
     */
    public void setSkills(Set<Skill> skills) {
	this.skills = skills;
    }

    /**
     * Creates builder to build {@link Resume}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Resume}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private Candidate candidate;

	private Set<Education> educations;

	private Set<Experience> experiences;

	private long id;

	private String objective;

	private String content;

	private Set<Skill> skills;

	private Builder() {
	}

	public Builder withCandidate(Candidate candidate) {

	    this.candidate = candidate;
	    return this;
	}

	public Builder withEducations(Set<Education> educations) {

	    this.educations = educations;
	    return this;
	}

	public Builder withExperiences(Set<Experience> experiences) {

	    this.experiences = experiences;
	    return this;
	}

	public Builder withId(long id) {

	    this.id = id;
	    return this;
	}

	public Builder withObjective(String objective) {

	    this.objective = objective;
	    return this;
	}

	public Builder withContent(String content) {

	    this.content = content;
	    return this;
	}

	public Builder withSkills(Set<Skill> skills) {

	    this.skills = skills;
	    return this;
	}

	public Resume build() {

	    return new Resume(this);
	}
    }

}