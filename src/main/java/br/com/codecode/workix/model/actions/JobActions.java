package br.com.codecode.workix.model.actions;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.codecode.workix.jpa.enums.JobCategory;
import br.com.codecode.workix.jpa.enums.JobType;

/**
 * Markup Interface for Job Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface JobActions extends EntityActions {

    String getTitle();

    void setTitle(String title);

    BigDecimal getMinPayment();

    void setMinPayment(BigDecimal minPayment);

    BigDecimal getMaxPayment();

    void setMaxPayment(BigDecimal maxPayment);

    String getDescription();

    void setDescription(String resume);

    String getRequirement();

    void setRequirement(String requirement);

    String getBenefits();

    void setBenefits(String benefits);

    Calendar getStart();

    void setStart(Calendar start);

    Calendar getExpire();

    void setExpire(Calendar expire);

    JobType getType();

    void setType(JobType type);

    JobCategory getCategory();

    void setCategory(JobCategory category);

    boolean isActive();

    void setActive(boolean active);

    CompanyActions getEmployeer();

    void setEmployeer(CompanyActions employeer);

}
