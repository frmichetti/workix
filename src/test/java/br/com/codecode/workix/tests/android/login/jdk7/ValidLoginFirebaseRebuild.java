package br.com.codecode.workix.tests.android.login.compat;

import br.com.codecode.workix.core.common.jdk7.Token;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.android.login.LoginTest;
import br.com.codecode.workix.tests.util.HttpTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author felipe
 * @version 1.1
 * @since 1.0
 */
public class ValidLoginFirebaseRebuild extends BaseTest implements LoginTest {

    private String json;

    private String url = server + "/login/firebaselogin";

    @Before
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

        Object response = getGson().fromJson(json, Object.class);

        System.out.println(response);

        assertNotNull(response);

    }

}
