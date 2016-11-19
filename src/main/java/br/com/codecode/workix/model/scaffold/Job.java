package br.com.codecode.workix.model.scaffold;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.Loggable;
import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;
import br.com.codecode.workix.model.interfaces.BasicEntity;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Job extends Loggable implements BasicEntity {

	private static final long serialVersionUID = 2246753300384053586L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)	
	private Long id;

	@NotEmpty
	@Expose
	@Column(nullable = false)
	private String title;

	@DecimalMin("10")
	@Expose
	@Column
	private BigDecimal minPayment;
	
	@DecimalMin("10")
	@Expose
	@Column
	private BigDecimal maxPayment;

	@NotEmpty
	@Expose
	@Lob
	@Column(nullable = false)
	private String description;
	
	@NotEmpty
	@Expose
	@Lob
	@Column(nullable = false)	
	private String requirement;
	
	@NotEmpty
	@Expose
	@Lob
	@Column(nullable = false)	
	private String benefits;
	
	@NotNull	
	@Expose
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date start;

	@NotNull
	@Future
	@Expose
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date expire;
	
	@Expose
	@Column
	@Enumerated(EnumType.STRING)
	private JobType type;

	@Expose
	@Column
	@Enumerated(EnumType.STRING)
	private JobCategory category;	

	@Expose
	@Column
	private boolean active;
	
	@NotNull
	@Expose
	@ManyToOne(optional=false)
	private Company employeer;
	
	public Job(){
		configure();
	}
	
	private void configure(){
		minPayment = BigDecimal.TEN;
		maxPayment = BigDecimal.TEN; 
		active = true;
		start = new Date();		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getMinPayment() {
		return minPayment;
	}

	public void setMinPayment(BigDecimal minPayment) {
		this.minPayment = minPayment;
	}

	public BigDecimal getMaxPayment() {
		return maxPayment;
	}

	public void setMaxPayment(BigDecimal maxPayment) {
		this.maxPayment = maxPayment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String resume) {
		this.description = resume;
	}
	
	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}	

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}

	public JobCategory getCategory() {
		return category;
	}

	public void setCategory(JobCategory category) {
		this.category = category;
	}	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Company getEmployeer() {
		return employeer;
	}

	public void setEmployeer(Company employeer) {
		this.employeer = employeer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public String uniqueId(){
		return super.getUuid();
	}
	
}