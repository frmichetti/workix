/** 
 * @author Felipe Rodrigues Michetti
 * @see <a href="http://portfolio-frmichetti.rhcloud.com">portfolio-frmichetti.rhcloud.com</a>
 * @see <a href="http://www.codecode.com.br">www.codecode.com.br</a>
 * @see <a href="mailto:frmichetti@gmail.com">frmichetti@gmail.com</a>
 * */
package br.com.codecode.workix.model.interfaces;

import br.com.codecode.workix.jsf.util.converter.AnotherEntityConverter;
import br.com.codecode.workix.jsf.util.converter.SimpleEntityConverter;

/**
 * Markup Interface for Persistable Entities <br>
 * Implements this for works with <br> {@link SimpleEntityConverter}
 * and {@link AnotherEntityConverter} in JSF
 * 
 * @author Felipe Rodrigues Michetti
 *
 */
public interface Persistable {  

	public long getId();	
	
	public void setId(long id);

}  
