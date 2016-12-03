package br.com.codecode.workix.tests.json.jdk7;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.tests.funcional.BaseTest;
import br.com.codecode.workix.tests.json.DownloadTest;
import br.com.codecode.workix.tests.model.jdk7.Candidate;

public class ParseCandidateJDK7 extends BaseTest implements DownloadTest<Candidate> {

    private String resp;

    @Before    
    public void downloadItens() {	

	resp = downloadItens(server + "/candidates");	

    }

    @Test    
    public void parseItens() {
	
	assertFalse(resp.isEmpty());
	
	List<Candidate> candidates = parseItens(resp, new TypeToken<List<Candidate>>(){});

	assertNotNull(candidates);

	assertTrue(candidates.size() > 0);		

	System.out.println("----Stream----");
	
	System.out.println(candidates.size());

	candidates.stream().forEach(u -> System.out.println(u.getName()));

	System.out.println("----Stream----");

    }

}
