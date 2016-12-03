
package br.com.codecode.workix.tests.util.gson;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.codecode.workix.core.models.jdk7.root.BaseCandidate;
import br.com.codecode.workix.core.models.jdk7.root.BaseContact;
import br.com.codecode.workix.core.models.jdk7.root.BaseLocale;
import br.com.codecode.workix.core.models.jdk7.root.BaseUser;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonCalendarDeserializer;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonCandidateDeserializer;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonDateDeserializer;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonLocalDateDeserializer;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonLocalDateTimeDeserializer;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonLocaleDeserializer;
import br.com.codecode.workix.tests.util.gson.deserializer.GsonUserDeserializer;
import br.com.codecode.workix.tests.util.gson.serializer.GsonLocalDateSerializer;
import br.com.codecode.workix.tests.util.gson.serializer.GsonLocalDateTimeSerializer;

/**
 * Gson Singleton Provider
 * 
 * @since 1.1
 * @version 1.0
 * @author felipe
 */
public final class GsonProvider {

    private static GsonProvider instance;

    private GsonProvider(){}

    private static GsonProvider getInstance() {

	if (instance == null) {
	    instance = new GsonProvider();
	}

	return instance;
    }

    /**
     * Generate a Custom Gson <br>
     * <em> attempt for DateFormat</em>
     * 
     * @return a New Gson
     */
    public static Gson buildGson() {
	
	getInstance();
	
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
		
		.registerTypeAdapter(BaseCandidate.class, new GsonCandidateDeserializer())
		
		.registerTypeAdapter(BaseUser.class, new GsonUserDeserializer())
		
		.registerTypeAdapter(BaseLocale.class, new GsonLocalDateDeserializer())
		
		.registerTypeAdapter(BaseContact.class, new GsonLocaleDeserializer())
		
		.create();
    }

}
