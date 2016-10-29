/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate;

import br.com.codecode.workix.tests.util.HttpConfig;

public interface PopulateTest {
	
	String server = HttpConfig.JAVAEE_PROJ_PROD;
	
	void create();
	
	void addToList();
	
	void sendToServer();

}
