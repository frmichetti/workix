package br.com.codecode.workix.model.interfaces;

public interface Traceable {

	/**
	 * Must Be Called on JPA Pre-Persist Event
	 */
	default void prepareToPersist(){
		insertTimeStamp();
		generateUUID();		
	}

	void insertTimeStamp();

	void generateUUID();

	/**
	 * Must be Called on JPA On-Update Event
	 */
	void updateTimeStamp();




}
