package br.com.codecode.workix.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.codecode.workix.jaxrs.deserializer.CalendarDeserializer;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

	private static final ObjectMapper om = init();

	@Override 
	public ObjectMapper getContext(Class<?> objectType) {
		return om;
	}

	private static ObjectMapper init() {

		ObjectMapper om = new ObjectMapper()		

				//.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")) 
				.setDateFormat(new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ssZ"))

				.registerModule(new JavaTimeModule())

				.registerModule(new SimpleModule()
						.addDeserializer(Calendar.class,new CalendarDeserializer()))

				.enable(SerializationFeature.INDENT_OUTPUT)

				.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);

		return om;
	}
}
