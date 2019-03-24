package br.com.codecode.workix.tests.json.parse.jdk7;

import br.com.codecode.workix.jpa.models.jdk7.User;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.json.parse.DownloadTest;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DownloadTestUser extends BaseTest implements DownloadTest<User> {

    private String resp;

    @Before
    public void downloadItens() {

        resp = downloadItens(server + "/users");

    }

    @Test
    public void parseItens() {

        assertFalse(resp.isEmpty());

        List<User> users = parseItens(resp, new TypeToken<List<User>>() {
        });

        assertNotNull(users);

        assertTrue(users.size() > 0);

        System.out.println("----Stream----");

        System.out.println(users.size());

        users.forEach(u -> System.out.println(u.getEmail()));

        System.out.println("----Stream----");

    }

}
