package br.com.codecode.workix.tests.populate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import br.com.codecode.workix.tests.util.HttpTest;

public class PopulateResume extends BaseTest {

	private String resp;

	private List<Candidate> candidates;

	@Before
	public void downloadCandidate(){

		resp = HttpTest.sendGet(server + "candidates");	

		candidates = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<Candidate>>(){}.getType());

				
		assertTrue(candidates.size() > 0);

	}

	private List<Resume> create(){
		
		assertNotNull(candidates);
		
		List<Resume> res = new ArrayList<>();
		
		for (Candidate c : candidates) {
			
			Resume r = new Resume();

			r.setContent("Content of " + c.getName());

			r.setObjective("Objective of " + c.getName());

			r.setCandidate(c);

			r.addExperience(new Experience("Employer 1","Title 1",new Date(),new Date()));

			r.addExperience(new Experience("Employeer 2", "Title 2", new Date(), new Date()));

			r.addEducation(new Education("School 1", new Date(), new Date(), "Qualification"));
			
			r.addEducation(new Education("School 2", new Date(), new Date(), "Qualification 2"));

			r.addSkill(new Skill("Skill 1"));
			
			r.addSkill(new Skill("Skill 2"));
			
			res.add(r);
			
		}	


		return res;

	}	

	@Test	
	public void sendToServer() {	
		
		List<Resume> res = create();
		
		assertNotNull(res);		

		res.forEach(r -> {
			
			System.out.println("[sendToServer] " + r.getContent());

			resp = HttpTest.sendPost(server + "resumes",
					new GsonBuilder()				
					.setPrettyPrinting()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.enableComplexMapKeySerialization()
					.create().toJson(r));

			assertNotNull(resp);
		});




	}

}
