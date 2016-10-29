package br.com.codecode.workix.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.tests.SelectiveProcess;

public class TestSelectiveProcess {

	private SelectiveProcess selectiveProcess;

	private ArrayList<Candidate> candidates;

	private Candidate c1,c2,c3;

	@Before
	public void init(){

		System.out.println();

		System.out.println("[Before]");

		System.out.println();

		selectiveProcess = new SelectiveProcess();

		selectiveProcess.setActive(true);		

		selectiveProcess.setMaxCandidates(1);

		c1 = new Candidate();
		c2 = new Candidate();
		c3 = new Candidate();

		candidates = new ArrayList<>();

		candidates.add(c1);
		candidates.add(c2);
		candidates.add(c3);


		for(int x=0 ; x < candidates.size() ;x++){
			candidates.get(x).setId(x+1L);
			candidates.get(x).setName("Candidate " + (x+1L));
		}


	}

	private void testInstance() {

		System.out.println("[Test - Instance]");

		System.out.println();

		assertNotNull(selectiveProcess);

		assertNotNull(candidates);

		assertEquals(1, selectiveProcess.getMaxCandidates());

		assertTrue(selectiveProcess.isActive());

		assertEquals(3, candidates.size());


	}


	@Test
	public void testRegisterSameCandidate(){	

		testInstance();

		System.out.println("[Test - Register Same Candidate]");

		System.out.println();



		selectiveProcess.setMaxCandidates(2);

		assertTrue(selectiveProcess.isActive());

		assertTrue(selectiveProcess.registerCandidate(c1));

		assertTrue(selectiveProcess.isActive());

		assertFalse(selectiveProcess.registerCandidate(c1));

		assertTrue(selectiveProcess.isActive());


	}

	@Test
	public void testRegisterTwoCandidates(){

		testInstance();

		System.out.println("[Test - Register Two Candidates]");

		System.out.println();

		selectiveProcess.setMaxCandidates(2);

		assertTrue(selectiveProcess.isActive());

		assertTrue(selectiveProcess.registerCandidate(c1));

		assertTrue(selectiveProcess.isActive());

		assertTrue(selectiveProcess.registerCandidate(c2));		

		assertFalse(selectiveProcess.isActive());

		assertFalse(selectiveProcess.registerCandidate(c3));

		assertFalse(selectiveProcess.isActive());
	}




}
