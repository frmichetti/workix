/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.openjobs.tests.populate.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.openjobs.model.scaffold.Company;
import br.com.codecode.openjobs.model.scaffold.Job;
import br.com.codecode.openjobs.tests.util.GsonDateDeserializer;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.codecode.openjobs.tests.util.HttpConfig;
/**
 * 
 * Populate DB with Jobs
 * 
 * @author felipe
 * @since 1.0
 * @version
 *
 */
public class PopulateJobTest {


	private List<Company> companies = new ArrayList<>();

	private List<Job> jobs = new ArrayList<>();	

	private String resp;

	@Before
	public void downloadCompanies(){

		System.out.println("[downloadCompanies]");

		resp = Http.sendGet(HttpConfig.SCAFFOLD_PROJ + "companies");						

		companies = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<Company>>(){}.getType());

		assertNotNull(companies);

		assertTrue(companies.size() > 0);

	}


	private void create() {				

		for(int x=0 ; x < companies.size();x++){

			Job j = new Job();		

			j.setUuid(UUID.randomUUID().toString());

			assertNotNull(j.getUuid());

			assertNotEquals("",j.getUuid());

			j.setTitle("Mockup Job N# " + String.valueOf(x));

			assertNotNull(j.getTitle());

			assertNotEquals("",j.getTitle());


			j.setDescription("Description of Job " + String.valueOf(x));

			assertNotNull(j.getDescription());

			assertNotEquals("",j.getDescription());
			
			j.setStart(new Date());
			
			j.setExpire(new Date());
			
			j.setEmployeer(companies.get(x));
	
			System.out.println("[create] " + j.getTitle());			

			addToList(j);
		}


		assertEquals(1_000,companies.size());

	}

	private void addToList(Job job) {		

		System.out.println("[addToList]" + job.getTitle());

		jobs.add(job);
	}

	@Test	
	public void sendToServer() {

		create();

		jobs.forEach(j -> {

			System.out.println("[sendToServer] " + j.getTitle());

			resp = Http.sendPost(HttpConfig.SCAFFOLD_PROJ + "jobs",
					new GsonBuilder()				
					.setPrettyPrinting()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.enableComplexMapKeySerialization()
					.create().toJson(j));

			assertNotNull(resp);
		});	

	}

}
