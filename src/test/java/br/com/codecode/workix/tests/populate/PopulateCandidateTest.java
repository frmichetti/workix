/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.User;
import br.com.codecode.workix.tests.util.HttpTest;
/**
 * 
 * Populate DB with Candidates
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 *
 */
public class PopulateCandidateTest extends BaseTest implements CommonPopTest<Candidate>{

	private List<Candidate> candidates;

	private List<User> users;	

	private String resp;

	@Before
	public void downloadUsers(){		

		System.out.println("[downloadUsers]");
		
		users = new ArrayList<>();

		resp = HttpTest.sendGet(server + "users");						

		users = getGson().fromJson(resp, new TypeToken<List<User>>(){}.getType());

		assertTrue(users.size() > 0);

	}
	
	@Override
	public void create() {		
		
		assertNotNull(users);
		
		assertTrue(users.size() > 0);
		
		users = users.subList(0, users.size()/2);
		
		candidates = new ArrayList<>();		
		
		for (User u : users) {
			
			Candidate c = new Candidate();		
			
			c.setName("Mockup Candidate N# " + String.valueOf(u.getId()));			
			
			c.setCpf(String.valueOf(u.getId()));			
			
			c.setUser(u);
			
			System.out.println("[create] " + c.getName());	
			
			addToList(c);
		}
			
		assertEquals(users.size(),candidates.size());

	}

	@Override
	public void addToList(Candidate candidate) {		
		
		assertNotNull(candidates);
		
		assertNotNull(candidate);

		System.out.println("[addToList]" + candidate.getName());
		
		candidates.add(candidate);
	}

	@Test	
	@Override
	public void sendToServer() {
		
		assertNotNull(users);				
		
		create();
		
		assertNotNull(candidates);
	
		candidates.forEach(c -> {
			
			System.out.println("[sendToServer] " + c.getName());

			resp = HttpTest.sendPost(server + "candidates",
					getGson().toJson(c));

			assertNotNull(resp);
		});

	}

}
