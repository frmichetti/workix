/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.openjobs.tests.populate.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.google.gson.GsonBuilder;

import br.com.codecode.openjobs.tests.populate.PopulateTest;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.frmichetti.carhollics.core.model.compatibility.Category;

/**
 * Populate DB with Categories
 *  
 * @author felipe
 * @since 1.0
 * @version
 */
public class PopulateCategoryTest implements PopulateTest {

	private Category c1, c2,c3 ;

	private List<Category> categories;

	private String resp;

	@Test
	@Override
	public void create() {

		System.out.println("[create]");

		c1 = new Category();

		c1.setDescription("Pequeno");

		assertNotNull(c1);

		c2 = new Category();

		c2.setDescription("Médio");

		assertNotNull(c2);

		c3 = new Category();

		c3.setDescription("Grande");		

		assertNotNull(c3);
	}

	@Test
	@Override
	public void addToList(){	

		create();
		
		System.out.println("[addToList]");

		categories = new ArrayList<>();

		categories.add(c1);

		categories.add(c2);

		categories.add(c3);

		assertEquals(3,categories.size());		
	}

	@Test
	@Override
	public void sendToServer(){

		addToList();

		System.out.println("[sendToServer]");		

		categories.stream().forEach(c ->{			
			
				resp = Http.sendPost(server + "categories",
						new GsonBuilder()						
						.create().toJson(c));
			
			assertNotNull(resp);
		});


	}




}
