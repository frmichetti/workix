package br.com.codecode.workix.tests.populate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.codecode.workix.config.JacksonContextResolver;
import br.com.codecode.workix.tests.util.HttpConfig;
import br.com.codecode.workix.util.gson.deserializer.GsonCalendarDeserializer;
import br.com.codecode.workix.util.gson.deserializer.GsonDateDeserializer;

/**
 * BaseTest Class Share Common Fields
 * @author felipe
 *
 */
public class BaseTest {

	/**
	 * Must Be Changed Startup Configuration
	 * @see {@link HttpConfig} 
	 * {@link HttpConfig #JAVAEE_PROJ_PROD} or {@link HttpConfig #JAVAEE_PROJ_TEST} 
	 */
	protected String server = HttpConfig.JAVAEE_PROJ_TEST;

	private Gson gson;

	public BaseTest() {

		gson = buildGson();

		if(gson == null)
			throw new RuntimeException("Gson is Null - Generated Gson Before Start");

	}
	/**
	 * Generate a Custom Gson
	 * attempt for DateFormat , Pattern Must be Equals {@link JacksonContextResolver #init()}
	 * @return
	 */
	private Gson buildGson(){
		return new GsonBuilder()				
				.setPrettyPrinting()
				.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").toPattern())				
				.enableComplexMapKeySerialization()
				.registerTypeAdapter(Date.class, new GsonDateDeserializer())
				.registerTypeAdapter(Calendar.class, new GsonCalendarDeserializer())			
				.create();
	}

	public Gson getGson() throws RuntimeException{
		if(gson != null)
			return gson;
		else
			throw new RuntimeException("Gson is Null - Generated Gson Before Start");
	}

}
