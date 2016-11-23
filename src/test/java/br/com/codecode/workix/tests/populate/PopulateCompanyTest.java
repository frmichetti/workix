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

import br.com.codecode.workix.model.jpa.Company;
import br.com.codecode.workix.model.jpa.User;
import br.com.codecode.workix.tests.util.HttpTest;


/**
 * Populate DB with Companies
 *  
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class PopulateCompanyTest extends BaseTest implements CommonPopTest<Company> {	

	private List<Company> companies ;

	private String resp;

	private List<User> users;

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

		users = users.subList((users.size()/2), users.size());

		assertEquals(51L,users.get(0).getId());

		companies = new ArrayList<>();

		for (User u : users) {						

			Company c = new Company();		

			c.setUser(u);

			c.setName("Company Mockup N# " + String.valueOf(u.getId()));			

			c.setCnpj(String.valueOf(u.getId()));

			c.setSegment("Segment " + String.valueOf(c.getName().replace("Mockup", "Segment")));

			System.out.println("[create] " + c.getName());

			addToList(c);


		}



		assertEquals(50,companies.size());


	}

	@Override
	public void addToList(Company company){		

		assertNotNull(company);

		assertNotNull(companies);

		System.out.println("[addToList] " + company.getName());

		companies.add(company);		

	}

	@Test
	@Override
	public void sendToServer(){	

		assertNotNull(users);				

		create();

		assertNotNull(companies);

		companies.stream().forEach(c ->{			

			System.out.println("[sendToServer] " + c.getName());

			resp = HttpTest.sendPost(server + "companies",
					getGson().toJson(c));

			assertNotNull(resp);
		});


	}




}
