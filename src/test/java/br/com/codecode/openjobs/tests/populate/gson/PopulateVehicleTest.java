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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.openjobs.tests.populate.PopulateTest;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.frmichetti.carhollics.core.model.compatibility.Category;
import br.com.frmichetti.carhollics.core.model.compatibility.Vehicle;

/**
 * Populate DB with Vehicles
 *  
 * @author felipe
 * @since 1.0
 * @version
 */
public class PopulateVehicleTest implements PopulateTest {
	
	private Vehicle v1,v2,v3;

	private List<Category> categories;

	private List<Vehicle> vehicles;	

	private String resp;

	@Test
	public void downloadCategories(){

		System.out.println("[downloadCategories]");

		resp = Http.sendGet(server + "categories");

		categories = new GsonBuilder()
				.serializeNulls()
				.create()
				.fromJson(resp, new TypeToken<List<Category>>(){}.getType());

		assertNotNull(categories);

		assertTrue(categories.size() > 0);

	}

	@Test
	@Override
	public void create() {	

		downloadCategories();

		System.out.println("[create]");

		v1 = new Vehicle();		

		v1.setBrand("Ford");

		v1.setModel("Mustang");

		v1.setCategory(categories.get(0));

		assertNotNull(v1);

		v2 = new Vehicle();		

		v2.setBrand("Chevrolet");

		v2.setModel("Cobalt");

		v2.setCategory(categories.get(1));

		assertNotNull(v2);

		v3 = new Vehicle();		

		v3.setBrand("Fiat");

		v3.setModel("Punto");

		v3.setCategory(categories.get(2));

		assertNotNull(v3);


	}

	@Test
	@Override
	public void addToList() {

		create();

		System.out.println("[addToList]");
		
		vehicles = new ArrayList<>();
		
		vehicles.add(v1);
		
		vehicles.add(v2);
		
		vehicles.add(v3);
		
		assertEquals(3,vehicles.size());


	}

	@Test
	@Override
	public void sendToServer() {

		addToList();

		System.out.println("[sendToServer]");
		
		vehicles.forEach(v -> {
			
			resp = Http.sendPost(server + "vehicles",
					new GsonBuilder()					
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.setPrettyPrinting()					
					.enableComplexMapKeySerialization()
					.create().toJson(v));

			assertNotNull(resp);
			
		});

	}

}
