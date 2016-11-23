package br.com.codecode.workix.model.base;

import java.util.Collection;

/**
 * Markup Interface for Resume Implementation
 * @author felipe
 *
 */
public interface BaseResume extends BaseEntity {

	BaseCandidate getCandidate();

	void setCandidate(BaseCandidate candidate);

	String getObjective();

	void setObjective(String objective);

	String getContent();

	void setContent(String content);

	Collection<BaseExperience> getExperiences();

	void setExperiences(Collection<BaseExperience> experiences);

	void addExperience(BaseExperience experience);

	void removeExperience(BaseExperience experience);

	Collection<BaseEducation> getEducations();

	void setEducations(Collection<BaseEducation> educations);

	void addEducation(BaseEducation education);

	void removeEducation(BaseEducation education);

	Collection<BaseSkill> getSkills();

	void setSkills(Collection<BaseSkill> skills);

	void addSkill(BaseSkill skill);

	void removeSkill(BaseSkill skill);

}
