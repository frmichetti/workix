package br.com.codecode.workix.tests.json.parse.jdk7;

import br.com.codecode.workix.jpa.models.jdk7.Job;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.json.parse.DownloadTest;
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

        jobs.stream().forEach(j -> System.out.println(j.getDescription()));

        System.out.println("----Stream----");

    }

}
