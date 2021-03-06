/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.codecode.workix.jaas.models.JAASRole;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Populate DB with JAAS Roles
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
public class PopulateJAASRole extends BaseTest {

    private String resp;

    private List<JAASRole> roles;    

    private void addToList(JAASRole role) {

	assertNotNull(role);

	System.out.println("[addToList] " + role.getName());

	roles.add(role);

    }


    @Before    
    public void create() {

	roles = new ArrayList<>();	

	JAASRole admin = JAASRole.builder().withName("Admin").build();

	JAASRole guest = JAASRole.builder().withName("Guest").build();

	System.out.println("[create] " + admin.getName());

	addToList(admin);		

	System.out.println("[create] " + guest.getName());	
	
	addToList(guest);

	assertTrue(roles.size() > 0 );

    }

    @Test
    public void sendToServer() {

	roles.stream().forEach(r -> {

	    System.out.println("[sendToServer] " + r.getName());

	    resp = HttpTest.sendPost(server + "/jaasroles", getGson().toJson(r));

	    assertNotNull(resp);

	});

    }

}
