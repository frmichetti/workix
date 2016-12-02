package br.com.codecode.workix.core.models.jdk7.root;

import java.util.Set;

import br.com.codecode.workix.core.models.jdk7.actions.ResumeActions;

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
 * @since 1.1
 * @version 1.0
 * @see BaseEntity
 * @see ResumeActions
 */
public abstract class BaseResume extends BaseEntity implements ResumeActions {

    /**
     * Owner of Resume Field<br>
     * One Resume To One Candidate
     */
    protected BaseCandidate candidate;

    /**
     * Objective Field
     */
    protected String objective;

    /**
     * Content Field
     */
    protected String content;

    /**
     * Experience Field<br>
     * One Resume To Many Experience
     */
    protected Set<BaseExperience> experiences;

    /**
     * Educations Field<br>
     * One Resume To Many Education
     */
    protected Set<BaseEducation> educations;

    /**
     * Skills Field<br>
     * One Resume To Many Skill
     */
    protected Set<BaseSkill> skills;    

}
