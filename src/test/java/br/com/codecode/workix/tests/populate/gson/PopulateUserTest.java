/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.google.gson.GsonBuilder;

import br.com.codecode.workix.model.scaffold.User;
import br.com.codecode.workix.tests.util.HttpConfig;
import br.com.codecode.workix.tests.util.HttpTests;

/**
 * Populate DB with Users
 * 
 * @author felipe
 * @since 1.0
 * @version
 */
public class PopulateUserTest{
	
	private String server = HttpConfig.JAVAEE_PROJ_TEST;

	private List<User> users;

	private String resp;

	@Before	
	public void create() {		
		
		users = new ArrayList<>();
			
		for(int x=0 ; x < 25;x++){
			
			User u = new User();			
			
			u.setEmail("mockupusernumber" + String.valueOf(x+1)+"@test.com");
			
			assertNotNull(u.getEmail());
			
			assertNotEquals("",u.getEmail());			
			
		
			
			u.setFirebaseUUID(UUID.randomUUID().toString());
			
			u.setFirebaseMessageToken(UUID.randomUUID().toString());		
			
			System.out.println("[create] " + u.getEmail());
			
			addToList(u);
		}
		
		assertEquals(25,users.size());

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
		
			resp = HttpTests.sendPost(server + "users",
					new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.create().toJson(u));

			assertNotNull(resp);	
			
		});


	}

}
