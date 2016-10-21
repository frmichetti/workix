package br.com.codecode.openjobs.model.scaffold;

import java.io.Serializable;
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
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.codecode.openjobs.model.BasicEntity;
import br.com.codecode.openjobs.model.enumeration.Estate;
import br.com.codecode.openjobs.model.enumeration.JobCategory;
import br.com.codecode.openjobs.model.enumeration.JobType;

@Entity
@XmlRootElement
public class Job implements Serializable, BasicEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)	
	private Long id;
	
	@JsonIgnore
	@Version
	@Column(name = "version")
	private int version;
	
	@Column(nullable = false)
	private String uuid;

	@Column(nullable = false)
	private String title;

	@Column
	private BigDecimal minPayment;
	
	@Column
	private BigDecimal maxPayment;

	@Lob
	@Column(nullable = false)
	private String description;
	
	@Lob
	@Column	
	private String requirement;
	
	@Column(nullable = false, updatable = false)
	private Date start;

	@Column(nullable = false)
	private Date expire;
	
	@Column
	@Enumerated(EnumType.STRING)
	private JobType jobType;

	@Column
	@Enumerated(EnumType.STRING)
	private JobCategory jobCategory;	
	
	@Column
	private String city;
	
	@Enumerated(EnumType.STRING)
	private Estate estate;	

	@Column
	private boolean active;
	
	@ManyToOne
	private Company employeer;
	
	public Job() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public JobCategory getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Estate getEstate() {
		return estate;
	}

	public void setEstate(Estate estate) {
		this.estate = estate;
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
	
	
	
	
	
	
	
	
	
	

	
}