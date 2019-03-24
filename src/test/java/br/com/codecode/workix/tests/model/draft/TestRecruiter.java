package br.com.codecode.workix.tests.model.draft;

import br.com.codecode.workix.jpa.models.Candidate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;



public class TestRecruiter {

    private SelectiveProcess pro1, pro2, pro3;

    private Candidate c2;

    @Before
    public void init() {

	System.out.println();

	System.out.println("[Before]");

	System.out.println();

	pro1 = new SelectiveProcess();

	pro2 = new SelectiveProcess();

	pro3 = new SelectiveProcess();

	pro1.setActive(true);

	pro2.setActive(true);

	pro3.setActive(true);

	pro1.setMaxCandidates(1);

	pro2.setMaxCandidates(1);

	pro3.setMaxCandidates(1);

        Candidate c1 = new Candidate();
	c2 = new Candidate();
        Candidate c3 = new Candidate();

        ArrayList<Candidate> candidates = new ArrayList<>();

	candidates.add(c1);
	candidates.add(c2);
	candidates.add(c3);

	for (int x = 0; x < candidates.size(); x++) {
	    candidates.get(x).setId(x + 1L);
	    candidates.get(x).setName("Candidate " + (x + 1L));
	}

    }

    @Test
    public void testRecruiter() {

	System.out.println("[Test - Recruiter]");

	System.out.println();

        Recruiter recruiter = new Recruiter();

	recruiter.register(pro1);

	recruiter.register(pro2);

	recruiter.register(pro3);

	pro1.setActive(false);

	pro1.registerCandidate(c2);

	pro2.setActive(true);

	pro3.setActive(false);

	pro2.setActive(false);
	;

	pro1.setActive(false);
	;

    }

}
