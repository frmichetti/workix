package br.com.codecode.workix.model.base;

import java.util.Calendar;

/**
 * Markup Interface for Education Implementation
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface BaseEducation {

	String getSchoolName();

	void setSchoolName(String schoolName);

	Calendar getStartDate();

	void setStartDate(Calendar startDate);

	Calendar getEndDate();

	void setEndDate(Calendar endDate);

	String getQualification();

	void setQualification(String qualification);

	String getDescription();

	void setDescription(String description);

}
