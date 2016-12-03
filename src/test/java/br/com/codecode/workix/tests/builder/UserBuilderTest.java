package br.com.codecode.workix.tests.builder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.codecode.workix.core.models.compat.User;
import br.com.codecode.workix.core.models.jdk8.actions.UserActions;
import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.interfaces.Persistable;

public class UserBuilderTest {

    private User user;

    private User.Builder builder;

    @Test
    public void testInstance() {

	builder = new User.Builder("");

	assertTrue(builder instanceof Buildable<?>);
    }

    @Test
    public void constructorTest() {

	builder = new User.Builder("frmichetti@gmail.com");

	assertNotNull(builder);

    }

    @Test
    public void constructorWithFiels() {

	user = new User.Builder("frmichetti@gmail.com").withActive(true).withFirebaseMessageToken("xxxxxxxxxxxxxxx")
		.withFirebaseUUID("2345678974532").build();

	assertNotNull(user);

	assertTrue(user instanceof Persistable);

	assertTrue(user instanceof UserActions);

    }

}
