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

    void addEducation(EducationActions education);

    void addExperience(ExperienceActions experience);

    void addSkill(SkillActions skill);

    CandidateActions getCandidate();

    String getContent();

    Set<EducationActions> getEducations();

    Set<ExperienceActions> getExperiences();

    String getObjective();

    Set<SkillActions> getSkills();

    void removeEducation(EducationActions education);

    void removeExperience(ExperienceActions experience);

    void removeSkill(SkillActions skill);

    void setCandidate(CandidateActions candidate);

    void setContent(String content);

    void setEducations(Set<EducationActions> educations);

    void setExperiences(Set<ExperienceActions> experiences);

    void setObjective(String objective);

    void setSkills(Set<SkillActions> skills);

}
