package br.com.codecode.workix.tests.json.parse;

import br.com.codecode.workix.jpa.models.SelectiveProcess;
import br.com.codecode.workix.tests.android.BaseTest;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DownloadTestSelectiveProccess extends BaseTest implements DownloadTest<SelectiveProcess> {

    private String resp;

    @Before
    public void downloadItens() {

        resp = downloadItens(server + "/selectiveprocesses");

    }

    @Test
    public void parseItens() {

        assertFalse(resp.isEmpty());

        List<SelectiveProcess> sps = parseItens(resp, new TypeToken<List<SelectiveProcess>>() {
        });

        assertNotNull(sps);

        assertTrue(sps.size() >= 0);

        System.out.println("----Stream----");

        System.out.println(sps.size());

        sps.forEach(System.out::println);

        System.out.println("----Stream----");

    }

}
