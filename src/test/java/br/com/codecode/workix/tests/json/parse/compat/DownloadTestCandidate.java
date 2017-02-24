package br.com.codecode.workix.tests.json.parse.compat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.jpa.models.compat.Candidate;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.json.parse.DownloadTest;

public class DownloadTestCandidate extends BaseTest implements DownloadTest<Candidate> {

    private String resp;

    @Before    
    public void downloadItens() {

	resp = downloadItens(server + "/candidates");

	assertFalse(resp.isEmpty());

	new GsonBuilder()		
	.setPrettyPrinting()
	.create();

    }

    @Test    
    public void parseItens() {	

	List<Candidate> companies = parseItens(resp, new TypeToken<List<Candidate>>(){});

	assertNotNull(companies);

	assertTrue(companies.size() > 0);

	System.out.println("----Stream----");

	companies.stream()	
	.forEach(System.out::println);

	System.out.println("----Stream----");

    }

}
