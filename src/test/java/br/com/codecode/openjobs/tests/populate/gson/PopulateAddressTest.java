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
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.openjobs.tests.populate.PopulateTest;
import br.com.codecode.openjobs.tests.util.GsonDateDeserializer;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.frmichetti.carhollics.core.model.compatibility.Address;
import br.com.frmichetti.carhollics.core.model.compatibility.Customer;

/**
 *  
 * Populate DB with Addresses
 * 
 * @author felipe
 * @since 1.0
 * @version
 *
 */
public class PopulateAddressTest implements PopulateTest {
	
	private List<Customer> customers;

	private Address add1,add2,add3;
	
	private List<Address> addresses;
	
	private String resp;
	
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
	@Override
	public void create() {	
		
		downloadCustomers();

		System.out.println("[create]");
		
		add1 = new Address();		
		
		add1.setCep(12233560L);
		
		add1.setComplement("Cond Fortaleza");
		
		add1.setStreet("Avenida Fortaleza");
		
		add1.setNeighborhood("Parque Industrial");
		
		add1.setNumber("197");
		
		add1.setComplement("Ap. 212");
		
		add1.setCustomer(customers.get(0));
		
		assertNotNull(add1);
		
		add2 = new Address();		
		
		add2.setCep(11111111L);
		
		add2.setComplement("STUB STUB STUB");
		
		add2.setStreet("STUB STUB STUB");
		
		add2.setNeighborhood("STUB STUB STUB");
		
		add2.setNumber("1111");
		
		add2.setComplement("STUB STUB STUB");
		
		add2.setCustomer(customers.get(1));
		
		assertNotNull(add2);
		
		add3 = new Address();		
		
		add3.setCep(222222222L);
		
		add3.setComplement("STUB STUB STUB");
		
		add3.setStreet("STUB STUB STUB");
		
		add3.setNeighborhood("STUB STUB STUB");
		
		add3.setNumber("2222");
		
		add3.setComplement("STUB STUB STUB");
		
		add3.setCustomer(customers.get(1));
		
		assertNotNull(add3);
		

	}

	@Test
	@Override
	public void addToList() {
		
		create();

		System.out.println("[addToList]");
		
		addresses = new ArrayList<>();
		
		addresses.add(add1);
		
		addresses.add(add2);
		
		addresses.add(add3);
		
		assertEquals(3, addresses.size());

	}

	@Test
	@Override
	public void sendToServer() {
		
		addToList();

		System.out.println("[sendToServer]");
		
		addresses.stream().forEach(a -> {
									
				resp = Http.sendPost(server + "addresses",
						new GsonBuilder()								
								.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
								.create().toJson(a)
								);	
			 

			assertNotNull(resp);
			
		});


	}

}
