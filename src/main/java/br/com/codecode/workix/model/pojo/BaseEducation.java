package br.com.codecode.workix.model.pojo;

import java.util.Calendar;

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
