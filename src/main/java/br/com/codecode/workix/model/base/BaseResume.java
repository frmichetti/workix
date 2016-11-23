package br.com.codecode.workix.model.base;

import java.util.Set;

public interface BaseResume extends BaseEntity {

	BaseCandidate getCandidate();

	void setCandidate(BaseCandidate candidate);

	String getObjective();

	void setObjective(String objective);

	String getContent();

	void setContent(String content);

	Set<BaseExperience> getExperiences();

	void setExperiences(Set<BaseExperience> experiences);

	void addExperience(BaseExperience experience);

	void removeExperience(BaseExperience experience);

	Set<BaseEducation> getEducations();

	void setEducations(Set<BaseEducation> educations);

	void addEducation(BaseEducation education);

	void removeEducation(BaseEducation education);

	Set<BaseSkill> getSkills();

	void setSkills(Set<BaseSkill> skills);

	void addSkill(BaseSkill skill);

	void removeSkill(BaseSkill skill);

}
