package br.com.codecode.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.codecode.model.scaffold.Candidate;

public class TestSelectiveProcess {

	private SelectiveProcess selectiveProcess;

	private ArrayList<Candidate> candidates;

	private Candidate c1,c2,c3;

	@Before
	public void init(){

		selectiveProcess = new SelectiveProcess();

		selectiveProcess.active = true;		
		
		selectiveProcess.maxCandidates = 1 ;

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

	@Test
	public void testInstance() {

		assertNotNull(selectiveProcess);

		assertNotNull(candidates);

		assertEquals(1, selectiveProcess.maxCandidates);
		
		assertTrue(selectiveProcess.active);
		
		assertEquals(3, candidates.size());

		
	}

	@Test
	public void testRegisterTwoCandidates(){	
		
		selectiveProcess.maxCandidates = 2;

		assertTrue(selectiveProcess.active);

		assertTrue(selectiveProcess.registerCandidate(c1));

		assertTrue(selectiveProcess.active);

		assertTrue(selectiveProcess.registerCandidate(c2));		

		assertFalse(selectiveProcess.active);
		
		assertFalse(selectiveProcess.registerCandidate(c3));

		assertFalse(selectiveProcess.active);
	}

	

}
