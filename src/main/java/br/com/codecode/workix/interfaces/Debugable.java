package br.com.codecode.workix.interfaces;

/**
 * For Debug Use Only, Show Messages on Console
 *
 * @author felipe
 * @version 1.0
 * @since 1.1
 */
public interface Debugable {

    default void onStart() {

        System.out.println("[" + this.getClass().getSimpleName() + "]");

        System.out.println("Hash code --> " + this.getClass().hashCode() + " <-- Hash code");
    }

}
