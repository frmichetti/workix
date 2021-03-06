package br.com.codecode.workix.tests.android.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import br.com.codecode.workix.jpa.models.Candidate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.core.common.Token;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * @since 1.0
 * @version 1.1
 * @author felipe
 */
public class ValidLoginFirebase extends BaseTest implements LoginTest {

    private String json;

    private String url = server + "/login/firebaselogin";

    @Before
    @Override
    public void doLoginWithFirebase() {

	System.out.println("[doLoginWithFirebase]");

	Token t = Token.builder().withKey("x5rXx6LCyCddLErHSWRctK74SUR2").build();

	json = HttpTest.sendPost(url, getGson().toJson(t));

	assertFalse(json.isEmpty());

    }

    @Test
    @Override
    public void parseJson() {

	Candidate c = getGson().fromJson(json, new TypeToken<Candidate>(){}.getType());

	assertNotNull(c);

    }

}
