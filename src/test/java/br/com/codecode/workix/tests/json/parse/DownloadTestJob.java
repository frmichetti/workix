package br.com.codecode.workix.tests.json.parse;

import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.tests.android.BaseTest;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DownloadTestJob extends BaseTest implements DownloadTest<Job> {

    private String resp;

    @Before
    public void downloadItens() {

        resp = downloadItens(server + "/jobs");

    }

    @Test
    public void parseItens() {

        assertFalse(resp.isEmpty());

        List<Job> jobs = parseItens(resp, new TypeToken<List<Job>>() {
        });

        assertNotNull(jobs);

        assertTrue(jobs.size() > 0);

        System.out.println("----Stream----");

        System.out.println(jobs.size());

        jobs.forEach(j -> System.out.println(j.getDescription()));

        System.out.println("----Stream----");

    }

}
