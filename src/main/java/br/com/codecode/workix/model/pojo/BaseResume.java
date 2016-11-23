package br.com.codecode.workix.model.pojo;

import java.util.Collection;

public interface BaseResume extends BaseEntity {

	BaseCandidate getCandidate();

	void setCandidate(BaseCandidate candidate);

	String getObjective();

	void setObjective(String objective);

	String getContent();

	void setContent(String content);

	Collection<? extends BaseExperience> getExperiences();

	void setExperiences(Collection<? extends BaseExperience> experiences);

	void addExperience(BaseExperience experience);

	void removeExperience(BaseExperience experience);

	Collection<?> getEducations();

	void setEducations(Collection<?> educations);

	void addEducation(BaseEducation education);

	void removeEducation(BaseEducation education);

	Collection<?> getSkills();

	void setSkills(Collection<?> skills);

	void addSkill(BaseSkill skill);

	void removeSkill(BaseSkill skill);

}
