package br.com.codecode.openjobs.model.scaffold.interfaces;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

interface Traceable {

	@PrePersist
	default void prepareToPersist(){
		insertTimeStamp();
		generateUUID();		
	}
	
	void insertTimeStamp();
	
	@PreUpdate
	void updateTimeStamp();

	void generateUUID();
	
	int getVersion();
	
	void setVersion(int version);

}
