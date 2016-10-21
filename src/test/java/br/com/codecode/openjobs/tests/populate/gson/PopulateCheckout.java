package br.com.codecode.openjobs.tests.populate.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.openjobs.tests.populate.PopulateTest;
import br.com.codecode.openjobs.tests.util.GsonDateDeserializer;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.frmichetti.carhollics.core.model.compatibility.Address;
import br.com.frmichetti.carhollics.core.model.compatibility.Checkout;
import br.com.frmichetti.carhollics.core.model.compatibility.Customer;
import br.com.frmichetti.carhollics.core.model.compatibility.Service;
import br.com.frmichetti.carhollics.core.model.compatibility.Vehicle;

/**
 * Populate DB with Checkouts
 * 
 * @author felipe
 * @since 1.0
 * @version
 */
public class PopulateCheckout implements PopulateTest {

	private List<Address> addresses;
	
	private List<Customer> customers;

	private List<Service> services;

	private List<Vehicle> vehicles;	

	private Checkout cko1,cko2,cko3;

	private List<Checkout> checkouts;

	private String resp;
	
	@Test
	public void downloadAddresses(){

		System.out.println("[downloadAddresses]");

		resp = Http.sendGet(server + "addresses");
		
		assertFalse(resp.isEmpty());

		addresses = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<Address>>(){}.getType());
		
		assertNotNull(addresses);

		assertTrue(addresses.size() > 0);
		
		
	}


	@Test
	public void downloadVehicles(){

		System.out.println("[downloadVehicles]");

		resp = Http.sendGet(server + "vehicles");

		vehicles = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<Vehicle>>(){}.getType());

		assertNotNull(vehicles);

		assertTrue(vehicles.size() > 0);
	}



	@Test
	public void downloadCustomers(){

		System.out.println("[downloadCustomers]");

		resp = Http.sendGet(server + "customers");

		customers = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<Customer>>(){}.getType());

		assertNotNull(customers);

		assertTrue(customers.size() > 0);
	}

	@Test
	public void downloadServices(){

		System.out.println("[downloadServices]");

		resp = Http.sendGet(server + "services");

		services = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<Service>>(){}.getType());

		assertNotNull(services);

		assertTrue(services.size() > 0);
	}

	@Test
	@Override
	public void create() {	

		downloadVehicles();

		downloadAddresses();

		downloadCustomers();

		downloadServices();

		System.out.println("[create]");

		cko1 = new Checkout();

		cko1.setCustomer(customers.get(1));		

		cko1.setTotal(BigDecimal.TEN);

		cko1.setAddress(addresses.get(0).toJson());
		
		cko1.setVehicle(vehicles.get(0));

		cko1.setCustomer(customers.get(0));
		
		cko1.setShoppingCart("STUB");

		assertNotNull(cko1);	

		cko2 = new Checkout();

		cko2.setCustomer(customers.get(1));

		cko2.setTotal(BigDecimal.TEN);

		cko2.setAddress(addresses.get(0).toJson());
		
		cko2.setVehicle(vehicles.get(0));

		cko2.setCustomer(customers.get(0));
		
		cko2.setShoppingCart("STUB");

		assertNotNull(cko2);	

		cko3 = new Checkout();

		cko3.setCustomer(customers.get(1));	

		cko3.setTotal(BigDecimal.TEN);

		cko3.setAddress(addresses.get(0).toJson());
		
		cko3.setVehicle(vehicles.get(0));

		cko3.setCustomer(customers.get(0));
		
		cko3.setShoppingCart("STUB");

		assertNotNull(cko3);	


	}

	@Test
	@Override
	public void addToList() {

		create();

		System.out.println("[addToList]");

		checkouts = new ArrayList<>();

		checkouts.add(cko1);

		checkouts.add(cko2);

		checkouts.add(cko3);

		assertEquals(3,checkouts.size());

	}

	@Test
	@Override
	public void sendToServer() {

		addToList();

		System.out.println("[sendToServer]");

		checkouts.forEach(c -> {

			resp = Http.sendPost(server + "checkouts",
					new GsonBuilder()					
					.setPrettyPrinting()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.enableComplexMapKeySerialization()
					.create().toJson(c));

			assertNotNull(resp);
		});


	}

}
