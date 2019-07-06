package br.com.codecode.workix.tests.android;

import br.com.codecode.workix.gson.util.deserializer.GsonCalendarDeserializer;
import br.com.codecode.workix.gson.util.deserializer.GsonDateDeserializer;
import br.com.codecode.workix.gson.util.deserializer.GsonLocalDateDeserializer;
import br.com.codecode.workix.gson.util.deserializer.GsonLocalDateTimeDeserializer;
import br.com.codecode.workix.gson.util.serializer.GsonLocalDateSerializer;
import br.com.codecode.workix.gson.util.serializer.GsonLocalDateTimeSerializer;
import br.com.codecode.workix.tests.config.HttpConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


/**
 * BaseTest Class Share Common Fields
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class BaseTest {

    /**
     * Must Be Changed Startup Configuration
     * 
     * @see HttpConfig 
     * @see HttpConfig #JAVAEE_PROJ_PROD or
     * @see HttpConfig #JAVAEE_PROJ_TEST
     */
    protected final String server = HttpConfig.JAVAEE_PROJ_TEST;

    private final Gson gson;

    protected BaseTest() {

	gson = buildGson();

	if (gson == null) throw new RuntimeException("Gson is Null - Generated Gson Before Start");

    }

    /**
     * Generate a Custom Gson attempt for DateFormat , Pattern Must be Equals
     * {@link JacksonContextResolver #init()}
     * 
     * @return a New Gson
     */
    private Gson buildGson() {
	return new GsonBuilder()
		
		.setPrettyPrinting()
		
		.setDateFormat(new SimpleDateFormat().toPattern())
		
		.enableComplexMapKeySerialization()	
		
		.registerTypeAdapter(LocalDate.class, new GsonLocalDateSerializer())
		
		.registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeSerializer())
		
		.registerTypeAdapter(Date.class, new GsonDateDeserializer())
		
		.registerTypeAdapter(Calendar.class, new GsonCalendarDeserializer())
		
		.registerTypeAdapter(LocalDate.class, new GsonLocalDateDeserializer())
		
		.registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeDeserializer())
		
		.create();
    }

    protected Gson getGson() throws RuntimeException {
	if (gson != null)
	    return gson;
	else
	    throw new RuntimeException("Gson is Null - Generated Gson Before Start");
    }

}
