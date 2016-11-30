package br.com.codecode.workix.model.base;

import java.util.Set;

import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Education;
import br.com.codecode.workix.jpa.models.Experience;
import br.com.codecode.workix.jpa.models.Resume;
import br.com.codecode.workix.jpa.models.Skill;
import br.com.codecode.workix.model.actions.CandidateActions;
import br.com.codecode.workix.model.actions.EducationActions;
import br.com.codecode.workix.model.actions.ExperienceActions;
import br.com.codecode.workix.model.actions.SkillActions;

/**
 * Root Abstract Class Resume<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #candidate}</li>
 * <li>{@link #objective}</li>
 * <li>{@link #content}</li>
 * <li>{@link #experiences}</li>
 * <li>{@link #educations}</li>
 * <li>{@link #skills}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see BaseEntity
 */
public abstract class BaseResume {

    /**
     * Owner of Resume<br>
     * One {@link Resume} To One {@link Candidate}
     */
    private CandidateActions candidate;

    private String objective;

    private String content;

    /**
     * One {@link Resume} To Many {@link Experience}
     */
    protected Set<ExperienceActions> experiences;

    /**
     * One {@link Resume} To Many {@link Education}
     */
    protected Set<EducationActions> educations;

    /**
     * One {@link Resume} To Many {@link Skill}
     */
    protected Set<SkillActions> skills;

    /**
     * Default Empty Constructor
     */
    public BaseResume() {
    }

    /**
     * @return the candidate
     */
    public CandidateActions getCandidate() {
	return candidate;
    }

    /**
     * @param candidate
     *            the candidate to set
     */
    public void setCandidate(CandidateActions candidate) {
	this.candidate = candidate;
    }

    /**
     * @return the objective
     */
    public String getObjective() {
	return objective;
    }

    /**
     * @param objective
     *            the objective to set
     */
    public void setObjective(String objective) {
	this.objective = objective;
    }

    /**
     * @return the content
     */
    public String getContent() {
	return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public abstract void setContent(String content);

    /**
     * @return the experiences
     */
    public abstract Set<ExperienceActions> getExperiences();

    /**
     * @param experiences
     *            the experiences to set
     */
    public abstract void setExperiences(Set<ExperienceActions> experiences);

    /**
     * @return the educations
     */
    public abstract Set<EducationActions> getEducations();

    /**
     * @param educations
     *            the educations to set
     */
    public abstract void setEducations(Set<EducationActions> educations);

    /**
     * @return the skills
     */
    public abstract Set<SkillActions> getSkills();

    /**
     * @param skills
     *            the skills to set
     */
    public abstract void setSkills(Set<SkillActions> skills);

}
