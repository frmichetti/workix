package br.com.codecode.workix.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.codecode.workix.model.interfaces.Traceable;


/**
 * Common Fields for Persistent Entity
 * @author felipe
 *
 */
@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Loggable implements Traceable, Serializable {

	private static final long serialVersionUID = -5791260209364116790L;

	@XmlTransient
	@JsonIgnore
	@Version	
	@Column
	private int version;

	@Temporal(TemporalType.TIMESTAMP)
	@XmlTransient
	@JsonIgnore
	@Column(updatable=false,nullable=false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@XmlTransient
	@JsonIgnore
	@Column
	private Date updatedAt;
	
	@XmlTransient
	@JsonIgnore
	@Column(updatable=false,nullable=false)
	private String uuid;
	
	public Loggable(){}
	
	@PrePersist
	@Override
	public void prepareToPersist(){
		Traceable.super.prepareToPersist();	
	}

	@Override
	public void generateUUID(){
		uuid = UUID.randomUUID().toString();
	}

	@Override
	public void insertTimeStamp(){
		createdAt = new Date();
	}

	@PreUpdate
	@Override
	public void updateTimeStamp(){
		updatedAt = new Date();
	}
	
	protected int getVersion() {
		return version;
	}
	
	
	protected void setVersion(final int version) {
		this.version = version;
	}

	protected Date getCreatedAt() {
		return createdAt;
	}

	private void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	protected Date getUpdatedAt() {
		return updatedAt;
	}

	private void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	protected String getUuid() {
		return uuid;
	}

	private void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
