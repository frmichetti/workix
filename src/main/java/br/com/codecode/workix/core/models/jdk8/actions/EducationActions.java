package br.com.codecode.workix.core.models.jdk8.actions;

import java.time.LocalDate;

/**
 * Markup Interface for Education Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public interface EducationActions {

    String getDescription();

    LocalDate getEndDate();

    String getQualification();

    String getSchoolName();

    LocalDate getStartDate();

    void setDescription(String description);

    void setEndDate(LocalDate endDate);

    void setQualification(String qualification);

    void setSchoolName(String schoolName);

    void setStartDate(LocalDate startDate);

}
