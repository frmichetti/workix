package br.com.codecode.workix.model.base;

import java.util.Set;

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
