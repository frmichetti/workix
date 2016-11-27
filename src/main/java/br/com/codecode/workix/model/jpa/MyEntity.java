package br.com.codecode.workix.model.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;
import br.com.codecode.workix.model.base.BaseEntity;

/**
 * MyEntity JPA with Inherited Fields and Methods 
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
 * @since 1.0
 * @version 1.1
 * @see BaseEntity
 * @see Traceable
 * @see Persistable
 * @see Serializable
 */
abstract class MyEntity implements BaseEntity, Traceable, Persistable, Serializable {

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
	public final long getId() {
		return this.id;
	}
	
	@Override	
	public final void setId(long id) {
		this.id = id;
	}
	
	@Override
	@PrePersist
	public final void prepareToPersist(){
		Traceable.super.prepareToPersist();	
	}
	
	@Override
	public final void generateUUID(){
		this.setUuid(UUID.randomUUID().toString());
	}
	
	@Override
	public final void insertTimeStamp(){
		this.setCreatedAt(Timestamp.from(Instant.now()));
	}
	
	@Override
	@PreUpdate
	public final void updateTimeStamp(){
		this.setUpdatedAt(Timestamp.from(Instant.now()));
	}
	
	protected final int getVersion() {
		return version;
	}
	
	protected final void setVersion(int version) {
		this.version = version;
	}
	
	public final Timestamp getCreatedAt() {
		return createdAt;
	}
	
	private final void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public final Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	private final void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public final String getUuid() {
		return uuid;
	}
	
	private final void setUuid(String uuid) {
		this.uuid = uuid;
	}


}
