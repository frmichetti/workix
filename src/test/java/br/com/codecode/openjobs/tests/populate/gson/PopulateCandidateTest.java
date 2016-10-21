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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.openjobs.model.scaffold.Candidate;
import br.com.codecode.openjobs.model.scaffold.User;
import br.com.codecode.openjobs.tests.util.GsonDateDeserializer;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.codecode.openjobs.tests.util.HttpConfig;
/**
 * 
 * Populate DB with Candidates
 * 
 * @author felipe
 * @since 1.0
 * @version
 *
 */
public class PopulateCandidateTest {


	private List<Candidate> candidates = new ArrayList<>();

	private List<User> users;	

	private String resp;

	@Before
	public void downloadUsers(){		

		System.out.println("[downloadUsers]");
		
		users = new ArrayList<>();

		resp = Http.sendGet(HttpConfig.SCAFFOLD_PROJ + "users");						

		users = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<User>>(){}.getType());

		assertTrue(users.size() > 0);

	}
	
	
	private void create() {		
		
		assertNotNull(users);
		
		assertTrue(users.size() > 0);

		System.out.println("[create]");				
		
		for(int x=0 ; x < users.size();x++){
			
			Candidate c = new Candidate();		
			
			c.setName("Mockup Candidate N# " + String.valueOf(x));			
			
			c.setCpf(String.valueOf(x));			
			
			c.setUser(users.get(x));
			
			addToList(c);
		}

		
		assertEquals(users.size(),candidates.size());

	}

	private void addToList(Candidate candidate) {		
		
		assertNotNull(candidates);
		
		assertNotNull(candidate);

		System.out.println("[addToList]" + candidate.getName());
		
		candidates.add(candidate);
	}

	@Test	
	public void sendToServer() {
		
		create();			
		
		assertNotNull(users);
		
		assertNotNull(candidates);		
	
		candidates.forEach(c -> {
			
			System.out.println("[sendToServer] " + c.getName());

			resp = Http.sendPost(HttpConfig.SCAFFOLD_PROJ + "candidates",
					new GsonBuilder()				
					.setPrettyPrinting()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.enableComplexMapKeySerialization()
					.create().toJson(c));

			assertNotNull(resp);
		});

	}

}
