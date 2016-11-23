package br.com.codecode.workix.model.interfaces;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Markup Interface for Traceable Entities 
 * @author felipe
 *
 */
public interface Traceable {

	/**
	 * Must Be Called on JPA {@link PrePersist} Event
	 */
	default void prepareToPersist(){
		insertTimeStamp();
		generateUUID();		
	}

	void insertTimeStamp();

	void generateUUID();

	/**
	 * Must be Called on JPA {@link PreUpdate} Event
	 */
	void updateTimeStamp();

}
