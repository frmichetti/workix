package br.com.codecode.workix.model.actions;

import java.time.LocalDate;

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

    LocalDate getEndDate();

    String getJobTitle();

    LocalDate getStartDate();

    void setDescription(String description);

    void setEmployerName(String employerName);

    void setEndDate(LocalDate endDate);

    void setJobTitle(String jobTitle);

    void setStartDate(LocalDate startDate);
}
