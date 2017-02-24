package br.com.codecode.workix.tests.json.parse.jdk8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.jpa.models.jdk8.SelectiveProcess;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.json.parse.DownloadTest;

public class DownloadTestSelectiveProccess extends BaseTest implements DownloadTest<SelectiveProcess> {

    private String resp;

    @Before    
    public void downloadItens() {	

	resp = downloadItens(server + "/selectiveprocesses");	

    }

    @Test    
    public void parseItens() {
	
	assertFalse(resp.isEmpty());
	
	List<SelectiveProcess> sps = parseItens(resp, new TypeToken<List<SelectiveProcess>>(){});

	assertNotNull(sps);

	assertTrue(sps.size() >= 0);		

	System.out.println("----Stream----");
	
	System.out.println(sps.size());

	sps.stream().forEach(System.out::println);

	System.out.println("----Stream----");

    }

}
