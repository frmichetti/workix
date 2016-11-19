package br.com.codecode.workix.tests.populate;

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

import br.com.codecode.workix.model.scaffold.Job;
import br.com.codecode.workix.model.scaffold.SelectiveProcess;
import br.com.codecode.workix.tests.util.GsonDateDeserializer;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Populate DB with Selective Processes
 * @author felipe
 *
 */
public class PopulateSelectiveProcess extends BaseTest {

	private String resp;

	private List<Job> jobs;	

	private List<SelectiveProcess> processes;

	private int howManyProcesses = 50;

	@Before
	public void downloadJobs(){

		System.out.println("[downloadJobs]");

		resp = HttpTest.sendGet(server + "jobs");						

		jobs = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<Job>>(){}.getType());

		assertNotNull(jobs);

		assertTrue(jobs.size() > 0);

	}

	private void addToList(SelectiveProcess selectiveProcess) {	

		assertNotNull(selectiveProcess);

		assertNotNull(processes);

		System.out.println("[addToList]" + selectiveProcess.getJob().getTitle());

		processes.add(selectiveProcess);
	}



	public void create() {

		assertNotNull(jobs);

		assertTrue(jobs.size() > 0);

		processes = new ArrayList<>();

		for(int x = 0;x < howManyProcesses; x++){
			
			SelectiveProcess sp = new SelectiveProcess();
			
			sp.setJob(jobs.get(x));
			
			sp.setMaxCandidates(1);			
			
			addToList(sp);
		}
		
		assertEquals(50,processes.size());

	}

	@Test	
	public void sendToServer() {

		create();

		assertNotNull(jobs);

		assertTrue(jobs.size() > 0);

		processes.forEach(p -> {

			System.out.println("[sendToServer] " + p.getJob().getTitle());

			resp = HttpTest.sendPost(server + "selectiveprocesses",
					new GsonBuilder()				
					.setPrettyPrinting()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.enableComplexMapKeySerialization()				
					.excludeFieldsWithoutExposeAnnotation()
					.create().toJson(p));

			assertNotNull(resp);


		});	

	}

}
