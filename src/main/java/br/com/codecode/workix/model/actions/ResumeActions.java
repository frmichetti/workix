package br.com.codecode.workix.model.actions;

import java.util.Set;

/**
 * Markup Interface for Resume Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface ResumeActions extends EntityActions {

    CandidateActions getCandidate();

    void setCandidate(CandidateActions candidate);

    String getObjective();

    void setObjective(String objective);

    String getContent();

    void setContent(String content);

    Set<ExperienceActions> getExperiences();

    void setExperiences(Set<ExperienceActions> experiences);

    void addExperience(ExperienceActions experience);

    void removeExperience(ExperienceActions experience);

    Set<EducationActions> getEducations();

    void setEducations(Set<EducationActions> educations);

    void addEducation(EducationActions education);

    void removeEducation(EducationActions education);

    Set<SkillActions> getSkills();

    void setSkills(Set<SkillActions> skills);

    void addSkill(SkillActions skill);

    void removeSkill(SkillActions skill);

}
