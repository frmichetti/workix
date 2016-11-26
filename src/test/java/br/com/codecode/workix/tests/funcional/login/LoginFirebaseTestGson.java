/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.funcional.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.codecode.workix.rest.android.Token;
import br.com.codecode.workix.tests.funcional.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Do Login With Firebase Server with Gson
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class LoginFirebaseTestGson extends BaseTest implements LoginTest{

	private String url = server + "/login/firebaselogin";

	private String json;

	@Test
	@Override
	public void doLoginWithFirebase() {

		System.out.println("[doLoginWithFirebase]");

		Token t = new Token();

		t.setKey("XXXXXXXXXXX");	
			
		json = HttpTest.sendPost(url, getGson().toJson(t));					

		assertFalse(json.isEmpty());		

	}

	@Test
	@Override
	public void parseJson(){

		doLoginWithFirebase();

		System.out.println("[parseJson]");		
		
		assertTrue(json.startsWith("{}"));				

	}

}
