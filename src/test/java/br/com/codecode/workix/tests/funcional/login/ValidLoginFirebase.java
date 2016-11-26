package br.com.codecode.workix.tests.funcional.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.model.Token;
import br.com.codecode.workix.model.base.BaseUser;
import br.com.codecode.workix.tests.funcional.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;
/**
 * @since 1.1
 * @version 1.0
 * @author felipe
 *
 */
public class ValidLoginFirebase extends BaseTest implements LoginTest{
	
	private String url = server + "/login/firebaselogin";

	private String json;

	@Test
	@Override
	public void doLoginWithFirebase() {
	
		System.out.println("[doLoginWithFirebase]");

		Token t = new Token();

		t.setKey("dfTHTEWyYRhsi6TCLSbYdYroKbJ3");	
			
		json = HttpTest.sendPost(url, getGson().toJson(t));					

		assertFalse(json.isEmpty());	
		
	}

	@Test
	@Override
	public void parseJson() {
		
		BaseUser u = getGson().fromJson(json, new TypeToken<BaseUser>(){}.getType());
		
		assertNotNull(u);
		
	}

}
