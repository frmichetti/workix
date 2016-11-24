package br.com.codecode.workix.bean;

import java.io.Serializable;

/**
 * Base ManagedBean Only for share common Fields or Methods
 * @author felipe
 *
 */
public abstract class BaseMB implements Serializable {

	private static final long serialVersionUID = 6010952451064142216L;

	/**
	 * For Debug Use Only
	 */
	public BaseMB() {
		System.out.println("[CDI - " + this.getClass().getSimpleName() + "]");
		System.out.println("Hash code --> " + this.getClass().hashCode() + " <-- Hash code");
	}

}
