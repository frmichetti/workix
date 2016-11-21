package br.com.codecode.workix.model;

import java.io.Serializable;
import java.util.Calendar;
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

import br.com.codecode.workix.model.interfaces.Traceable;


/**
 * Common Fields for Persistent Entity
 * @author felipe
 *
 */
@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("unused")
public abstract class Loggable implements Traceable, Serializable {

	private static final long serialVersionUID = -5791260209364116790L;

	@XmlTransient
	@Version	
	@Column
	private int version;

	@XmlTransient
	@Column(updatable=false,nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;

	@XmlTransient
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;
	
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
		createdAt = Calendar.getInstance();
	}

	@PreUpdate
	@Override
	public void updateTimeStamp(){
		updatedAt = Calendar.getInstance();
	}

	protected int getVersion() {
		return version;
	}


	protected void setVersion(final int version) {
		this.version = version;
	}

	protected Calendar getCreatedAt() {
		return createdAt;
	}

	private void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	protected Calendar getUpdatedAt() {
		return updatedAt;
	}

	private void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	protected String getUuid() {
		return uuid;
	}

	private void setUuid(String uuid) {
		this.uuid = uuid;
	}



}
