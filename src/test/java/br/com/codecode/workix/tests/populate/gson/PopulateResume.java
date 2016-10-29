package br.com.codecode.workix.tests.populate.gson;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Education;
import br.com.codecode.workix.model.scaffold.Experience;
import br.com.codecode.workix.model.scaffold.Resume;
import br.com.codecode.workix.model.scaffold.Skill;
import br.com.codecode.workix.tests.util.GsonDateDeserializer;
import br.com.codecode.workix.tests.util.HttpConfig;
import br.com.codecode.workix.tests.util.HttpTests;

public class PopulateResume {

	private String server = HttpConfig.JAVAEE_PROJ_TEST;

	private String resp;

	private Candidate candidate;

	@Before
	public void downloadCandidate(){

		resp = HttpTests.sendGet(server + "candidates/51");	

		candidate = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<Candidate>(){}.getType());

		assertNotNull(candidate);

	}

	private Resume create(){

		Resume r = new Resume();

		r.setContent("Content");

		r.setObjective("Objective");

		r.setOwner(candidate);

		r.addExperience(new Experience("Employer 1","Titulo 1",new Date(),new Date()));

		r.addExperience(new Experience("Employeer 2", "Titulo 2", new Date(), new Date()));

		r.addEducation(new Education("School 1", new Date(), new Date(), "Qualification"));

		r.addSkill(new Skill("Skill 1"));


		return r;

	}	

	@Test	
	public void sendToServer() {	
		
		Resume r = create();
		
		assertNotNull(r);
		
		System.out.println("[sendToServer] " + r.getOwner().getName() + " CV");

		resp = HttpTests.sendPost(server + "resumes",
				new GsonBuilder()
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.create().toJson(r));

		assertNotNull(resp);	




	}

}
