package br.com.codecode.workix.tests.json.parse.compat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.jpa.models.compat.Company;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.json.parse.DownloadTest;

public class DownloadTestCompany extends BaseTest implements DownloadTest<Company> {

    private String resp;

    @Before        
    public void downloadItens() {	

	resp = downloadItens(server + "/companies");

	assertFalse(resp.isEmpty());

    }

    @Test    
    public void parseItens() {

	List<Company> companies = parseItens(resp, new TypeToken<List<Company>>(){});

	assertNotNull(companies);

	assertTrue(companies.size() > 0);

	System.out.println("----Stream----");

	companies.stream().forEach(System.out::println);

	System.out.println("----Stream----");

    }

}
