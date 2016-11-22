package br.com.codecode.workix.model.interfaces;

/**
 * Markup Interface for Buildable Objects
 * 
 * @author felipe
 *
 * @param <T>
 */
public interface Buildable<T> {

	/**
	 * Return a Finished Object <T>
	 * 
	 * @return
	 */
	public T build();

}
