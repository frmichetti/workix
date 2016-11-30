package br.com.codecode.workix.model.actions;

import java.util.Calendar;

/**
 * Markup Interface for Experience Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface ExperienceActions {

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
