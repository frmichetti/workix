/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.openjobs.tests.populate;

import br.com.codecode.openjobs.tests.util.HttpConfig;

public interface PopulateTest {
	
	String server = HttpConfig.JAVAEE_PROJ_TEST;
	
	void create();
	
	void addToList();
	
	void sendToServer();

}
