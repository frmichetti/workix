package br.com.codecode.workix.exception;

/**
 * Exception for Not Implemented Functions
 * @author felipe
 * 
 */
public class NotImplementedYetException extends Exception {

	private static final long serialVersionUID = 3725069176156035494L;

	public NotImplementedYetException() {
		super();
	}

	public NotImplementedYetException(String message){
		super(message);
	}

}
