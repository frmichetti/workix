package br.com.codecode.workix.model.base;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;

/**
 * Markup Interface for Job Implementation
 * @author felipe
 *
 */
public interface BaseJob extends BaseEntity{

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

	BaseCompany getEmployeer();

	void setEmployeer(BaseCompany employeer);

}
