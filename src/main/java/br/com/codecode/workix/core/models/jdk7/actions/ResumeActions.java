package br.com.codecode.workix.core.models.jdk7.actions;

import java.util.Set;

import br.com.codecode.workix.core.models.jdk7.root.BaseCandidate;
import br.com.codecode.workix.core.models.jdk7.root.BaseEducation;
import br.com.codecode.workix.core.models.jdk7.root.BaseExperience;
import br.com.codecode.workix.core.models.jdk7.root.BaseSkill;

/**
 * Markup Interface for Resume Implementation
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see EntityActions
 */
public interface ResumeActions extends EntityActions {

    void addEducation(BaseEducation education);

    void addExperience(BaseExperience experience);

    void addSkill(BaseSkill skill);

    BaseCandidate getCandidate();

    String getContent();

    Set<BaseEducation> getEducations();

    Set<BaseExperience> getExperiences();

    String getObjective();

    Set<BaseSkill> getSkills();

    void removeEducation(BaseEducation education);

    void removeExperience(BaseExperience experience);

    void removeSkill(BaseSkill skill);

    void setCandidate(BaseCandidate candidate);

    void setContent(String content);

    void setEducations(Set<BaseEducation> educations);

    void setExperiences(Set<BaseExperience> experiences);

    void setObjective(String objective);

    void setSkills(Set<BaseSkill> skills);

}
