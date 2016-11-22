package br.com.codecode.workix.tests.populate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Education;
import br.com.codecode.workix.model.scaffold.Experience;
import br.com.codecode.workix.model.scaffold.Resume;
import br.com.codecode.workix.model.scaffold.Skill;
import br.com.codecode.workix.tests.util.HttpTest;
/**
 * Populate DB with Resumes
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class PopulateResume extends BaseTest implements CommonPopTest<Resume>{

	private String resp;

	private List<Candidate> candidates;

	private List<Resume> res; 

	@Before
	public void downloadCandidate(){

		resp = HttpTest.sendGet(server + "candidates");	

		candidates = getGson().fromJson(resp, 
				new TypeToken<List<Candidate>>(){}.getType());

		assertTrue(candidates.size() > 0);

	}

	@Override
	public void create(){

		assertNotNull(candidates);

		res = new ArrayList<>();

		for (Candidate c : candidates) {

			Resume r = new Resume();

			r.setContent("Content of " + c.getName());

			r.setObjective("Objective of " + c.getName());

			r.setCandidate(c);

			r.addExperience(new Experience("Employer 1","Title 1",Calendar.getInstance(),Calendar.getInstance()));

			r.addExperience(new Experience("Employeer 2", "Title 2", Calendar.getInstance(), Calendar.getInstance()));

			r.addEducation(new Education("School 1", Calendar.getInstance(), Calendar.getInstance(), "Qualification"));

			r.addEducation(new Education("School 2", Calendar.getInstance(), Calendar.getInstance(), "Qualification 2"));

			r.addSkill(new Skill("Skill 1"));

			r.addSkill(new Skill("Skill 2"));

			addToList(r);

		}	


	}



	@Override
	public void addToList(Resume resume) {

		assertNotNull(candidates);

		assertNotNull(resume);

		System.out.println("[addToList]" + resume.getContent());

		res.add(resume);

	}

	@Test	
	@Override
	public void sendToServer() {	

		assertNotNull(res);		

		res.forEach(r -> {

			System.out.println("[sendToServer] " + r.getContent());

			resp = HttpTest.sendPost(server + "resumes",
					getGson().toJson(r));

			assertNotNull(resp);
		});




	}

}
