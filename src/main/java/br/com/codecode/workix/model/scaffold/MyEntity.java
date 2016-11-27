package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
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

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;

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
 * @since 1.1
 * @version 1.1
 * @see Traceable
 * @see Persistable
 * @see Serializable
 */
@MappedSuperclass
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
abstract class MyEntity implements Traceable, Persistable, Serializable {

	private static final long serialVersionUID = -5791260209364116790L;

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
	protected MyEntity(){}		
	
	@Override
	@PrePersist
	public void prepareToPersist(){
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
