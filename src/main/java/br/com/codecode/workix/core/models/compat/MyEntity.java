package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.MappedSuperclass;

/**
 * MyEntity JPA with Inherited Fields and Methods <br>
 * <br>Without Annotations
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
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
@MappedSuperclass
abstract class MyEntity implements Serializable {

    private final static long serialVersionUID = -5791260209364116790L;
    
    private int version;    
    
    private LocalDateTime createdAt, updatedAt;
  
    private String uuid;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public MyEntity(){}

    public void generateUUID() {
	this.setUuid(UUID.randomUUID().toString());
    }

    private LocalDateTime getCreatedAt() {
	return createdAt;
    }

    private LocalDateTime getUpdatedAt() {
	return updatedAt;
    }

    public String getUuid() {
	return uuid;
    }

    private int getVersion() {
	return version;
    }

    public void insertTimeStamp() {
	this.setCreatedAt(LocalDateTime.now());
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

    private void setVersion(int version) {
	this.version = version;
    }

    public void updateTimeStamp() {
	this.setUpdatedAt(LocalDateTime.now());
    }

}
