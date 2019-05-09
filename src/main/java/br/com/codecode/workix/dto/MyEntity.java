package br.com.codecode.workix.dto;

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


abstract class MyEntity implements Traceable, Persistable, Serializable {
   
    private final static long serialVersionUID = -5791260209364116790L;
    
    private int version;    
    
    private Date createdAt, updatedAt;
  
    private String uuid;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public MyEntity(){}

    @Override
    public void generateUUID() {
	this.setUuid(UUID.randomUUID().toString());
    }

    private Date getCreatedAt() {
	return createdAt;
    }

    private Date getUpdatedAt() {
	return updatedAt;
    }

    public String getUuid() {
	return uuid;
    }

    private int getVersion() {
	return version;
    }

    @Override
    public void insertTimeStamp() {
	this.setCreatedAt(new Date());
    }

    @Override
    public void prepareToPersist() {
	Traceable.super.prepareToPersist();
    }

    private void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }

    private void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
    }

    private void setUuid(String uuid) {
	this.uuid = uuid;
    }

    private void setVersion(int version) {
	this.version = version;
    }

    @Override
    public void updateTimeStamp() {
	this.setUpdatedAt(new Date());
    }

}
