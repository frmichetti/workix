package br.com.codecode.workix.tests.populate;

import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Populate DB with Users
 *
 * @author felipe
 * @version 1.0
 * @since 1.1
 */
public class PopulateUserTest extends BaseTest implements CommonPopTest<User> {

    private List<User> users;

    private String resp;

    @Before
    @Override
    public void create() {

        users = new ArrayList<>();

        int howManyUsers = 100;
        for (int x = 0; x < howManyUsers; x++) {

            User u = User.builder()

                    .withEmail("mockupusernumber" + (x + 1) + "@test.com")

                    .withFirebaseUUID(UUID.randomUUID().toString())

                    .withFirebaseMessageToken(UUID.randomUUID().toString());

            assertNotNull(u.getEmail());

            assertNotEquals("", u.getEmail());

            System.out.println("[create] " + u.getEmail());

            addToList(u);
        }

        assertEquals(howManyUsers, users.size());

    }

    @Override
    public void addToList(User u) {

        assertNotNull(u);

        System.out.println("[addToList] " + u.getEmail());

        users.add(u);

    }

    @Test
    @Override
    public void sendToServer() {

        users.forEach(u -> {

            System.out.println("[sendToServer] " + u.getEmail());

            resp = HttpTest.sendPost(server + "/users", getGson().toJson(u));

            assertNotNull(resp);

        });

    }

}
