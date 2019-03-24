package br.com.codecode.workix.tests.populate.jdk7;

import br.com.codecode.workix.jpa.models.jdk7.*;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.populate.CommonPopTest;
import br.com.codecode.workix.tests.util.HttpTest;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

	candidates = getGson().fromJson(resp, new TypeToken<List<Candidate>>(){}.getType());

	assertTrue(candidates.size() > 0);

    }

    @Override
    public void create() {

	downloadCandidate();

	assertNotNull(candidates);

	res = new ArrayList<>();

	for (Candidate c : candidates) {

	    Resume r = Resume.builder()
		    .withContent("Conteúdo de " + c.getName())
		    .withObjective("Objetivo do " + c.getName())
		    .withCandidate(c);

	    r.addExperience(Experience.builder().withEmployerName("Empregador 1")
		    .withDescription("Cargo 1")
		    .withStartDate(Calendar.getInstance())
		    .withEndDate(Calendar.getInstance())
		    .build());

	    r.addExperience(Experience.builder().withEmployerName("Empregador 2")
		    .withDescription("Cargo 2")
		    .withStartDate(Calendar.getInstance())
		    .withEndDate(Calendar.getInstance())
		    .build());

	    r.addEducation(Education.builder().withSchoolName("Escola 1")
		    .withStartDate(Calendar.getInstance())
		    .withEndDate(Calendar.getInstance())
		    .withQualification("Qualificações")
		    .withDescription("Descrição")
		    .build());

	    r.addEducation(Education.builder().withSchoolName("Escola 2")
		    .withStartDate(Calendar.getInstance())
		    .withEndDate(Calendar.getInstance())
		    .withQualification("Qualificações 2")
		    .withDescription("Descrição 2")		    
		    .build());

	    r.addSkill(Skill.builder().withSkillName("Habilidade 1").build());

	    r.addSkill(Skill.builder().withSkillName("Habilidade 2").build());

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
