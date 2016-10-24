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

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.openjobs.model.enums.Estate;
import br.com.codecode.openjobs.model.enums.JobType;
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


	private List<Company> companies;

	private List<Job> jobs;	

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
		
		assertNotNull(companies);
		
		assertTrue(companies.size() > 0);
		
		jobs = new ArrayList<>();

		for(int x=1 ; x <= 100;x++){

			Job j = new Job();	

			j.setTitle("Mockup Job N# " + String.valueOf(x));
			
			j.setDescription("Description of Job " + String.valueOf(x));
			
			j.setRequirement("Requirement of Job " + String.valueOf(x));		
			
			j.setBenefits("Benefits of Job " + String.valueOf(x));		
			
			j.setStart(new Date());
					
			j.setExpire(new Date(2017,03,11));
			
			assertTrue(j.getStart().before(j.getExpire()));
			
			j.setType((x % 2 == 0) ? JobType.FULLTIME : JobType.TEMPORARY);
			
			j.setCity("São José dos Campos");
			
			j.setEstate(Estate.SP);
			
			j.setMinPayment(new BigDecimal(1_00 * x+10));
			
			j.setMaxPayment(new BigDecimal(1_00 * x+20));
			
			j.setEmployeer(companies.get(x));			
	
			System.out.println("[create] " + j.getTitle());			

			addToList(j);
		}


		assertEquals(1_000,companies.size());

	}

	private void addToList(Job job) {	
		
		assertNotNull(job);
		
		assertNotNull(jobs);

		System.out.println("[addToList]" + job.getTitle());

		jobs.add(job);
	}

	@Test	
	public void sendToServer() {

		create();
		
		assertNotNull(jobs);
		
		assertTrue(jobs.size() > 0);

		jobs.forEach(j -> {

			System.out.println("[sendToServer] " + j.getTitle());

			resp = Http.sendPost(HttpConfig.SCAFFOLD_PROJ + "jobs",
					new GsonBuilder()				
					.setPrettyPrinting()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.enableComplexMapKeySerialization()				
					.excludeFieldsWithoutExposeAnnotation()
					.create().toJson(j));

			assertNotNull(resp);
			
			
		});	

	}

}
