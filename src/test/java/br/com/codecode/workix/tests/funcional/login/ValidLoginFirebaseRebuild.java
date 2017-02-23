package br.com.codecode.workix.tests.funcional.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.codecode.workix.core.Token;
import br.com.codecode.workix.tests.funcional.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * @since 1.0
 * @version 1.1
 * @author felipe
 */
public class ValidLoginFirebaseRebuild extends BaseTest implements LoginTest {

    private String json;

    private String url = server + "/login/firebaselogin";
    
    @Override
    public void doLoginWithFirebase() {

	System.out.println("[doLoginWithFirebase]");

	Token t = Token.builder().withKey("dfTHTEWyYRhsi6TCLSbYdYroKbJ3").build();

	json = HttpTest.sendPost(url, getGson().toJson(t));

	assertFalse(json.isEmpty());

    }

    @Test
    @Override
    public void parseJson() {
	
	doLoginWithFirebase();

	Object response = getGson().fromJson(json, Object.class);
	
	System.out.println(response);

	assertNotNull(response);	

    }

}
