package br.com.codecode.workix.jpa.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;

/**
 * MyEntity JPA with Inherited Fields and Methods <br>
 * Base abstract Class for Share common Fields <br>
 * All inherited classes MUST contain<br>
 * <table>
 * <caption> Inherited Fields </caption>
 * <tr>
 * <th>{@link #id}</th>
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
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
abstract class MyEntity implements Traceable, Persistable, Serializable {

    private final static long serialVersionUID = -5791260209364116790L;

    @JsonIgnore
    @XmlTransient
    @Version
    @Column
    private int version;

    @JsonIgnore
    @XmlTransient
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @XmlTransient
    @Column
    private LocalDateTime updatedAt;

    @JsonIgnore
    @XmlTransient
    @Column(updatable = false, nullable = false)
    private String uuid;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public MyEntity() {
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

    protected int getVersion() {
	return version;
    }

    protected void setVersion(int version) {
	this.version = version;
    }

    @Override
    public void generateUUID() {
	this.setUuid(UUID.randomUUID().toString());
    }

    public LocalDateTime getCreatedAt() {
	return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
	return updatedAt;
    }

    public String getUuid() {
	return uuid;
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

    @PreUpdate
    @Override
    public void updateTimeStamp() {
	this.setUpdatedAt(LocalDateTime.now());
    }

}
