package br.com.codecode.workix.tests.download;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.tests.funcional.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

public class DownloadTestCandidate extends BaseTest implements DownloadTest {

    private String resp;

    @Override
    @Before
    public void downloadItens() {

	System.out.println("downloadItens");

	resp = HttpTest.sendGet(server + "/candidates");

	assertFalse(resp.isEmpty());

    }

    @Test
    @Override
    public void parseItens() {

	System.out.println("parseItens");

	List<Candidate> companies = getGson().fromJson(resp, new TypeToken<List<Candidate>>() {
	}.getType());

	assertNotNull(companies);

	assertTrue(companies.size() > 0);

	System.out.println("----Stream----");

	companies.stream().forEach(System.out::println);

	System.out.println("----Stream----");

    }

}
