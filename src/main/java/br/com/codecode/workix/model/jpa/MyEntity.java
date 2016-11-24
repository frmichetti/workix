package br.com.codecode.workix.model.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.model.interfaces.Persistable;
import br.com.codecode.workix.model.interfaces.Traceable;

/**
 * MyEntity JPA {@link MappedSuperclass} 
 * <br>Base abstract Class for Share common Fields
 * <br>All inherited classes MUST contain<br>
 * <table> 	
 * <caption> Inherited Fields </caption>
 * <tr>
 *   <th>{@link #id}</th>
 *   <th>{@link #version}</th>
 *   <th>{@link #createdAt}</th>
 *   <th>{@link #updatedAt}</th>
 *   <th>{@link #uuid}</th>
 * </tr>
 * </table>
 * @author felipe
 */
@MappedSuperclass
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("unused")
public abstract class MyEntity implements Traceable, Persistable, Serializable {

	private static final long serialVersionUID = -5791260209364116790L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@XmlTransient
	@Version	
	@Column
	private int version;

	@XmlTransient
	@Column(updatable = false, nullable = false)	
	private Timestamp createdAt;

	@XmlTransient
	@Column
	private Timestamp updatedAt;

	@XmlTransient	
	@Column(updatable = false, nullable = false)
	private String uuid;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */	
	public MyEntity(){}
	
	@Override
	public long getId() {
		return this.id;
	}
	
	@Override	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	@PrePersist
	public void prepareToPersist(){
		Traceable.super.prepareToPersist();	
	}
	
	@Override
	public void generateUUID(){
		this.setUuid(UUID.randomUUID().toString());
	}
	
	@Override
	public void insertTimeStamp(){
		this.setCreatedAt(Timestamp.from(Instant.now()));
	}
	
	@Override
	@PreUpdate
	public void updateTimeStamp(){
		this.setUpdatedAt(Timestamp.from(Instant.now()));
	}
	
	protected int getVersion() {
		return version;
	}
	
	private void setVersion(int version) {
		this.version = version;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	private void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	private void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	private void setUuid(String uuid) {
		this.uuid = uuid;
	}


}
