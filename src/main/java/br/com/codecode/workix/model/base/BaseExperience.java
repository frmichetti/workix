package br.com.codecode.workix.model.base;

import java.util.Calendar;

public interface BaseExperience {

	String getEmployerName();

	void setEmployerName(String employerName);

	String getJobTitle();

	void setJobTitle(String jobTitle);

	Calendar getStartDate();

	void setStartDate(Calendar startDate);

	Calendar getEndDate();

	void setEndDate(Calendar endDate);

	String getDescription();

	void setDescription(String description);
}
