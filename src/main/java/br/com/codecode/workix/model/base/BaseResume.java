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
 * @version 1.1
 * @see BaseEntity
 */
public abstract class BaseResume {

    /**
     * Owner of Resume<br>
     * One {@link Resume} To One {@link Candidate}
     */
    protected CandidateActions candidate;

    protected String objective;

    protected String content;

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

}
