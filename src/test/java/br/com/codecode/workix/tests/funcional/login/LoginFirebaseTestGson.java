/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.funcional.login;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.model.base.BaseUser;
import br.com.codecode.workix.model.jpa.User;
import br.com.codecode.workix.rest.android.Token;
import br.com.codecode.workix.tests.populate.BaseTest;
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

		assertNotNull("", json);

	}

	@Test
	@Override
	public void parseJson(){

		doLoginWithFirebase();

		System.out.println("[parseJson]");
		
		assertNotSame("{}", json);

		System.out.println(json);

		User u = getGson().fromJson(json, new TypeToken<User>(){}.getType());	

		assertNotNull(u);	

		assertTrue(u instanceof BaseUser);		
/*
		assertTrue(u.getId() > 0);

		assertEquals(u.isActive(),true);

		assertEquals(u.getEmail(), "frmichetti@gmail.com");

		assertEquals(u.getFirebaseUUID() , "HkwSYQd4rHUk22YPX2chHmqzwtR2");

		assertTrue(u.getUniqueID().length() > 0);
		
		System.out.println("-------Received-----------");
		
		System.out.println(u.toString());
*/
	}

}
