/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.openjobs.tests.populate.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.google.gson.GsonBuilder;

import br.com.codecode.openjobs.model.scaffold.User;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.codecode.openjobs.tests.util.HttpConfig;

/**
 * Populate DB with Users
 * 
 * @author felipe
 * @since 1.0
 * @version
 */
public class PopulateUserTest{

	private List<User> users;

	private String resp;

	@Before	
	public void create() {		
		
		users = new ArrayList<>();
			
		for(int x=0 ; x < 5_000;x++){
			
			User u = new User();			
			
			u.setEmail("mockupusernumber" + String.valueOf(x)+"@test.com");
			
			assertNotNull(u.getEmail());
			
			assertNotEquals("",u.getEmail());			
			
			u.setUuid(UUID.randomUUID().toString());
			
			u.setFirebaseUUID(UUID.randomUUID().toString());
			
			u.setFirebaseMessageToken(UUID.randomUUID().toString());		
			
			System.out.println("[create] " + u.getEmail());
			
			addToList(u);
		}
		
		assertEquals(5_000,users.size());

	}


	private void addToList(User u) {
		
		assertNotNull(u);

		System.out.println("[addToList] " + u.getEmail());		

		users.add(u);		

	}
	
	@Test	
	public void sendToServer() {		

		users.stream().forEach(u -> {
			
			System.out.println("[sendToServer] " + u.getEmail());
		
			resp = Http.sendPost(HttpConfig.SCAFFOLD_PROJ + "users",
					new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.create().toJson(u));

			assertNotNull(resp);	
			
		});


	}

}
