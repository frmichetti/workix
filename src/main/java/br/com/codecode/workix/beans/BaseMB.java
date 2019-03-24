package br.com.codecode.workix.beans;

import br.com.codecode.workix.interfaces.Debugable;

/**
 * Base ManagedBean Only for share common Fields or Methods
 *
 * @author felipe
 * @version 1.1
 * @see Debugable
 * @since 1.0
 */
abstract class BaseMB implements Debugable {

    /**
     * For Debug Use Only
     */
    BaseMB() {
        System.out.println("---CDI---");
        Debugable.super.onStart();
    }

    /**
     * Common Initializer Method
     */
    protected abstract void init();

}
