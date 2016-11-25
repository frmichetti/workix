/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.funcional.login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.junit.Test;

import br.com.codecode.workix.model.jpa.User;
import br.com.codecode.workix.rest.android.Token;
import br.com.codecode.workix.tests.populate.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;


/**
 * Do Login With Firebase Server with JsonP
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class LoginFirebaseTestDefault extends BaseTest implements LoginTest{

	private String url = server + "/login/firebaselogin";

	private String json;

	@Test
	@Override
	public void doLoginWithFirebase() {

		System.out.println("[doLoginWithFirebase]");

		Token t = new Token();

		t.setKey("QAUOsCHKWfP1L6G4OvgBekX6ONG3");

		JsonObject jsonObject = Json.createObjectBuilder()
				.add("createdAt", t.getCreatedAt().getTime())
				.add("key",t.getKey())
				.build();

		json = HttpTest.sendPost(url,jsonObject.toString());		

		assertNotSame("", json);

	}

	@Test
	@Override
	public void parseJson() {

		doLoginWithFirebase();

		System.out.println("[parseJson]");

		JsonReader jr = Json.createReader(new StringReader(json));		 

		JsonObject jo = jr.readObject();

		assertNotNull(jo);

		User u = new User();

		u.setActive(jo.getBoolean("active"));		 

		assertTrue(u.isActive());		   

		u.setEmail(jo.getString("email"));

		assertEquals("frmichetti@gmail.com",u.getEmail());
			
		u.setFirebaseUUID(jo.getString("firebaseUuid"));
		
		assertEquals("QAUOsCHKWfP1L6G4OvgBekX6ONG3", u.getFirebaseUUID());
		
		jr.close();
	}

}
