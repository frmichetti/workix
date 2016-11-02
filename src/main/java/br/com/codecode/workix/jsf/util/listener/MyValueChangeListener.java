package br.com.codecode.workix.jsf.util.listener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;


public class MyValueChangeListener implements ValueChangeListener{

	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		System.out.println("OLD Value " + event.getOldValue());
		System.out.println("New Value " + event.getNewValue());
		
	}
	
	

}
