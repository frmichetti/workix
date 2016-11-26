package br.com.codecode.workix.bean;

import java.io.Serializable;

import br.com.codecode.workix.interfaces.Debugable;

/**
 * Base ManagedBean Only for share common Fields or Methods
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Serializable
 * @see Debugable
 */
abstract class BaseMB implements Serializable, Debugable {

	private static final long serialVersionUID = 6010952451064142216L;

	/**
	 * For Debug Use Only
	 */
	public BaseMB() {
		System.out.println("---CDI---");
		Debugable.super.onStart();				
	}	
	
	/**
	 * Common Initializer Method
	 */
	protected abstract void init();

}
