package br.com.codecode.workix.interfaces;

/**
 * For Debug Use Only, Show Messages on Console
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
public interface Debugable {

    default void onStart() {
	System.out.println("[" + this.getClass().getSimpleName() + "]");
	System.out.println("Hash code --> " + this.getClass().hashCode() + " <-- Hash code");
    }

}
