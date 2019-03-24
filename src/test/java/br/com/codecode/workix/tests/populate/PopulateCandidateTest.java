/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.tests.populate;

import br.com.codecode.workix.core.enums.Estate;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Contact;
import br.com.codecode.workix.jpa.models.Locale;
import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Populate DB with Candidates
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
public class PopulateCandidateTest extends BaseTest implements CommonPopTest<Candidate> {

    private List<Candidate> candidates;

    private List<User> users;

    private String resp;

    @Before
    public void downloadUsers() {

        System.out.println("[downloadUsers]");

        users = new ArrayList<>();

        resp = HttpTest.sendGet(server + "/users");

        users = getGson().fromJson(resp, new TypeToken<List<User>>() {
        }.getType());

        assertTrue(users.size() > 0);

    }

    @Override
    public void create() {

        assertNotNull(users);

        assertTrue(users.size() > 0);

        users = users.subList(0, users.size() / 2);

        candidates = new ArrayList<>();

        for (User u : users) {

            Candidate c = new Candidate();

            c.setBirthDate(new Date());

            c.setName("Candidato 'Mockup' N# " + String.valueOf(u.getId()));

            c.setCpf(new BigInteger(36, new Random()).longValue());

            c.setContact(Contact.builder().withMobilePhone(123456).build());

            c.setLocale(Locale.builder()
                    .withCity("São José dos Campos")
                    .withEstate(Estate.SP)
                    .withNeighborhood("Bairro")
                    .withZipCode(45632145)
                    .withStreet("Rua")
                    .withNumber("212").build());

            c.setUser(u);

            System.out.println("[create] " + c.getName());

            addToList(c);
        }

        assertEquals(users.size(), candidates.size());

    }

    @Override
    public void addToList(Candidate candidate) {

        assertNotNull(candidates);

        assertNotNull(candidate);

        System.out.println("[addToList]" + candidate.getName());

        candidates.add(candidate);
    }

    @Test
    @Override
    public void sendToServer() {

        assertNotNull(users);

        create();

        assertNotNull(candidates);

        candidates.forEach(c -> {

            System.out.println("[sendToServer] " + c.getName());

            resp = HttpTest.sendPost(server + "/candidates", getGson().toJson(c));

            assertNotNull(resp);
        });

    }

}
