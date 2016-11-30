package br.com.codecode.workix.model.actions;

import java.math.BigDecimal;

import br.com.codecode.workix.jpa.enums.JobCategory;
import br.com.codecode.workix.jpa.enums.JobType;

/**
 * Markup Interface for Job Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public interface JobActions extends EntityActions {

    String getBenefits();

    JobCategory getCategory();

    String getDescription();

    CompanyActions getEmployeer();

    BigDecimal getMaxPayment();

    BigDecimal getMinPayment();

    String getRequirement();

    String getTitle();

    JobType getType();

    boolean isActive();

    void setActive(boolean active);

    void setBenefits(String benefits);    

    void setCategory(JobCategory category);

    void setDescription(String resume);

    void setEmployeer(CompanyActions employeer);

    void setMaxPayment(BigDecimal maxPayment);

    void setMinPayment(BigDecimal minPayment);

    void setRequirement(String requirement);

    void setTitle(String title);

    void setType(JobType type);

}
