package br.com.codecode.workix.tests.json.parse.jdk7;

import br.com.codecode.workix.jpa.models.jdk7.Candidate;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.json.parse.DownloadTest;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

        List<Candidate> companies = parseItens(resp, new TypeToken<List<Candidate>>() {
        });

        assertNotNull(companies);

        assertTrue(companies.size() > 0);

        System.out.println("----Stream----");

        companies
                .forEach(System.out::println);

        System.out.println("----Stream----");

    }

}
