package br.com.codecode.openjobs.tests.download.gson;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.codecode.openjobs.tests.download.DownloadTest;
import br.com.codecode.openjobs.tests.util.GsonDateDeserializer;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.frmichetti.carhollics.core.model.compatibility.Vehicle;

public class DownloadTestVehicle implements DownloadTest {

	private String resp;

	@Test
	@Override
	public void downloadItens() {

		System.out.println("downloadItens");

		resp = Http.sendGet(server + "vehicles");

		assertFalse(resp.isEmpty());

	}
	@Test
	@Override
	public void parseItens() {

		System.out.println("parseItens");

		downloadItens();

		List<Vehicle> vehicles = new GsonBuilder()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization()			
				.create()
				.fromJson(resp, new TypeToken<List<Vehicle>>(){}.getType()); 

		assertNotNull(vehicles);

		assertTrue(vehicles.size() > 0);

		System.out.println("----Stream----");

		vehicles.stream().forEach(System.out::println);

		System.out.println("----Stream----");

	}

}
