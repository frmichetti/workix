/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.model.interfaces;

/**
 * Markup Interface for Persistable Entities
 * Implements this for works with SimpleEntityConverter
 * and AnotherEntityConverter for JSF
 * 
 * @author Felipe Rodrigues Michetti
 *
 */
public interface Persistable {  

	public long getId();	
	
	public void setId(final long id);

}  
