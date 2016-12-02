package br.com.codecode.workix.core.models.jdk7.actions;

import java.util.Calendar;

/**
 * Markup Interface for Experience Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public interface ExperienceActions {

    String getDescription();

    String getEmployerName();

    Calendar getEndDate();

    String getJobTitle();

    Calendar getStartDate();

    void setDescription(String description);

    void setEmployerName(String employerName);

    void setEndDate(Calendar endDate);

    void setJobTitle(String jobTitle);

    void setStartDate(Calendar startDate);
}
