/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate;

import java.io.Serializable;

import br.com.codecode.workix.model.interfaces.Persistable;

/**
 * Markup Interface for Populate Test Units
 * @author felipe
 *
 */
public interface CommonPopTest<Whatever extends Persistable & Serializable> {
	
	/**
	 * Create and Populate Entities
	 */
	void create();
	
	/**
	 * Add To List for Send To Server
	 * @param whatever
	 */
	void addToList(Whatever whatever);
	
	/**
	 * Send a Prepared List of Entities to Server
	 */
	void sendToServer();

}
