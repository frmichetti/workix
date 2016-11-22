package br.com.codecode.workix.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.codecode.workix.jaxrs.deserializer.CalendarDeserializer;
/**
 * This Class define Startup Properties for Jackson
 * @author felipe
 *
 */
@Provider
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

	private static final ObjectMapper om = init();

	@Override 
	public ObjectMapper getContext(Class<?> objectType) {
		return om;
	}

	private static ObjectMapper init() {

		ObjectMapper om = new ObjectMapper()				
				
				.setLocale(new Locale("Portuguese", "Brazil"))
				
				.setDateFormat(new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss"))

				.registerModule(new JavaTimeModule())

				.registerModule(new SimpleModule()
						.addDeserializer(Calendar.class,new CalendarDeserializer()))
				
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				
				.enable(SerializationFeature.INDENT_OUTPUT);			

		return om;
	}
}
