package br.com.codecode.workix.tests.populate.jdk7;

import br.com.codecode.workix.jpa.models.jdk7.Job;
import br.com.codecode.workix.jpa.models.jdk7.SelectiveProcess;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.populate.CommonPopTest;
import br.com.codecode.workix.tests.util.HttpTest;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Populate DB with Selective Processes
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
public class PopulateSelectiveProcessTest extends BaseTest implements CommonPopTest<SelectiveProcess> {

    private String resp;

    private List<Job> jobs;

    private List<SelectiveProcess> processes;

    private int howManyProcesses = 50;

    @Before
    public void downloadJobs() {

        System.out.println("[downloadJobs]");

        resp = HttpTest.sendGet(server + "/jobs");

        jobs = getGson().fromJson(resp, new TypeToken<List<Job>>() {
        }.getType());

        assertNotNull(jobs);

        assertTrue(jobs.size() > 0);

    }

    @Override
    public void addToList(SelectiveProcess selectiveProcess) {

        assertNotNull(selectiveProcess);

        assertNotNull(processes);

        System.out.println("[addToList]" + selectiveProcess.getJob().getTitle());

        processes.add(selectiveProcess);
    }

    @Override
    public void create() {

        assertNotNull(jobs);

        assertTrue(jobs.size() > 0);

        processes = new ArrayList<>();

        for (int x = 0; x < howManyProcesses; x++) {

            SelectiveProcess sp = new SelectiveProcess();

            sp.setJob(jobs.get(x));

            sp.setMaxCandidates(1);

            addToList(sp);
        }

        assertEquals(50, processes.size());

    }

    @Test
    @Override
    public void sendToServer() {

        create();

        assertNotNull(jobs);

        assertTrue(jobs.size() > 0);

        processes.forEach(p -> {

            System.out.println("[sendToServer] " + p.getJob().getTitle());

            resp = HttpTest.sendPost(server + "/selectiveprocesses", getGson().toJson(p));

            assertNotNull(resp);

        });

    }

}
