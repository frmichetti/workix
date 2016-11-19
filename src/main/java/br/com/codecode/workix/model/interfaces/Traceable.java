package br.com.codecode.workix.model.interfaces;

public interface Traceable {
	
	default void prepareToPersist(){
		insertTimeStamp();
		generateUUID();		
	}
	
	void insertTimeStamp();

	void updateTimeStamp();

	void generateUUID();


}
