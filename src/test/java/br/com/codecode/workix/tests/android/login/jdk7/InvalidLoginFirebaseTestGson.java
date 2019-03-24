/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.android.login.compat;

import br.com.codecode.workix.core.common.jdk7.Token;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.android.login.LoginTest;
import br.com.codecode.workix.tests.util.HttpTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Do Login With Firebase Server with Gson
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class InvalidLoginFirebaseTestGson extends BaseTest implements LoginTest {

    private String url = server + "/login/firebaselogin";

    private String json;

    @Before
    @Override
    public void doLoginWithFirebase() {

	System.out.println("[doLoginWithFirebase]");

	Token t = Token.builder().withKey("XXXXXXXXXXX").build();

	json = HttpTest.sendPost(url, getGson().toJson(t));

	assertFalse(json.isEmpty());

    }

    @Test
    @Override
    public void parseJson() {

	System.out.println("[parseJson]");

	assertTrue(json.startsWith("{\"action\":\"rebuild\"}"));

    }

}
