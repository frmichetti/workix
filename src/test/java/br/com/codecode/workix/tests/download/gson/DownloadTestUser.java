package br.com.codecode.workix.tests.download.gson;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.model.jpa.User;
import br.com.codecode.workix.tests.download.DownloadTest;
import br.com.codecode.workix.tests.populate.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

public class DownloadTestUser extends BaseTest implements DownloadTest {

	private String resp;

	@Before
	public void downloadItens() {		

		System.out.println("downloadItens");
		
		resp = HttpTest.sendGet(server + "users");
		
		assertFalse(resp.isEmpty());


	}

	@Test
	@Override
	public void parseItens() {
		
		System.out.println("parseItens");		

		List<User> users = getGson().fromJson(resp, new TypeToken<List<User>>(){}.getType()); 

		assertNotNull(users);

		assertTrue(users.size() > 0);

		System.out.println("----Stream----");

		users.stream().forEach((u) -> {
			System.out.println(u.getEmail());
		});

		System.out.println("----Stream----");


	}

}
