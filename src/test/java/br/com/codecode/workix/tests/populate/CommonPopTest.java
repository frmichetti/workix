/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate;

import br.com.codecode.workix.interfaces.Persistable;

import java.io.Serializable;

/**
 * Markup Interface for Populate Test Units
 * 
 * @author felipe
 */
interface CommonPopTest<Whatever extends Persistable & Serializable> {

    /**
     * Create and Populate Entities Stage 1 , Additional Stages MAY occur before
     * this
     */
    void create();

    /**
     * Add To List for Send To Server Stage 2
     * 
     * @param whatever
     *            Whatever Entity for Add to List
     */
    void addToList(Whatever whatever);

    /**
     * Send a Prepared List of Entities to Server Stage 3
     */
    void sendToServer();

}
