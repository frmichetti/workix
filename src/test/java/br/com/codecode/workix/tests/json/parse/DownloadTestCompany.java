package br.com.codecode.workix.tests.json.parse;

import br.com.codecode.workix.jpa.models.Company;
import br.com.codecode.workix.tests.android.BaseTest;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DownloadTestCompany extends BaseTest implements DownloadTest<Company> {

    private String resp;

    @Before
    public void downloadItens() {

        resp = downloadItens(server + "/companies");

        assertFalse(resp.isEmpty());

    }

    @Test
    public void parseItens() {

        List<Company> companies = parseItens(resp, new TypeToken<List<Company>>() {
        });

        assertNotNull(companies);

        assertTrue(companies.size() > 0);

        System.out.println("----Stream----");

        companies.forEach(System.out::println);

        System.out.println("----Stream----");

    }

}
