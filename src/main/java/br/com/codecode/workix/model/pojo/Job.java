package br.com.codecode.workix.model.pojo;

import java.util.Calendar;

import br.com.codecode.workix.model.base.BaseJob;
import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;
import br.com.codecode.workix.model.jpa.Company;

/**
 * Draft Job Class
 * @author felipe
 * @category POJO
 *
 */
class Job extends MyEntity implements BaseJob{

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Number getMinPayment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMinPayment(Number minPayment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Number getMaxPayment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaxPayment(Number maxPayment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String resume) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getRequirement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRequirement(String requirement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBenefits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBenefits(String benefits) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Calendar getStart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStart(Calendar start) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Calendar getExpire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExpire(Calendar expire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JobType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(JobType type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JobCategory getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCategory(JobCategory category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setActive(boolean active) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company getEmployeer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEmployeer(Company employeer) {
		// TODO Auto-generated method stub
		
	}

}
