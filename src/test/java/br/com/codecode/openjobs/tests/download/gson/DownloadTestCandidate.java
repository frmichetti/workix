package br.com.codecode.openjobs.tests.download.gson;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.openjobs.tests.download.DownloadTest;
import br.com.codecode.openjobs.tests.util.GsonDateDeserializer;
import br.com.codecode.openjobs.tests.util.HttpTests;
import br.com.codecode.workix.model.scaffold.Candidate;

public class DownloadTestCandidate implements DownloadTest{
	
	private String resp;

	@Before
	public void downloadItens() {
		
		System.out.println("downloadItens");
		
		resp = HttpTests.sendGet(server + "candidates");
		
		assertFalse(resp.isEmpty());
		
	}
	
	@Test
	@Override
	public void parseItens() {		
		
		System.out.println("parseItens");		
		
		List<Candidate> companies = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<Candidate>>(){}.getType()); 
		
		assertNotNull(companies);
		
		assertTrue(companies.size() > 0);
		
		System.out.println("----Stream----");
		
		companies.stream().forEach(System.out::println);
		
		System.out.println("----Stream----");
		
		
	}

}
