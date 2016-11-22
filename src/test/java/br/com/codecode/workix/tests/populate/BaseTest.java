package br.com.codecode.workix.tests.populate;

import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.codecode.workix.tests.util.GsonCalendarDeserializer;
import br.com.codecode.workix.tests.util.GsonDateDeserializer;
import br.com.codecode.workix.tests.util.HttpConfig;
/**
 * BaseTest Share Common Fields
 * @author felipe
 *
 */
public class BaseTest {
	
	/**
	 * Must Be Changed 
	 * @see {@link HttpConfig} 
	 * {@link HttpConfig #JAVAEE_PROJ_PROD} or {@link HttpConfig #JAVAEE_PROJ_TEST} 
	 */
	protected String server = HttpConfig.JAVAEE_PROJ_TEST;

	private Gson gson;

	public BaseTest() {
		gson = buildGson();
	}

	private Gson buildGson(){
		return new GsonBuilder()				
				.setPrettyPrinting()
				.setDateFormat("dd-MM-yyyy'T'HH:mm:ss")				
				.enableComplexMapKeySerialization()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.registerTypeAdapter(Calendar.class, new GsonCalendarDeserializer())			
				.create();
	}

	public Gson getGson(){

		return gson;
	}

}
