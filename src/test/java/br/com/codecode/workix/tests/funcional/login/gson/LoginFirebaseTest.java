/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.funcional.login.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.model.scaffold.User;
import br.com.codecode.workix.rest.android.Token;
import br.com.codecode.workix.tests.funcional.login.LoginTest;
import br.com.codecode.workix.tests.util.GsonDateDeserializer;
import br.com.codecode.workix.tests.util.HttpTest;



/**
 * Do Login With Firebase Server with Gson
 * @author felipe
 * @since 1.0
 * @version
 */
public class LoginFirebaseTest implements LoginTest{

	private String url = "http://localhost:8080/carhollics-javaee/services/login/firebaselogin";

	private String json;

	@Test
	@Override
	public void doLoginWithFirebase() {

		System.out.println("[doLoginWithFirebase]");

		Token t = new Token();

		t.setKey("QAUOsCHKWfP1L6G4OvgBekX6ONG3");

		json = HttpTest.sendPost(url, new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(t));		

		assertNotNull("", json);

	}

	@Test
	@Override
	public void parseJson(){

		doLoginWithFirebase();

		System.out.println("[parseJson]");		

		System.out.println(json);

		User u = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.create().fromJson(json, new TypeToken<User>(){}.getType());	

		assertNotNull(u);	

		assertTrue(u instanceof User);		

		assertTrue(u.getId().longValue() > 0);

		assertEquals(u.isActive(),true);

		assertEquals(u.getEmail(), "frmichetti@gmail.com");

		assertEquals(u.getFirebaseUUID() , "QAUOsCHKWfP1L6G4OvgBekX6ONG3");

		assertTrue(u.getUniqueID().length() > 0);
		
		System.out.println("-------Received-----------");
		
		System.out.println(u.toString());

	}

}
