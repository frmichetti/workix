package br.com.codecode.workix.jpa.models.jdk8;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;

/**
 * MyEntity JPA with Inherited Fields and Methods <br>
 * Base abstract Class for Share common Fields <br>
 * All inherited classes MUST contain<br>
 * <table>
 * <caption> Inherited Fields </caption>
 * <tr> 
 * <th>{@link #version}</th>
 * <th>{@link #createdAt}</th>
 * <th>{@link #updatedAt}</th>
 * <th>{@link #uuid}</th>
 * </tr>
 * </table>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Traceable
 * @see Persistable
 * @see Serializable
 */
@MappedSuperclass
abstract class MyEntity implements Traceable, Persistable, Serializable {
   
    private final static long serialVersionUID = -5791260209364116790L;
    
    private int version;    
    
    private LocalDateTime createdAt, updatedAt;
  
    private String uuid;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public MyEntity(){}

    @Override
    public void generateUUID() {
	this.setUuid(UUID.randomUUID().toString());
    }

    @Column(updatable = false, nullable = false)    
    private LocalDateTime getCreatedAt() {
	return createdAt;
    }

    @Column
    private LocalDateTime getUpdatedAt() {
	return updatedAt;
    }

    @Column(updatable = false, nullable = false)
    public String getUuid() {
	return uuid;
    }

    @Version
    @Column
    private int getVersion() {
	return version;
    }

    @Override
    public void insertTimeStamp() {
	this.setCreatedAt(LocalDateTime.now());
    }

    @PrePersist
    @Override
    public void prepareToPersist() {
	Traceable.super.prepareToPersist();
    }

    private void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
    }

    private void setUpdatedAt(LocalDateTime updatedAt) {
	this.updatedAt = updatedAt;
    }

    private void setUuid(String uuid) {
	this.uuid = uuid;
    }

    @SuppressWarnings("unused")
    private void setVersion(int version) {
	this.version = version;
    }

    @PreUpdate
    @Override
    public void updateTimeStamp() {
	this.setUpdatedAt(LocalDateTime.now());
    }

}
