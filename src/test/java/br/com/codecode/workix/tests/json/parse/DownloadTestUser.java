package br.com.codecode.workix.tests.json.parse;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.tests.android.BaseTest;

public class DownloadTestUser extends BaseTest implements DownloadTest<User> {

    private String resp;

    @Before    
    public void downloadItens() {	

	resp = downloadItens(server + "/users");	

    }

    @Test    
    public void parseItens() {
	
	assertFalse(resp.isEmpty());
	
	List<User> users = parseItens(resp, new TypeToken<List<User>>(){});

	assertNotNull(users);

	assertTrue(users.size() > 0);		

	System.out.println("----Stream----");
	
	System.out.println(users.size());

	users.stream().forEach(u -> System.out.println(u.getEmail()));

	System.out.println("----Stream----");

    }

}
