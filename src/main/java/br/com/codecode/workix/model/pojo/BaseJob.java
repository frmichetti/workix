package br.com.codecode.workix.model.pojo;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;
import br.com.codecode.workix.model.scaffold.Company;

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

	Company getEmployeer();

	void setEmployeer(Company employeer);

}
