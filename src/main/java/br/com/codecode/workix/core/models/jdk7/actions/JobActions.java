package br.com.codecode.workix.core.models.jdk7.actions;

import java.math.BigDecimal;

import br.com.codecode.workix.core.models.enums.JobCategory;
import br.com.codecode.workix.core.models.enums.JobType;
import br.com.codecode.workix.core.models.jdk7.root.BaseCompany;

/**
 * Markup Interface for Job Implementation
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see EntityActions
 */
public interface JobActions extends EntityActions {

    String getBenefits();

    JobCategory getCategory();

    String getDescription();

    BaseCompany getCompany();

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

    void setCompany(BaseCompany company);

    void setMaxPayment(BigDecimal maxPayment);

    void setMinPayment(BigDecimal minPayment);

    void setRequirement(String requirement);

    void setTitle(String title);

    void setType(JobType type);

}
