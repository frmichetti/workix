package br.com.codecode.workix.model.base;

import java.util.Calendar;

import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;
import br.com.codecode.workix.model.jpa.Company;

/**
 * Markup Interface for Job Implementation
 * @author felipe
 *
 */
public interface BaseJob extends BaseEntity{

	String getTitle();

	void setTitle(String title);

	Number getMinPayment();

	void setMinPayment(Number minPayment);

	Number getMaxPayment();

	void setMaxPayment(Number maxPayment);

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

	Company getEmployeer();

	void setEmployeer(Company employeer);

}
