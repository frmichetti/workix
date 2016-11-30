package br.com.codecode.workix.tests.funcional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.codecode.workix.tests.util.HttpConfig;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonCalendarDeserializer;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonDateDeserializer;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonLocalDateDeserializer;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonLocalDateTimeDeserializer;
import br.com.codecode.workix.tests.util.gson.serializer.GsonLocalDateSerializer;
import br.com.codecode.workix.tests.util.gson.serializer.GsonLocalDateTimeSerializer;

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
     * @see {@link HttpConfig} {@link HttpConfig #JAVAEE_PROJ_PROD} or
     *      {@link HttpConfig #JAVAEE_PROJ_TEST}
     */
    protected String server = HttpConfig.JAVAEE_PROJ_TEST;

    private Gson gson;

    public BaseTest() {

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

    public Gson getGson() throws RuntimeException {
	if (gson != null)
	    return gson;
	else
	    throw new RuntimeException("Gson is Null - Generated Gson Before Start");
    }

}
