package br.com.codecode.workix.tests.builder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.codecode.workix.model.interfaces.Buildable;
import br.com.codecode.workix.model.interfaces.Persistable;
import br.com.codecode.workix.model.jpa.User;

public class UserBuilderTest {
	
	private User user;
	
	private User.Builder u;
	
	@Test
	public void testInstance(){			
		
		u = new User.Builder("");
		
		assertTrue(u instanceof Buildable<?>); 
	}

	@Test
	public void constructorTest() {
		
		u = new User.Builder("frmichetti@gmail.com");
		
		assertNotNull(u);		
		
	}
	
	@Test
	public void constructorWithFiels(){
		
		user = new User.Builder("frmichetti@gmail.com")
		.withActive(true)
		.withFirebaseMessageToken("xxxxxxxxxxxxxxx")
		.withFirebaseUUID("2345678974532")
		.build();
		
		assertNotNull(user);
		
		assertTrue(user instanceof Persistable);
		
	}
	


}
