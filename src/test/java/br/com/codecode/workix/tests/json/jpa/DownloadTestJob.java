package br.com.codecode.workix.tests.json.jpa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.tests.funcional.BaseTest;
import br.com.codecode.workix.tests.json.DownloadTest;

public class DownloadTestJob extends BaseTest implements DownloadTest<Job> {

    private String resp;

    @Before    
    public void downloadItens() {	

	resp = downloadItens(server + "/jobs");	

    }

    @Test    
    public void parseItens() {
	
	assertFalse(resp.isEmpty());
	
	List<Job> jobs = parseItens(resp, new TypeToken<List<Job>>(){});

	assertNotNull(jobs);

	assertTrue(jobs.size() > 0);		

	System.out.println("----Stream----");
	
	System.out.println(jobs.size());

	jobs.stream().forEach(j -> System.out.println(j.getDescription()));

	System.out.println("----Stream----");

    }

}
