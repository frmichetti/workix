package br.com.codecode.workix.core.models.jdk7.actions;

import java.util.Calendar;

/**
 * Markup Interface for Education Implementation
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
public interface EducationActions {

    String getDescription();

    Calendar getEndDate();

    String getQualification();

    String getSchoolName();

    Calendar getStartDate();

    void setDescription(String description);

    void setEndDate(Calendar endDate);

    void setQualification(String qualification);

    void setSchoolName(String schoolName);

    void setStartDate(Calendar startDate);

}
