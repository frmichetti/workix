package br.com.codecode.workix.jsf.util.listener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 * Value Change Listener for JSF
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class MyValueChangeListener implements ValueChangeListener{

	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		
		if(event != null){
			System.out.println("OLD Value " + event.getOldValue());
			System.out.println("New Value " + event.getNewValue());	
		}		
		
	}	

}
