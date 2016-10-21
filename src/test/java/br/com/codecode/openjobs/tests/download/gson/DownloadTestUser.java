package br.com.codecode.openjobs.tests.download.gson;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.openjobs.model.scaffold.User;
import br.com.codecode.openjobs.tests.download.DownloadTest;
import br.com.codecode.openjobs.tests.util.GsonDateDeserializer;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.codecode.openjobs.tests.util.HttpConfig;

public class DownloadTestUser implements DownloadTest {

	private String resp;

	@Test
	@Override
	public void downloadItens() {		

		System.out.println("downloadItens");
		
		resp = Http.sendGet(HttpConfig.SCAFFOLD_PROJ + "users");
		
		assertFalse(resp.isEmpty());


	}

	@Test
	@Override
	public void parseItens() {
		
		System.out.println("parseItens");

		downloadItens();

		List<User> users = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<User>>(){}.getType()); 

		assertNotNull(users);

		assertTrue(users.size() > 0);

		System.out.println("----Stream----");

		users.stream().forEach((u) -> {
			System.out.println(u.getEmail());
		});

		System.out.println("----Stream----");


	}

}
