package br.com.codecode.workix.tests.android.login.jdk8;

import br.com.codecode.workix.core.common.jdk7.Token;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.android.login.LoginTest;
import br.com.codecode.workix.tests.util.HttpTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @since 1.0
 * @version 1.1
 * @author felipe
 */
public class ValidLoginFirebaseRebuild extends BaseTest implements LoginTest {

    private String json;

    @Before
    @Override
    public void doLoginWithFirebase() {

	System.out.println("[doLoginWithFirebase]");

	Token t = Token.builder().withKey("dfTHTEWyYRhsi6TCLSbYdYroKbJ3").build();

        String url = server + "/login/firebaselogin";
        json = HttpTest.sendPost(url, getGson().toJson(t));

	assertFalse(json.isEmpty());

    }

    @Test
    @Override
    public void parseJson() {	

	Object response = getGson().fromJson(json, Object.class);
	
	System.out.println(response);

	assertNotNull(response);	

    }

}
