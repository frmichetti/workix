package br.com.codecode.workix.tests.populate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Education;
import br.com.codecode.workix.jpa.models.Experience;
import br.com.codecode.workix.jpa.models.Resume;
import br.com.codecode.workix.jpa.models.Skill;
import br.com.codecode.workix.tests.funcional.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Populate DB with Resumes
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class PopulateResumeTest extends BaseTest implements CommonPopTest<Resume> {

    private String resp;

    private List<Candidate> candidates;

    private List<Resume> res;

    private void downloadCandidate() {

	resp = HttpTest.sendGet(server + "/candidates");

	candidates = getGson().fromJson(resp, new TypeToken<List<Candidate>>() {
	}.getType());

	assertTrue(candidates.size() > 0);

    }

    @Override
    public void create() {

	downloadCandidate();

	assertNotNull(candidates);

	res = new ArrayList<>();

	for (Candidate c : candidates) {

	    Resume r = new Resume();

	    r.setContent("Content of " + c.getName());

	    r.setObjective("Objective of " + c.getName());

	    r.setCandidate(c);

	    r.addExperience(new Experience.Builder("Employer 1", "Title 1", LocalDate.now(), LocalDate.now()).build());

	    r.addExperience(new Experience.Builder("Employeer 2", "Title 2", LocalDate.now(), LocalDate.now()).build());

	    r.addEducation(
		    new Education.Builder("School 1", LocalDate.now(), LocalDate.now(), "Qualification", "Description")
			    .build());

	    r.addEducation(new Education.Builder("School 2", LocalDate.now(), LocalDate.now(), "Qualification 2",
		    "Description").build());

	    r.addSkill(new Skill.Builder("Skill 1").build());

	    r.addSkill(new Skill.Builder("Skill 2").build());

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

	create();

	assertNotNull(res);

	res.forEach(r -> {

	    System.out.println("[sendToServer] " + r.getContent());

	    resp = HttpTest.sendPost(server + "/resumes", getGson().toJson(r));

	    assertNotNull(resp);
	});

    }

}